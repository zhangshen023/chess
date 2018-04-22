/*
 * LoginDlg.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.lym77.chess.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author __USER__
 */
public class LoginRegisterDlg extends JDialog {
    public interface LoginRegDlgListener {

        void login(String userName, String pwd);

        void regist(String userName, String pwd);

    }

    private LoginRegDlgListener listener;

    /**
     * Creates new form LoginDlg
     */
    public LoginRegisterDlg(Frame parent, boolean modal,
                            LoginRegDlgListener listener) {
        super(parent, modal);
        this.listener = listener;
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jPasswordField.setBorder(null);
        tfUserName.setBorder(null);
    }

    private void initComponents() {

        userOnlinePanel = new JPanel();
        userOnlinePanel.setLayout(new FlowLayout());
        userOnlinePanel.setForeground(new Color(0, 0, 153));
        JList<String> list = new JList<String>();
        list.setBounds(0, 0, 100, 417);
        String[] stringList = new String[100];
        for (int i = 0; i < 100; i++) {
            stringList[i] = (i + "");
        }
        list.setListData(stringList);
        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new Dimension(100, 375));
        userOnlinePanel.add(jScrollPane);

        bgPanel = new JPanel();
        jLayeredPane1 = new JLayeredPane();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabelOnLinePerson = new JLabel("在线棋友");
        jPanel1 = new JPanel();
        btLogin = new JButton();
        btReg = new JButton();
        jPanel2 = new JPanel();
        tfUserName = new JTextField();
        jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('\0');
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("中国象棋");
        setResizable(false);

        bgPanel.setBackground(new Color(51, 51, 51));

        jLayeredPane1.setBackground(new Color(255, 255, 255));

        jPanel3.setBackground(new Color(0, 102, 102));
        jPanel3.setOpaque(false);

        jPanel1.setOpaque(false);

        btLogin.setBackground(new Color(0, 153, 153));
        btLogin.setFont(new Font("微软雅黑", 0, 16));
        btLogin.setForeground(new Color(255, 255, 255));
        btLogin.setText("登陆");
        btLogin.setBorderPainted(false);
        btLogin.setFocusPainted(false);
        btLogin.addActionListener((ActionEvent evt) -> btLoginActionPerformed(evt));

        btReg.setBackground(new Color(0, 153, 0));
        btReg.setFont(new Font("微软雅黑", 0, 16));
        btReg.setForeground(new Color(255, 255, 255));
        btReg.setText("注册");
        btReg.setBorderPainted(false);
        btReg.setFocusPainted(false);
        btReg.addActionListener(evt -> btRegActionPerformed(evt));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout
                .setHorizontalGroup(jPanel1Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout
                                .createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btLogin)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(btReg)
                                .addGap(23, 23, 23)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout
                        .createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(btLogin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btReg, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE)));

        jPanel2.setOpaque(false);

        tfUserName.setFont(new Font("微软雅黑", 0, 18));
        tfUserName.setForeground(new Color(0, 0, 153));
        tfUserName.setText("用户名");
        tfUserName.setBorder(BorderFactory
                .createLineBorder(new Color(204, 204, 204)));
        tfUserName.setDisabledTextColor(new Color(204, 204, 204));
        tfUserName.setEnabled(false);
        tfUserName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                tfSelfMousePressed(evt);
            }
        });
        tfUserName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                tfSelfFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                tfSelfFocusLost(evt);
            }
        });

        jPasswordField.setFont(new Font("微软雅黑", 0, 18));
        jPasswordField.setForeground(new Color(0, 0, 153));
        jPasswordField.setText("密码");
        jPasswordField.setBorder(BorderFactory.createLineBorder(
                new Color(153, 153, 153), 2));
        jPasswordField.setDisabledTextColor(new Color(204, 204, 204));
        jPasswordField.setEnabled(false);
        jPasswordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                tfOtherMousePressed(evt);
            }
        });
        jPasswordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                jPasswordField.setEchoChar('*');
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
                .addComponent(jPasswordField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addComponent(tfUserName, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                        jPanel2Layout
                                .createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(tfUserName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
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
        GroupLayout.ParallelGroup parallelGroup =
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabelOnLinePerson)
                        .addComponent(userOnlinePanel);
        GroupLayout.SequentialGroup sequentialGroup =
                layout.createSequentialGroup()
                        .addComponent(jLabelOnLinePerson)
                        .addComponent(userOnlinePanel);
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(bgPanel)
                .addGroup(parallelGroup));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(bgPanel)
                .addGroup(sequentialGroup));

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


    private void btLoginActionPerformed(ActionEvent evt) {
        loginAction();
    }

    private void btRegActionPerformed(ActionEvent evt) {
        reg();
    }

    public void reg() {
        String sName = tfUserName.getText().trim();
        String oName = jPasswordField.getText().trim();
        if (sName.isEmpty() || "自己名字".equals(sName)) {
            JOptionPane.showMessageDialog(null, "请输入自己的名字！");
            return;
        }
        if (oName.isEmpty() || "对方名字".equals(oName)) {
            JOptionPane.showMessageDialog(null, "请输入对方的名字！");
            return;
        }
        listener.regist(sName, oName);
    }

    public void loginAction() {
        String sName = tfUserName.getText().trim();
        String oName = jPasswordField.getText().trim();
        if (sName.isEmpty() || "用户名".equals(sName)) {
            JOptionPane.showMessageDialog(null, "请输入用户名！");
            return;
        }
        if (oName.isEmpty() || "密码".equals(oName)) {
            JOptionPane.showMessageDialog(null, "请输入密码！");
            return;
        }
        listener.login(sName, oName);
    }

    private void tfOtherMousePressed(MouseEvent evt) {
        if (!isLogin) {
            jPasswordField.setEnabled(true);
            jPasswordField.requestFocus();
        }
    }

    private void tfSelfMousePressed(MouseEvent evt) {
        if (!isLogin) {
            tfUserName.setEnabled(true);
            tfUserName.requestFocus();
        }
    }

    private void tfOtherFocusLost(FocusEvent evt) {
        if (jPasswordField.getText().trim().isEmpty()) {
            jPasswordField.setText("密码");
            jPasswordField.setEchoChar('\0');
        }
        if ("密码".equals(jPasswordField.getText().trim())) {
            jPasswordField.setEnabled(false);
        }
    }

    private void tfOtherFocusGained(FocusEvent evt) {
        if ("密码".equals(jPasswordField.getText())) {
            jPasswordField.setText(null);
        }
    }

    private void tfSelfFocusLost(FocusEvent evt) {
        if (tfUserName.getText().trim().isEmpty()) {
            tfUserName.setText("用户名");
        }

        if ("用户名".equals(tfUserName.getText().trim())) {
            tfUserName.setEnabled(false);
        }
    }

    private void tfSelfFocusGained(FocusEvent evt) {
        if ("用户名".equals(tfUserName.getText())) {
            tfUserName.setText(null);
        }
    }

    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
        if (isLogin) {
            btLogin.setEnabled(false);
            btReg.setEnabled(false);
        } else {
            btLogin.setEnabled(true);
            btReg.setEnabled(true);
        }
    }

    public JPanel bgPanel;
    public JButton btLogin;
    public JButton btReg;
    private JLabel jLabel1;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    public JPasswordField jPasswordField;
    public JTextField tfUserName;


    //在线人员展示
    public JPanel userOnlinePanel;
    private JLabel jLabelOnLinePerson;

}