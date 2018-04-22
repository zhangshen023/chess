package cn.lym77.chess.game;

import cn.lym77.data.MyImg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class GameView extends JPanel {
    private int[] map;

    public int[] getMap() {
        return map;
    }

    public void setMap(int[] map) {
        this.map = map;
        try {
            updateView();
        } catch (Exception e) {
        }
    }

    // 0，空；1，选择；
    // 11，黑士；21，红士；
    // 1：士；2：象；3：炮；4：将；5：马；6：卒；7：车
    public GameView(int[] map) {
        this.map = map;
        init();
    }

    private Image getImg(int x) {
        switch (x) {
            case 11:
                return MyImg.ba;
            case 12:
                return MyImg.bb;
            case 13:
                return MyImg.bc;
            case 14:
                return MyImg.bk;
            case 15:
                return MyImg.bn;
            case 16:
                return MyImg.bp;
            case 17:
                return MyImg.br;
            case 21:
                return MyImg.ra;
            case 22:
                return MyImg.rb;
            case 23:
                return MyImg.rc;
            case 24:
                return MyImg.rk;
            case 25:
                return MyImg.rn;
            case 26:
                return MyImg.rp;
            case 27:
                return MyImg.rr;
            case 100:
                return MyImg.oos;
            case 111:
                return MyImg.bas;
            case 112:
                return MyImg.bbs;
            case 113:
                return MyImg.bcs;
            case 114:
                return MyImg.bks;
            case 115:
                return MyImg.bns;
            case 116:
                return MyImg.bps;
            case 117:
                return MyImg.brs;
            case 121:
                return MyImg.ras;
            case 122:
                return MyImg.rbs;
            case 123:
                return MyImg.rcs;
            case 124:
                return MyImg.rks;
            case 125:
                return MyImg.rns;
            case 126:
                return MyImg.rps;
            case 127:
                return MyImg.rrs;
            default:
                return MyImg.oo;
        }
    }

    private BufferedImage getView() {
        int width = 377;
        int height = 417;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        //
        g.drawImage(MyImg.wood, 0, 0, null);
        if (map == null) {
            g.setColor(new Color(0x99000000, true));
            g.fillRect(0, 0, width, height);
            g.setColor(Color.black);
        } else {
            for (int i = 0; i < map.length; i++) {
                int x = i % 9;
                int y = i / 9;
                g.drawImage(getImg(map[i]), 3 + x * 41, 3 + y * 41, null);
            }
        }
        //
        return image;
    }

    public void init() {
        setBounds(0, 0, 377, 417);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                x = (x - 3) / 41;
                int y = e.getY();
                y = (y - 3) / 41;
                if (x < 0 || x > 8 || y < 0 || y > 9) {
                    return;
                }
                onClick(x, y);
            }
        });
    }

    public void onClick(int x, int y) {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(getView(), 0, 0, null);
    }

    public void updateView() {
        getGraphics().drawImage(getView(), 0, 0, null);
    }
}
