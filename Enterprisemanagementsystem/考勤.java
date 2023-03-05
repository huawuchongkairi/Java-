package Enterprisemanagementsystem;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class 考勤 extends JFrame {

    public static String[]s2=new String[2];
    private JDialog dialog=new JDialog(考勤.this,"");
    public  考勤() {
        this.setLayout(new GridLayout(2,1));
        JLabel jLabel= new JLabel("请输入要查看的考勤日期:");
        JPanel j1=new JPanel();
        j1.add(jLabel);

        JPanel j2=new JPanel();
        JTextField jTextField = new JTextField(12);
       JTextField jTextField1=new JTextField(12);
        j2.add(jTextField);
        j2.add(jTextField1);

        jTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s2[0] = jTextField.getText();
            }
        });
        jTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                  s2[1]=jTextField1.getText();
            }
        });


//        this.add(jTextField);
        JButton jButton1=new JButton("点击查看");
        JPanel jPanel=new JPanel();
        jPanel.add(jButton1);


        JButton jButton2=new JButton("确定");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog(考勤.this, true);
                dialog.setLayout(new FlowLayout());
                    JLabel l = new JLabel("考勤信息如下:");
                     view v1=new view();

            }

        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        this.add(j1);
        this.add(j2);
        this.add(jPanel);

        this.setTitle("考勤界面");
        this.setSize(300,150);
        this.setLocation(600,600);
        this.setVisible(true);
        this.setResizable(false);

    }
}
