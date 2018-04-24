package cn.lym77.chess.main;

import cn.lym77.chess.domain.User;
import cn.lym77.chess.game.GameView;
import cn.lym77.chess.ui.LoginRegisterDlg;
import cn.lym77.data.MyImg;
import cn.lym77.data.MyMp3;
import cn.lym77.db.DbUtil;
import cn.lym77.msg.Msg;
import cn.lym77.msg.MsgAdapter;
import cn.lym77.msg.MsgIo;
import cn.lym77.msg.MsgLogin;
import cn.lym77.util.WindowUtil;

import javax.swing.*;
import java.io.*;

public class Main {
    public static LoginRegisterDlg loginRegisterDlg;
    public static MsgLogin msgLogin;
    public static LoginView mainView;
    public static MsgIo msgIo;

    public static void readIp() {
        File file = new File("ip.txt");
        if (file.exists()) {
            InputStream is = null;
            try {
                is = new FileInputStream(file);
                byte[] by = new byte[1024];
                String data = null;
                if (is.read(by) != -1) {
                    data = new String(by);
                }
                if (data != null) {
                    String url[] = data.split(":");
                    MsgIo.ip = url[0].trim();
                    MsgIo.port = Integer.parseInt(url[1].trim());
                }
            } catch (Exception e) {
                MsgIo.ip = "127.0.0.1";
                MsgIo.port = 8888;
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
            }
        } else {
            OutputStream os = null;
            try {
                os = new FileOutputStream(file);
                os.write((MsgIo.ip + ":" + MsgIo.port).getBytes());
            } catch (Exception e) {
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        readIp();
        try {
            MyImg.initImg();
            MyMp3.initMp3();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        showLoginRegisterDlg();
    }

    public static void game(int color) {

        mainView = new LoginView(msgIo, color);
        mainView.setVisible(true);
    }

    public static void showLoginRegisterDlg() {

        if (loginRegisterDlg == null) {
            loginRegisterDlg = new LoginRegisterDlg(null, true, new LoginRegisterDlg.LoginRegDlgListener() {
                @Override
                public void login(String userName, String pwd) {
                    User user = DbUtil.findUserByUserName(userName);
                    if (user == null) {
                        JOptionPane.showMessageDialog(null, "用户不存在");
                    }

                    if (!user.getPwd().equalsIgnoreCase(pwd)) {
                        JOptionPane.showMessageDialog(null, "密码不正确");
                    }
                    msgLogin = new MsgLogin(userName);
                    msgLogin.addListener(new MsgAdapter() {
                        @Override
                        public void loginFailed() {
                            loginRegisterDlg.setLogin(false);
                        }

                        @Override
                        public void loginSuccess() {
                            loginRegisterDlg.setLogin(true);
                            JOptionPane.showMessageDialog(null, "登陆成功");

                        }
                    });
                    loginRegisterDlg.setLogin(true);
                    msgLogin.login(userName);
                }

                @Override
                public void regist(String userName, String pwd) {
                    if (!DbUtil.regist(userName, pwd)) {
                        JOptionPane.showMessageDialog(null, "注册失败");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "注册成功");

                }
            });
            loginRegisterDlg.bgPanel.add(new GameView(null));
        }
        WindowUtil.center(loginRegisterDlg);
        loginRegisterDlg.setVisible(true);
    }

    public static void gameStart(String fromUserName, String toUserName, int color) {
        msgIo = new MsgIo(fromUserName, toUserName);
        loginRegisterDlg.setVisible(false);
        game(color);
        msgIo.login();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Msg msg = new Msg(fromUserName, toUserName, "INVITE:JOIN");
        msgIo.sendMsg(msg);

    }
}
