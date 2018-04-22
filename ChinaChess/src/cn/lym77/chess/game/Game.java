package cn.lym77.chess.game;

import cn.lym77.msg.Msg;
import cn.lym77.msg.MsgIo;
import cn.lym77.msg.MsgIo.MsgListener;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends GameView implements MsgListener {
    public interface GameListener {
        void onEat();

        void onGameOver(boolean isWin);

        void onPeace();

        void onUpdateTime(int self, int other);

        void qurryPeace();
    }

    private GameListener gameListener;
    // ��㣬��㣬�յ�
    private Point saveP, startP, aimP;
    private int color;
    private int step;
    private MsgIo msgIo;
    private int selfTime, otherTime;
    private boolean isStart;

    /**
     * ���췽��
     *
     * @param color ������ɫ��0��ʾ��ɫ��1��ʾ��ɫ
     */
    public Game(int color, MsgIo msgIo, GameListener gameListener) {
        super(null);
        this.color = color;
        this.gameListener = gameListener;
        this.msgIo = msgIo;
        this.setEnabled(false);
        this.setMap(new int[90]);
        msgIo.addListener(this);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Game.this.msgIo.sendLove();
                updateTime();
            }
        }, 1000, 1000);
        startGame();
    }

    /**
     * ��Ϸ����
     *
     * @param msg
     */
    public void end(String msg) {
        isStart = false;
        if (gameListener != null) {
            if (msg.contains("Ӯ")) {
                gameListener.onGameOver(true);
                startGame();
            } else if (msg.contains("��")) {
                gameListener.onGameOver(false);
                startGame();
            } else if (msg.contains("����")) {
                gameListener.onPeace();
                startGame();
            } else if (msg.contains("���")) {
                gameListener.qurryPeace();
            } else if (msg.contains("��ʼ")) {
                initGame();
            }
        }
    }

    /**
     * ��ʼ����Ϸ
     */
    public void initGame() {
        this.step = 0;
        this.saveP = null;
        this.aimP = null;
        this.startP = null;
        this.selfTime = 20 * 60;
        this.otherTime = 20 * 60;
        this.isStart = true;
        this.setEnabled(true);
        if (color == 0) {
            setMap(Rule.getDefaultMap());
        } else {
            setMap(Rule.rotateMap(Rule.getDefaultMap()));
        }
    }

    /**
     * �ж������Ƿ����Լ���
     *
     * @param code
     * @return ����Ƿ���true
     */
    private boolean isSelfChess(int code) {
        if (code % 100 == 0) {
            return false;
        }
        return ((code % 100) / 10 - 1) != color;
    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void loginSuccess() {

    }

    public void looser() {
        sendMsg("��ϲ��Ӯ�ˣ�");
        end("���ź������ˣ�");
    }

    /**
     * ����ת��Ϊ�ַ���
     */
    public String mapToString() {
        String map = step + ":";
        for (int i = 0; i < getMap().length; i++) {
            map = map + getMap()[i] + ",";
        }
        return map;
    }

    /**
     * ���ĳ����
     */
    @Override
    public void onClick(int x, int y) {
        Point p = new Point(x, y);
        // saveP = p;
        // updateSlecet();
        // ����: ���saveP,���startP,�յ�aimP
        // 1.�ж��Ƿ��ֵ��Լ�����������򷵻�
        if (!turnSelf()) {
            return;
        }
        // �ж��Ƿ����Լ�������,������򷵻�
        if (isSelfChess(getMap()[Rule.pointToInt(x, y)])) {
            saveP = p;
            updateSlecet();
            return;
        }
        // 2.�ж��Ƿ���ڴ�㣬������������㷵��
        if (saveP == null) {
            return;
        }
        // 3.�жϴ���ܷ񵽴���㣬�����򷵻�
        if (!Rule.canEat(getMap(), Rule.pointToInt(saveP.x, saveP.y),
                Rule.pointToInt(x, y))) {
            return;
        }
        // 4.��������յ㣬��Ӯ���
        startP = new Point(saveP);
        aimP = p;
        int aim = getMap()[Rule.pointToInt(aimP.x, aimP.y)];
        getMap()[Rule.pointToInt(aimP.x, aimP.y)] = getMap()[Rule.pointToInt(
                startP.x, startP.y)];
        getMap()[Rule.pointToInt(startP.x, startP.y)] = 0;
        saveP = null;
        step++;
        if (gameListener != null) {
            gameListener.onEat();
        }
        updateSlecet();
        if (aim % 10 == 4) {
            // ��Ϸ����
            sendMsg("���ź������ˣ�");
            end("��ϲ��Ӯ�ˣ�");
        } else {
            runAction();
        }
    }

    @Override
    public void onReceiveErr(String err) {
    }

    @Override
    public void onReceiveMsg(Msg msg) {
        if (!msg.getFrom().equals(msgIo.getOtherName())) {
            return;
        }
        if (msg.getContent().contains("msg:")) {
            return;
        }
        String tag[] = msg.getContent().split(":");
        try {
            step = Integer.parseInt(tag[0]);
        } catch (NumberFormatException e1) {
            end(msg.getContent());
            return;
        }
        String maps[] = tag[1].split(",");
        int map[] = new int[maps.length];
        for (int i = 0; i < map.length; i++) {
            map[i] = Integer.parseInt(maps[i]);
        }
        map = Rule.rotateMap(map);
        startP = null;
        aimP = null;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 99) {
                if (startP == null) {
                    startP = Rule.intToPoint(i);
                } else {
                    aimP = Rule.intToPoint(i);
                    break;
                }
            }
        }
        gameListener.onEat();
        setMap(map);
        updateSlecet();
    }

    public void peace() {
        sendMsg("���壡");
        end("���壡");
    }

    public void runAction() {
        gameListener.onEat();
        sendMsg(mapToString());
    }

    public void sendMsg(String msg) {
        Msg m = new Msg(msgIo.getSelfName(), msgIo.getOtherName(), msg);
        msgIo.sendMsg(m);
    }

    public void setGameListener(GameListener gameListener) {
        this.gameListener = gameListener;
    }

    private void startGame() {
        if (color == 1) {
            sendMsg("��ʼ");
            initGame();
        }
    }

    /**
     * �ж��Ƿ��ֵ��Լ�
     *
     * @return
     */
    private boolean turnSelf() {
        return step % 2 == color;
    }

    /**
     * ����ѡ���
     */
    public void updateSlecet() {
        for (int i = 0; i < getMap().length; i++) {
            getMap()[i] %= 100;
        }
        if (saveP != null) {
            getMap()[Rule.pointToInt(saveP.x, saveP.y)] %= 100;
            getMap()[Rule.pointToInt(saveP.x, saveP.y)] += 100;
        }
        if (aimP != null) {
            getMap()[Rule.pointToInt(aimP.x, aimP.y)] %= 100;
            getMap()[Rule.pointToInt(aimP.x, aimP.y)] += 100;
        }
        if (startP != null) {
            getMap()[Rule.pointToInt(startP.x, startP.y)] %= 100;
            getMap()[Rule.pointToInt(startP.x, startP.y)] += 100;
        }
        setMap(getMap());
    }

    public void updateTime() {
        if (!isStart) {
            return;
        }
        if (turnSelf()) {
            selfTime--;
            if (selfTime <= 0) {
                sendMsg("��ϲ��Ӯ�ˣ�");
                end("���ź�������!");
                return;
            }
        } else {
            otherTime--;
            if (otherTime <= 0) {
                sendMsg("���ź�������!");
                end("��ϲ��Ӯ�ˣ�");
                return;
            }
        }
        gameListener.onUpdateTime(selfTime, otherTime);
    }
}
