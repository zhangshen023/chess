package cn.lym77.msg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class MsgOnLine {

    // 服务器口令
    private String password = "lym77";
    // private String ip="121.42.38.117";
    // 服务器地址
    public static String ip = "127.0.0.1";
    public static int port = 8888;
    public Socket socket;

    public interface MsgListener {
        void onReceiveMsg(Msg msg);

        void loginFailed();

        void onReceiveErr(String err);

        void loginSuccess();
    }

    private ArrayList<OnlinePersonMsgListener> msgLsListeners;

    public MsgOnLine() {

        this.msgLsListeners = new ArrayList<OnlinePersonMsgListener>();
    }

    private Thread msgThread;

    public void beginConnect() {
        if (msgThread == null) {
            msgThread = new Thread(new OnlinePersonThread());
            msgThread.start();
        }
    }

    public void addListener(OnlinePersonMsgListener msgListener) {
        msgLsListeners.add(msgListener);
    }

    class OnlinePersonThread implements Runnable {
        @Override
        public void run() {
            try {
                // 登陆
                if (!connectServer()) {
                    connetFailed();
                    return;
                }
                String data = null;
                while (true) {
                    while ((data = Msg.read(socket)) != null) {
                        try {
                            Msg msg = new Msg("", "", data);
                            onReceiveMsg(msg);
                        } catch (Exception e) {
                            onReceiveErr(data);

                        }
                    }
                }
            } catch (Exception e) {
            }
        }

        private boolean connectServer() {
            try {
                socket = new Socket(InetAddress.getByName(ip), port);
                Msg.send(socket, "ONLINE:" + password);
                String data = null;
                if ((data = Msg.read(socket)) != null) {
                    if (data.contains("success")) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
            return false;
        }
    }

    public boolean login(String userName) {
         {
            try {
                if (socket == null) {
                    socket = new Socket(InetAddress.getByName(ip), port);
                }
                Msg.send(socket, "LOGIN:" + userName);
                String data = null;
                if ((data = Msg.read(socket)) != null) {
                    if (data.contains("success")) {
                        return true;
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
                return false;
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }
        return false;
    }


    public void onReceiveErr(String data) {
        try {
            for (OnlinePersonMsgListener msgListener : msgLsListeners) {
                msgListener.onReceiveOnlinePersonErr(data);
            }
        } catch (Exception e) {
        }
    }

    public void onReceiveMsg(Msg msg) {
        try {
            for (OnlinePersonMsgListener msgListener : msgLsListeners) {
                if (msg.getContent().indexOf("ONLINE:") == 0) {
                    msg.setContent(msg.getContent().substring("ONLINE:".length()));
                    //在线棋友
                    (msgListener).onReceiveOnlinePersonMsg(msg);
                    break;

                }
            }
        } catch (Exception e) {
        }
    }

    public void connetFailed() {
        try {
            for (OnlinePersonMsgListener msgListener : msgLsListeners) {
                msgListener.onReceiveOnlinePersonErr("连接后台服务器失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
