package cn.lym77.chess.main;

import cn.lym77.chess.ui.MainFrame;
import cn.lym77.msg.Msg;
import cn.lym77.msg.MsgIo.MsgListener;
import cn.lym77.msg.MsgLogin;
import cn.lym77.util.WindowUtil;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginView extends MainFrame implements MsgListener {

    private MsgLogin msgLogin;

    public LoginView(MsgLogin msgLogin, int color) {
        WindowUtil.center(this);
        this.msgLogin = msgLogin;
    }

    @Override
    public void send() {
        String temp = tfContent.getText().trim();
        if (null == temp || temp.length() < 1) {
            return;
        }
        showMsg(new Msg("我(" + msgLogin.getUserName() + ")", null, temp));
        msgLogin.sendMsg("msg:" + temp);
        tfContent.setText(null);
    }

    @Override
    public void peace() {
        msgLogin.sendMsg("求和");
    }

    @Override
    public void looser() {
    }

    @Override
    public void onReceiveMsg(Msg msg) {
        if (msg.getTo().equals(msgLogin.getUserName())) {
            String content;
            if ((content = msg.getContent()).contains("msg:")) {
                msg.setContent(content.replace("msg:", ""));
                showMsg(msg);
            }
        }
    }

    //格式化时间
    private SimpleDateFormat sdf = new SimpleDateFormat(" hh:mm:ss\n");

    public void showMsg(Msg msg) {
        String all = "\n";
        all += msg.getFrom();
        all += sdf.format(new Date());
        all += " " + msg.getContent();
        String temp = taMsg.getText();
        if (temp.length() < 5000) {
            all = (temp + all);
        }
        all = all.trim();
        taMsg.setText(all);
        taMsg.setCaretPosition(all.length());
    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void onReceiveErr(String err) {
        JOptionPane.showMessageDialog(this, err);
        System.exit(0);
    }

    @Override
    public void loginSuccess() {

    }
}
