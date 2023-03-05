package Enterprisemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 管理员 extends JFrame {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;


    public static void main(String[] args) {
        new 管理员();
    }


    public  管理员() {
        JFrame jf = new JFrame("管理员界面");

        ImageIcon img = new ImageIcon("src\\Enterprisemanagementsystem\\管理员.jpg");
        JLabel label = new JLabel(img);


        label.setSize(img.getIconWidth(), img.getIconHeight());

        jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JPanel pan = (JPanel) jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);

       JLabel jTextField1 = new JLabel("尊贵的管理员用户");
        jTextField1.setBackground(Color.cyan);
        jTextField1.setForeground(Color.red);
        jTextField1.setFont(new Font("楷体", Font.BOLD, 30));
        jTextField1.setBounds(350, 100, 280, 30);

        JLabel jTextField2 = new JLabel("您想要:");
        jTextField2.setBackground(Color.cyan);
        jTextField2.setForeground(Color.MAGENTA);
        jTextField2.setFont(new Font("楷体", Font.BOLD, 25));
        jTextField2.setBounds(100, 300, 100, 50);

        JLabel jTextField3 = new JLabel("员工管理中心");
        jTextField3.setBackground(Color.cyan);
        jTextField3.setForeground(Color.MAGENTA);
        jTextField3.setFont(new Font("楷体", Font.BOLD, 22));
        jTextField3.setBounds(100, 400, 150, 50);


        JButton btn1 = new JButton("续茶");
        JButton btn4 = new JButton("递烟");
        JButton btn2 = new JButton("呼叫秘书");
        JButton btn3 = new JButton("下工");

        btn1.setBounds(210, 300, 80, 50);
        btn1.setFont(new Font("宋体", Font.BOLD, 20));

        btn2.setFont(new Font("宋体", Font.BOLD, 20));
        btn2.setBounds(310, 300, 150, 50);

        btn3.setFont(new Font("宋体", Font.BOLD, 20));
        btn3.setBounds(490, 300, 80, 50);

        btn4.setFont(new Font("宋体", Font.BOLD, 20));
        btn4.setBounds(590, 300, 80, 50);


        JButton btn5 = new JButton("员工基本信息");
        JButton btn6 = new JButton("添加员工信息");
        JButton btn7 = new JButton("删除员工信息");
        JButton btn8 = new JButton("修改员工信息");
        JButton btn10=new JButton("增加部门信息");
        JButton btn11=new JButton("删除部门");
        JButton btn12=new JButton("修改部门信息");


        btn5.setFont(new Font("宋体", Font.BOLD, 18));
        btn5.setBounds(280, 400, 150, 50);

        btn6.setFont(new Font("宋体", Font.BOLD, 18));
        btn6.setBounds(480, 400, 150, 50);

        btn7.setFont(new Font("宋体", Font.BOLD, 18));
        btn7.setBounds(680, 400, 150, 50);

        btn8.setFont(new Font("宋体", Font.BOLD, 18));
        btn8.setBounds(280, 480, 150, 50);

        btn10.setFont(new Font("宋体", Font.BOLD, 18));
        btn10.setBounds(480, 480, 150, 50);
        btn11.setFont(new Font("宋体", Font.BOLD, 18));
        btn11.setBounds(280, 560, 150, 50);
        btn12.setFont(new Font("宋体", Font.BOLD, 18));
        btn12.setBounds(480, 560, 150, 50);


        JButton btn9=new JButton("返回登录界面");
        btn9.setFont(new Font("宋体",Font.BOLD,20));
        btn9.setBounds(750,600,180,50);
        btn9.setForeground(Color.cyan);
        btn9.setBackground(Color.DARK_GRAY);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jf.dispose();
                new JFrameBackground();
            }
        });


        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("续茶")) {
                    JOptionPane.showMessageDialog(btn1, "您叫的茶正在路上");
                } else if (e.getActionCommand().equals("呼叫秘书")) {
                    JOptionPane.showMessageDialog(btn2, "秘书正在赶来");
                } else if (e.getActionCommand().equals("下工")) {
                    JOptionPane.showMessageDialog(btn3, "已通知各部门下工");
                } else if (e.getActionCommand().equals("递烟")) {
                    JOptionPane.showMessageDialog(btn4, "小弟正来递烟");
                } else if (e.getActionCommand().equals("员工基本信息")) {
                   Test t1=new Test();
//
                }
                else if(e.getActionCommand().equals("添加员工信息")){
                    new enroll();
                }
                else if(e.getActionCommand().equals("删除员工信息")){
                    new ck();

                }
                else if(e.getActionCommand().equals("修改员工信息")){
                          new xiugai();
                }
            }
        };

        JLabel jLabel1=new JLabel("当前时间");
        jLabel1.setBounds(500,700,150,60);
        jLabel1.setFont(new Font("楷体",Font.BOLD,25));
        jLabel1.setForeground(Color.red);

        JLabel t1=new JLabel();
        final JLabel varTime = t1;
        Timer timeAction = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long timemillis = System.currentTimeMillis();
                //转换日期显示格式
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                varTime.setText(df.format(new java.util.Date(timemillis)));
            }
        });
        timeAction.start();
        t1.setForeground(Color.red);
       t1.setFont(new Font("楷体",Font.BOLD,20));
       t1.setBounds(700,700,300,60);





        btn1.addActionListener(actionListener);
        btn2.addActionListener(actionListener);
        btn3.addActionListener(actionListener);
        btn4.addActionListener(actionListener);
        btn5.addActionListener(actionListener);
        btn6.addActionListener(actionListener);
        btn7.addActionListener(actionListener);
        btn8.addActionListener(actionListener);
        jf.add(jTextField1);
        jf.add(jTextField2);
        jf.add(jTextField3);
        jf.add(btn1);
        jf.add(btn2);
        jf.add(btn3);
        jf.add(btn4);
        jf.add(btn5);
        jf.add(btn6);
        jf.add(btn7);
        jf.add(btn8);
        jf.add(btn9);
        jf.add(btn10);
        jf.add(btn11);
        jf.add(btn12);
        jf.add(jLabel1);
        jf.add(t1);


        jf.setSize(img.getIconWidth(), img.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
