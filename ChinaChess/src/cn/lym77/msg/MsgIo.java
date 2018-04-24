package cn.lym77.msg;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class MsgIo {
    private String selfName;
    private String otherName;
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

    private ArrayList<MsgListener> msgLsListeners;

    public MsgIo(String selfName, String otherName) {
        this.selfName = selfName;
        this.otherName = otherName;
        this.msgLsListeners = new ArrayList<MsgListener>();
    }

    private Thread msgThread;

    public void login() {
        if (msgThread == null) {
            new Thread(new Client()).start();
        }
    }

    public void addListener(MsgListener msgListener) {
        msgLsListeners.add(msgListener);
    }

    class Client implements Runnable {
        @Override
        public void run() {
            try {
                // 登陆
                if (login()) {
                    loginSuccess();
                } else {
                    loginFailed();
                    return;
                }

                String data = null;
                while ((data = Msg.read(socket)) != null) {
                    try {
                        Msg msg = new Msg(data);
                        onReceiveMsg(msg);
                    } catch (Exception e) {
                        onReceiveErr(data);

                    }

                }
            } catch (Exception e) {
            }
        }

        private boolean login() {
            try {
                socket = new Socket(InetAddress.getByName(ip), port);
                Msg.send(socket, selfName + password);
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

    public void sendMsg(final Msg msg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Msg.send(socket, msg.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMsg(final String msg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Msg m = new Msg(selfName, otherName, msg);
                    Msg.send(socket, m.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendLove() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Msg.send(socket, "\n");
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public void onReceiveErr(String data) {
        try {
            for (MsgListener msgListener : msgLsListeners) {
                msgListener.onReceiveErr(data);
            }
        } catch (Exception e) {
        }
    }

    public void onReceiveMsg(Msg msg) {
        try {
            for (MsgListener msgListener : msgLsListeners) {
                if (msg.getContent().indexOf("ONLINE:") == 0) {
                    //在线棋友
                    if (msgListener instanceof OnlinePersonMsgListener) {
                        ((OnlinePersonMsgListener) msgListener).onReceiveOnlinePersonMsg(msg);
                        break;
                    }

                }
                msgListener.onReceiveMsg(msg);
            }
        } catch (Exception e) {
        }
    }

    public void loginFailed() {
        try {
            for (MsgListener msgListener : msgLsListeners) {
                msgListener.loginFailed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginSuccess() {
        try {
            for (MsgListener msgListener : msgLsListeners) {
                msgListener.loginSuccess();
            }
        } catch (Exception e) {
        }

    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
}
