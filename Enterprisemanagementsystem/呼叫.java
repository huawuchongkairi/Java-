package Enterprisemanagementsystem;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class 呼叫 extends JFrame {

    public static String[]s2=new String[1];
    private JDialog dialog=new JDialog(呼叫.this,"");
    public  呼叫() {
        this.setLayout(new GridLayout(3,1));
//        JFrame jFrame = new JFrame("删除操作");
//        jFrame.setVisible(true);
//        jFrame.setBounds(500, 500, 500, 500);
//        jFrame.setSize(500, 500);
        JLabel jLabel= new JLabel("   请输入要呼叫的员工编号:   ");
        JLabel jLabel1=new JLabel("      ");

        JPanel j1=new JPanel();
        j1.add(jLabel);
        j1.add(jLabel1);
        JTextField jTextField = new JTextField(5);


        JPanel j2=new JPanel();

        j2.add(jTextField);
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


//        this.add(jTextField);
        JButton jButton1=new JButton("点击呼叫");
        JPanel jPanel=new JPanel();
        jPanel.add(jButton1);

//        jButton1.setFont(new Font("楷体",Font.BOLD,25));
//        jButton1.setBounds(500,300,50,50);
//        jButton1.setForeground(Color.black);
        JButton jButton2=new JButton("确定");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog(呼叫.this, true);
                dialog.setLayout(new FlowLayout());
                if(s2[0].matches("1\\d{4}")) {
                    JLabel l = new JLabel("该员工正在赶来");
//                l.setBounds(600,600,80,100);
                    dialog.add(l);
                    dialog.add(jButton2);
                }
                else
                {
                    JLabel l = new JLabel("无该员工");
                    dialog.add(l);
                    dialog.add(jButton2);
                }
                dialog.setTitle("呼叫状态");
                dialog.setBounds(600,600,100,100);
                dialog.setVisible(true);
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
//        this.add(jButton1);
        this.setTitle("呼叫界面");
        this.setSize(300,150);
        this.setLocation(600,600);
        this.setVisible(true);
        this.setResizable(false);

    }
}
