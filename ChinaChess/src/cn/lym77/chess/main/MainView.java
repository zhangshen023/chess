package cn.lym77.chess.main;

import cn.lym77.chess.game.Game;
import cn.lym77.chess.game.Game.GameListener;
import cn.lym77.chess.ui.MainFrame;
import cn.lym77.data.MyMp3;
import cn.lym77.msg.Msg;
import cn.lym77.msg.MsgIo;
import cn.lym77.msg.MsgIo.MsgListener;
import cn.lym77.util.WindowUtil;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainView extends MainFrame implements MsgListener, GameListener {

    private MsgIo msgIo;
    private Game game;

    public MainView(MsgIo msgIo, int color) {
        WindowUtil.center(this);
        this.selfTime.setText("00:00");
        this.otherTime.setText("00:00");
        this.msgIo = msgIo;
        this.game = new Game(color, msgIo, this);
        msgIo.addListener(this);
        gamePanel.add(game);
    }

    @Override
    public void send() {
        String temp = tfContent.getText().trim();
        if (null == temp || temp.length() < 1) {
            return;
        }
//        showMsg(new Msg(msgLogin.getUserName(), msgLogin.getOtherName(), temp));
        showMsg(new Msg("��(" + msgIo.getSelfName() + ")", msgIo.getOtherName(), temp));
        msgIo.sendMsg("msg:" + temp);
        tfContent.setText(null);
    }

    @Override
    public void peace() {
        msgIo.sendMsg("���");
    }

    @Override
    public void looser() {
        game.looser();
    }

    @Override
    public void onReceiveMsg(Msg msg) {
        if (msg.getTo().equals(msgIo.getSelfName())) {
            String content;
            if ((content = msg.getContent()).contains("msg:")) {
                msg.setContent(content.replace("msg:", ""));
                showMsg(msg);
            }
        }
    }

    //��ʽ��ʱ��
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

    @Override
    public void onEat() {

    }

    @Override
    public void onUpdateTime(int self, int other) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        selfTime.setText(sdf.format(new Date(self * 1000)));
        otherTime.setText(sdf.format(new Date(other * 1000)));
    }

    @Override
    public void onGameOver(boolean isWin) {
        if (isWin) {

            JOptionPane.showMessageDialog(this, "��ϲ��Ӯ�ˣ�");
        } else {
            JOptionPane.showMessageDialog(this, "���ź������ˣ�");
        }
    }

    @Override
    public void onPeace() {

        JOptionPane.showMessageDialog(this, "���壡");
    }

    @Override
    public void qurryPeace() {
        int i = JOptionPane.showConfirmDialog(this, "�Է�������壬�Ƿ�ͬ�⣿", "���", 2);
        if (i == 0) {
            game.peace();
        }
    }
}
