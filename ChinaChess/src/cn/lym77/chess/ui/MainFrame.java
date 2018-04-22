/*
 * GameFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.lym77.chess.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * @author __USER__
 */
public class MainFrame extends JFrame {

    /**
     * Creates new form GameFrame
     */
    public MainFrame() {
        initComponents();
        taMsg.setDisabledTextColor(Color.black);
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        background = new JLayeredPane();
        gamePanel = new JPanel();
        jLayeredPane2 = new JLayeredPane();
        jScrollPane1 = new JScrollPane();
        taMsg = new JTextArea();
        tfContent = new JTextField();
        btnSend = new JButton();
        jLayeredPane3 = new JLayeredPane();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        otherTime = new JLabel();
        selfTime = new JLabel();
        btnLooser = new JButton();
        btnPeace = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("中国象棋");
        setResizable(false);

        background.setBackground(new Color(209, 192, 137));
        background.setOpaque(true);

        gamePanel.setBackground(new Color(51, 51, 255));
        gamePanel.setOpaque(false);

        GroupLayout gamePanelLayout = new GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(gamePanelLayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 380,
                Short.MAX_VALUE));
        gamePanelLayout.setVerticalGroup(gamePanelLayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 420,
                Short.MAX_VALUE));

        gamePanel.setBounds(20, 30, 380, 420);
        background.add(gamePanel, JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBackground(new Color(0, 255, 51));
        jLayeredPane2.setBorder(BorderFactory.createCompoundBorder());

        taMsg.setBackground(new Color(255, 255, 153));
        taMsg.setColumns(20);
        taMsg.setFont(new Font("Monospaced", 0, 14));
        taMsg.setLineWrap(true);
        taMsg.setRows(5);
        taMsg.setEnabled(false);
        jScrollPane1.setViewportView(taMsg);

        jScrollPane1.setBounds(0, 0, 270, 240);
        jLayeredPane2.add(jScrollPane1, JLayeredPane.DEFAULT_LAYER);

        tfContent.setFont(new Font("Microsoft YaHei UI", 0, 18));
        tfContent.setBorder(BorderFactory
                .createLineBorder(new Color(153, 153, 153)));
        tfContent.addActionListener(evt -> tfContentActionPerformed(evt));
        tfContent.setBounds(0, 250, 190, 30);
        jLayeredPane2.add(tfContent, JLayeredPane.DEFAULT_LAYER);

        btnSend.setBackground(new Color(0, 153, 153));
        btnSend.setFont(new Font("Microsoft YaHei UI", 0, 14));
        btnSend.setForeground(new Color(255, 255, 255));
        btnSend.setText("发送");
        btnSend.setBorderPainted(false);
        btnSend.setFocusPainted(false);
        btnSend.addActionListener((ActionEvent evt) -> btnSendActionPerformed(evt));
        btnSend.setBounds(200, 250, 90, 30);
        jLayeredPane2.add(btnSend, JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBounds(420, 170, 270, 280);
        background.add(jLayeredPane2, JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBackground(new Color(245, 224, 162));
        jLayeredPane3.setBorder(BorderFactory.createEtchedBorder());
        jLayeredPane3.setOpaque(true);

        jLabel1.setFont(new Font("Microsoft YaHei UI", 0, 18));
        jLabel1.setText("对方时间");
        jLabel1.setBounds(60, 20, 80, 24);
        jLayeredPane3.add(jLabel1, JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new Font("Microsoft YaHei UI", 0, 18));
        jLabel2.setText("我方时间");
        jLabel2.setBounds(60, 50, 80, 24);
        jLayeredPane3.add(jLabel2, JLayeredPane.DEFAULT_LAYER);

        otherTime.setFont(new Font("Microsoft YaHei UI", 0, 18));
        otherTime.setForeground(new Color(204, 0, 0));
        otherTime.setText("20:00");
        otherTime.setBounds(140, 20, 100, 24);
        jLayeredPane3.add(otherTime, JLayeredPane.DEFAULT_LAYER);

        selfTime.setFont(new Font("Microsoft YaHei UI", 0, 18));
        selfTime.setForeground(new Color(204, 0, 0));
        selfTime.setText("20:00");
        selfTime.setBounds(140, 50, 100, 24);
        jLayeredPane3.add(selfTime, JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBounds(420, 30, 270, 90);
        background.add(jLayeredPane3, JLayeredPane.DEFAULT_LAYER);

        btnLooser.setBackground(new Color(0, 153, 153));
        btnLooser.setFont(new Font("Microsoft YaHei UI", 0, 14));
        btnLooser.setForeground(new Color(255, 255, 255));
        btnLooser.setText("认输");
        btnLooser.setBorderPainted(false);
        btnLooser.setFocusPainted(false);
        btnLooser.addActionListener(evt -> btnLooserActionPerformed(evt));
        btnLooser.setBounds(580, 130, 90, 30);
        background.add(btnLooser, JLayeredPane.DEFAULT_LAYER);

        btnPeace.setBackground(new Color(0, 153, 153));
        btnPeace.setFont(new Font("Microsoft YaHei UI", 0, 14));
        btnPeace.setForeground(new Color(255, 255, 255));
        btnPeace.setText("求和");
        btnPeace.setBorderPainted(false);
        btnPeace.setFocusPainted(false);
        btnPeace.addActionListener(evt -> btnPeaceActionPerformed(evt));
        btnPeace.setBounds(470, 130, 90, 30);
        background.add(btnPeace, JLayeredPane.DEFAULT_LAYER);

        GroupLayout layout = new GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addComponent(
                background, GroupLayout.DEFAULT_SIZE, 719,
                Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addComponent(
                background, GroupLayout.DEFAULT_SIZE, 484,
                Short.MAX_VALUE));

        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    private void tfContentActionPerformed(ActionEvent evt) {
        send();
    }

    private void btnSendActionPerformed(ActionEvent evt) {
        send();
    }

    public void send() {

    }

    private void btnLooserActionPerformed(ActionEvent evt) {
        looser();
    }

    public void looser() {

    }

    private void btnPeaceActionPerformed(ActionEvent evt) {
        peace();
    }

    public void peace() {

    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private JLayeredPane background;
    public JButton btnLooser;
    public JButton btnPeace;
    public JButton btnSend;
    public JPanel gamePanel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLayeredPane jLayeredPane2;
    private JLayeredPane jLayeredPane3;
    private JScrollPane jScrollPane1;
    public JLabel otherTime;
    public JLabel selfTime;
    public JTextArea taMsg;
    public JTextField tfContent;

}