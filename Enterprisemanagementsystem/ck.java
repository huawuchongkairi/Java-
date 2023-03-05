package Enterprisemanagementsystem;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ck extends JFrame {

    public static String[]s2=new String[1];
    private JDialog dialog=new JDialog(ck.this,"");
    public  ck() {
        this.setLayout(new GridLayout(2,1));
//        JFrame jFrame = new JFrame("删除操作");
//        jFrame.setVisible(true);
//        jFrame.setBounds(500, 500, 500, 500);
//        jFrame.setSize(500, 500);
        JLabel jLabel= new JLabel("请输入要删除的员工编号:");


        JPanel j1=new JPanel();
        JTextField jTextField = new JTextField(5);
        j1.add(jLabel);
        j1.add(jTextField);
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
        JButton jButton1=new JButton("点击删除");
        JPanel jPanel=new JPanel();
        jPanel.add(jButton1);

//        jButton1.setFont(new Font("楷体",Font.BOLD,25));
//        jButton1.setBounds(500,300,50,50);
//        jButton1.setForeground(Color.black);
        JButton jButton2=new JButton("确定");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog(ck.this, true);
                dialog.setLayout(new FlowLayout());
                if(s2[0].matches("1\\d{4}")) {
                    JLabel l = new JLabel("删除成功");
//                l.setBounds(600,600,80,100);
                    dialog.add(l);
                    dialog.add(jButton2);
                    delete d1 = new delete();
                    d1.delete1();
                }
                else
                {
                    JLabel l = new JLabel("删除失败");
                    dialog.add(l);
                    dialog.add(jButton2);
                }
                dialog.setTitle("删除状态");
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
        this.add(jPanel);
//        this.add(jButton1);
        this.setTitle("删除界面");
        this.setSize(300,150);
        this.setLocation(600,600);
        this.setVisible(true);
        this.setResizable(false);

    }
}
