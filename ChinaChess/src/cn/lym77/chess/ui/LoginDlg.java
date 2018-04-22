/*
 * LoginDlg.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.lym77.chess.ui;

import cn.lym77.chess.main.Main;
import cn.lym77.data.MyMp3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author __USER__
 */
public class LoginDlg extends JDialog {
    public interface LoginDlgListener {
        void join(String selfName, String otherName);

        void create(String selfName, String otherName);
    }

    private LoginDlgListener listener;

    /**
     * Creates new form LoginDlg
     */
    public LoginDlg(Frame parent, boolean modal,
                    LoginDlgListener listener) {
        super(parent, modal);
        this.listener = listener;
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tfOther.setBorder(null);
        tfSelf.setBorder(null);
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        bgPanel = new JPanel();
        jLayeredPane1 = new JLayeredPane();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        btCreate = new JButton();
        btJoin = new JButton();
        jPanel2 = new JPanel();
        tfSelf = new JTextField();
        tfOther = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("中国象棋");
        setResizable(false);

        bgPanel.setBackground(new Color(51, 51, 51));

        jLayeredPane1.setBackground(new Color(255, 255, 255));

        jPanel3.setBackground(new Color(0, 102, 102));
        jPanel3.setOpaque(false);

        jPanel1.setOpaque(false);

        btCreate.setBackground(new Color(0, 153, 153));
        btCreate.setFont(new Font("微软雅黑", 0, 16));
        btCreate.setForeground(new Color(255, 255, 255));
        btCreate.setText("创建游戏");
        btCreate.setBorderPainted(false);
        btCreate.setFocusPainted(false);
        btCreate.addActionListener((ActionEvent evt) -> btCreateActionPerformed(evt));

        btJoin.setBackground(new Color(0, 153, 0));
        btJoin.setFont(new Font("微软雅黑", 0, 16));
        btJoin.setForeground(new Color(255, 255, 255));
        btJoin.setText("加入游戏");
        btJoin.setBorderPainted(false);
        btJoin.setFocusPainted(false);
        btJoin.addActionListener(evt -> btJoinActionPerformed(evt));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout
                .setHorizontalGroup(jPanel1Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout
                                .createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btCreate)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(btJoin)
                                .addGap(23, 23, 23)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout
                        .createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(btCreate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btJoin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE)));

        jPanel2.setOpaque(false);

        tfSelf.setFont(new Font("微软雅黑", 0, 18));
        tfSelf.setForeground(new Color(0, 0, 153));
        tfSelf.setText("自己名字");
        tfSelf.setBorder(BorderFactory
                .createLineBorder(new Color(204, 204, 204)));
        tfSelf.setDisabledTextColor(new Color(204, 204, 204));
        tfSelf.setEnabled(false);
        tfSelf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                tfSelfMousePressed(evt);
            }
        });
        tfSelf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                tfSelfFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                tfSelfFocusLost(evt);
            }
        });

        tfOther.setFont(new Font("微软雅黑", 0, 18));
        tfOther.setForeground(new Color(0, 0, 153));
        tfOther.setText("对方名字");
        tfOther.setBorder(BorderFactory.createLineBorder(
                new Color(153, 153, 153), 2));
        tfOther.setDisabledTextColor(new Color(204, 204, 204));
        tfOther.setEnabled(false);
        tfOther.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                tfOtherMousePressed(evt);
            }
        });
        tfOther.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                tfOtherFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                tfOtherFocusLost(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(tfOther, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addComponent(tfSelf, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE));
        jPanel2Layout
                .setVerticalGroup(jPanel2Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING,
                                jPanel2Layout
                                        .createSequentialGroup()
                                        .addContainerGap(23, Short.MAX_VALUE)
                                        .addComponent(tfSelf, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfOther, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                        jPanel3Layout
                                .createSequentialGroup()
                                .addContainerGap(270, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                .addGroup(jPanel3Layout
                        .createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout
                                .createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(63, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout
                        .createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(96, Short.MAX_VALUE)));

        jPanel3.setBounds(0, 0, 380, 420);
        jLayeredPane1.add(jPanel3, JLayeredPane.DEFAULT_LAYER);

        GroupLayout bgPanelLayout = new GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(bgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane1, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE));
        bgPanelLayout.setVerticalGroup(bgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(bgPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(bgPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    private void jLabel1MouseReleased(MouseEvent evt) {
        jLabel1.setBackground(new Color(200, 0, 0));
    }

    private void jLabel1MousePressed(MouseEvent evt) {
        jLabel1.setBackground(new Color(100, 0, 0));
    }

    private void jLabel1MouseExited(MouseEvent evt) {
        jLabel1.setOpaque(false);
        jLabel1.setBackground(Color.blue);
    }

    private void jLabel1MouseEntered(MouseEvent evt) {
        jLabel1.setOpaque(true);
        jLabel1.setBackground(new Color(200, 0, 0));

    }


    private void btCreateActionPerformed(ActionEvent evt) {
        create();
    }

    private void btJoinActionPerformed(ActionEvent evt) {
        join();
    }

    public void join() {
        String sName = tfSelf.getText().trim();
        String oName = tfOther.getText().trim();
        if (sName.isEmpty() || "自己名字".equals(sName)) {
            JOptionPane.showMessageDialog(null, "请输入自己的名字！");
            return;
        }
        if (oName.isEmpty() || "对方名字".equals(oName)) {
            JOptionPane.showMessageDialog(null, "请输入对方的名字！");
            return;
        }
        listener.join(sName, oName);
    }

    public void create() {
        String sName = tfSelf.getText().trim();
        String oName = tfOther.getText().trim();
        if (sName.isEmpty() || "自己名字".equals(sName)) {
            JOptionPane.showMessageDialog(null, "请输入自己的名字！");
            return;
        }
        if (oName.isEmpty() || "对方名字".equals(oName)) {
            JOptionPane.showMessageDialog(null, "请输入对方的名字！");
            return;
        }
        listener.create(sName, oName);
    }

    private void tfOtherMousePressed(MouseEvent evt) {
        if (!isLogin) {
            tfOther.setEnabled(true);
            tfOther.requestFocus();
        }
    }

    private void tfSelfMousePressed(MouseEvent evt) {
        if (!isLogin) {
            tfSelf.setEnabled(true);
            tfSelf.requestFocus();
        }
    }

    private void tfOtherFocusLost(FocusEvent evt) {
        if (tfOther.getText().trim().isEmpty()) {
            tfOther.setText("对方名字");
        }
        if ("对方名字".equals(tfOther.getText().trim())) {
            tfOther.setEnabled(false);
        }
    }

    private void tfOtherFocusGained(FocusEvent evt) {
        if ("对方名字".equals(tfOther.getText())) {
            tfOther.setText(null);
        }
    }

    private void tfSelfFocusLost(FocusEvent evt) {
        if (tfSelf.getText().trim().isEmpty()) {
            tfSelf.setText("自己名字");
        }

        if ("自己名字".equals(tfSelf.getText().trim())) {
            tfSelf.setEnabled(false);
        }
    }

    private void tfSelfFocusGained(FocusEvent evt) {
        if ("自己名字".equals(tfSelf.getText())) {
            tfSelf.setText(null);
        }
    }

    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
        if (isLogin) {
            btCreate.setEnabled(false);
            btJoin.setEnabled(false);
        } else {
            btCreate.setEnabled(true);
            btJoin.setEnabled(true);
        }
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    public JPanel bgPanel;
    public JButton btCreate;
    public JButton btJoin;
    private JLabel jLabel1;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    public JTextField tfOther;
    public JTextField tfSelf;
    // End of variables declaration//GEN-END:variables

}