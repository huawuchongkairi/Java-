package Enterprisemanagementsystem;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;

public class 部门管理员 extends JFrame {
    public static void main(String[] args) {
        new 部门管理员();
    }
    String k;
    public  部门管理员() {
        JFrame jf=new JFrame("部门管理员界面");

        ImageIcon img=new ImageIcon("src\\Enterprisemanagementsystem\\部门管理员1.jpg");
        img.setImage(img.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT));

        JLabel label=new JLabel(img);
        label.setBounds(0,0,800,700);


        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);

        JLabel jL=new JLabel("亲爱的部门管理员用户");
      jL.setBackground(Color.cyan);
        jL.setForeground(Color.red);
        jL.setFont(new Font("楷体", Font.BOLD, 30));
        jL.setBounds(250,100,350,30);

        JLabel jLabel=new JLabel("您想要:");
        jLabel.setBackground(Color.cyan);
        jLabel.setForeground(Color.MAGENTA);
        jLabel.setFont(new Font("楷体", Font.BOLD, 25));
        jLabel.setBounds(100,300,100,50);




        JButton btn1=new JButton("请求上司");
        JButton btn2=new JButton("呼叫下属");
       JButton btn3=new JButton("查看考勤");
       JButton btn5=new JButton("增加考勤信息");
       JButton btn6=new JButton("删除考勤信息");
       JButton btn7=new JButton("修改考勤信息");
       JButton btn4=new JButton("返回登录界面");

        btn1.setBounds(200,300,150,50);
        btn1.setFont(new Font("宋体",Font.BOLD,20));

        btn2.setFont(new Font("宋体",Font.BOLD,20));
        btn2.setBounds(400,300,150,50);

        btn3.setFont(new Font("宋体",Font.BOLD,20));
        btn3.setBounds(600,300,150,50);


        btn5.setFont(new Font("宋体",Font.BOLD,20));
        btn5.setBounds(200,400,180,50);
        btn6.setFont(new Font("宋体",Font.BOLD,20));
        btn6.setBounds(400,400,180,50);
        btn7.setFont(new Font("宋体",Font.BOLD,20));
        btn7.setBounds(600,400,180,50);

//        JComboBox comboBox=new JComboBox();
//        comboBox.addItem("--请选择功能--");
//        comboBox.addItem("增加考勤信息");
//        comboBox.addItem("删除考勤信息");
//        comboBox.addItem("修改考勤信息");
//        JPanel panel=new JPanel();
//        panel.add(comboBox);
//        panel.setFont(new Font("宋体",Font.BOLD,25));
//        panel.setBounds(300,400,120,25);





        btn4.setFont(new Font("宋体",Font.BOLD,20));
        btn4.setBounds(550,550,180,50);

        btn4.setForeground(Color.cyan);
        btn4.setBackground(Color.DARK_GRAY);

       ActionListener actionListener=new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(e.getActionCommand().equals("请求上司"))
               {
                   JOptionPane.showMessageDialog(btn1,"正在为您请求上司");
               }
               else if(e.getActionCommand().equals("呼叫下属"))
               {
                 new 呼叫();
               }
               else if(e.getActionCommand().equals("查看考勤"))
               {
                new 考勤();

               }
               else if(e.getActionCommand().equals("增加考勤信息"))
               {
                   new 增加考勤();

               }
               else if(e.getActionCommand().equals("删除考勤信息"))
               {
                   new 删除考勤();
               }
               else if(e.getActionCommand().equals("修改考勤信息")){
                   new 修改考勤();
               }
               else if(e.getActionCommand().equals("返回登录界面"))
               {
                   jf.dispose();
                   new JFrameBackground();
               }

           }

       };







        JLabel jLabel1=new JLabel("当前时间");
        jLabel1.setBounds(390,600,150,60);
        jLabel1.setFont(new Font("楷体",Font.BOLD,25));
        jLabel1.setForeground(Color.black);

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
        t1.setForeground(Color.blue);
        t1.setFont(new Font("楷体",Font.BOLD,25));
        t1.setBounds(500,600,300,60);



        btn1.addActionListener(actionListener);
        btn2.addActionListener(actionListener);
        btn3.addActionListener(actionListener);
        btn4.addActionListener(actionListener);
        btn5.addActionListener(actionListener);
        btn6.addActionListener(actionListener);
        btn7.addActionListener(actionListener);


        jf.add(jL);
        jf.add(jLabel);
        jf.add(btn1);
        jf.add(btn2);
        jf.add(btn3);
        jf.add(btn4);
        jf.add(btn5);
        jf.add(btn6);
        jf.add(btn7);



        jf.add(t1);
        jf.add(jLabel1);

        jf.setSize(img.getIconWidth(),img.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);


    }
}
