package Enterprisemanagementsystem;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.Writer;

public class xiugai extends JFrame {
    public static String[]s1=new String[7];//保存注册信息
    private JDialog dialog=new JDialog(xiugai.this,"");
    public xiugai(){

        this.setLayout(new GridLayout(9,1));
        JLabel lblLogin= new JLabel("请依次输入修改后员工信息",JLabel.CENTER);


        JLabel jLabel= new JLabel("请输入要修改的员工编号:");
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
                s1[6] = jTextField.getText();
            }
        });


        JLabel jLabel1=new JLabel("员工编号");
        JTextField field1=new JTextField(25);
        jLabel1.setFont(new Font("楷体",Font.BOLD,20));
        JPanel zhname=new JPanel();
        zhname.add(jLabel1);
        zhname.add(field1);
        field1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s1[0]=field1.getText();
            }
        });


        JLabel jLabe2 = new JLabel("登录密码");
        JTextField field2=new JTextField(25);
//        field2.setEchoChar('#');
        JPanel pwd=new JPanel();
        pwd.add(jLabe2);
        pwd.add(field2);
        field2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s1[1]=field2.getText();
            }
        });


        JLabel jLabel3 = new JLabel("联系电话");
        JTextField field3=new JTextField(25);
        JPanel sj=new JPanel();
        sj.add(jLabel3);
        sj.add(field3);
        field3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s1[2]=field3.getText();
            }
        });


        JLabel jLabel4 = new JLabel("员工姓名");
        JTextField field4=new JTextField(10);
        JPanel xm=new JPanel();
        xm.add(jLabel4);
        xm.add(field4);
        field4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s1[3]=field4.getText();
            }
        });



        JPanel xb=new JPanel();
        JLabel jLabel5 = new JLabel("性别:");
//        JComboBox<String>comboBox=new JComboBox<String>();
//        comboBox.addItem("--性别--");
//        comboBox.addItem("男");
//        comboBox.addItem("女");
//        comboBox.setEditable(true);
        JTextField field5=new JTextField(8);

        xb.add(jLabel5);
        xb.add(field5);
        field5.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s1[4]=field5.getText();
            }
        });



        JLabel jLabel6=new JLabel("部门");
        JTextField field6=new JTextField(8);
        JPanel bm=new JPanel();
        bm.add(jLabel6);
        bm.add(field6);
        field6.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s1[5]=field6.getText();
            }
        });


        JButton jButton = new JButton("点击修改");
        JPanel zc=new JPanel();
        zc.add(jButton);

        JButton jButton2=new JButton("确定");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  judge j1=new judge();
                dialog = new JDialog(xiugai.this, true);
                dialog.setLayout(new FlowLayout());
                if(s1[0].matches("\\d{5}")==true&&s1[1].matches("\\d{8,}")==true&&s1[2].matches("\\d{11,12}")==true&&s1[3].length()!=0&&s1[4].length()!=0&&s1[5].length()!=0)
                {
                    // JButton jButton2=new JButton("成功");
                    JLabel l = new JLabel("修改成功");
                    dialog.add(l);
                    dialog.add(jButton2);


                    update u1=new update();u1.update1();
                }
                else
                {
                    //  JButton jButton2=new JButton("失败");
                    JLabel l = new JLabel("修改失败");
                    dialog.add(l);
                    dialog.add(jButton2);
                }
                dialog.setTitle("修改状态");
                dialog.setBounds(600,400,100,100);
                dialog.setVisible(true);
                //  dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });





        this.add(j1);
        this.add(lblLogin);
        this.add(zhname);


        this.add(pwd);
        this.add(sj);
        this.add(xm);
        this.add(xb);
        this.add(bm);
        this.add(jButton);


        this.setTitle("修改界面");
        this.setSize(300,500);
        this.setLocation(550,150);
        this.setVisible(true);
        this.setResizable(false);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
