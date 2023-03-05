package Enterprisemanagementsystem;

import com.sun.glass.ui.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameBackground extends JFrame  {
    private static String s2;
    static  String[]  s1 = new String[3];

    public static void main(String[] args) {
        new JFrameBackground();
    }
        public JFrameBackground(){


            final JDialog[] dialog = {new JDialog()};
        JFrame frame=new JFrame("登录");
        frame.setBounds(550, 150, 800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel jLabel1=new JLabel("个人编号");
        jLabel1.setFont(new Font("楷体", Font.BOLD, 20));
        jLabel1.setForeground(Color.red);
        jLabel1.setBounds(150, 300, 100, 30);
        JTextField jTextField=new JTextField(20);
        jTextField.setFont(new Font("楷体", Font.BOLD, 20));
        jLabel1.setBounds(150, 300, 100, 30);
        jTextField.setBounds(250, 300, 250, 30);




            jTextField.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    s1[0]=jTextField.getText();
                }
            });




        JLabel jLabel2=new JLabel("登录密码");
        jLabel2.setFont(new Font("楷体", Font.BOLD, 20));
        jLabel2.setForeground(Color.red);
        jLabel2.setBounds(150, 360, 100, 30);
        JPasswordField jPasswordField=new JPasswordField(15);
        jPasswordField.setFont(new Font("楷体", Font.BOLD, 20));
        jPasswordField.setBounds(250, 360, 250, 30);
        jPasswordField.setEchoChar('*');
        jPasswordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                s1[1]=new String(jPasswordField.getPassword());
            }
        });




        JLabel jLabel3=new JLabel("企业考勤系统");
        jLabel3.setFont(new Font("宋体",Font.BOLD,35));
        jLabel3.setForeground(Color.BLUE);
         jLabel3.setBounds(260,50,500,50);

        JLabel jLabel4=new JLabel("职务选择：");
        JComboBox cmb=new JComboBox();    //创建JComboBox
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("员工用户");
        cmb.addItem("部门管理员用户");
        cmb.addItem("管理员用户");
        jLabel4.setFont(new Font("宋体", Font.BOLD,25));
        jLabel4.setForeground(Color.cyan);
        jLabel4.setBounds(150,150,500,30);
          cmb.setBounds(280,150,200,30);
        JTextField field3=new JTextField(100);

        cmb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String zhiwu=cmb.getSelectedItem().toString();
                if(zhiwu.equals("--请选择--")){
                    field3.setText("");
                }else
                {
                    field3.setText(zhiwu);
                    s2=cmb.getSelectedItem().toString();
                }
            }
        });
        field3.setBounds(280,180,200,30);


        JButton jButton=new JButton("登录");
        jButton.setFont(new Font("楷体", Font.BOLD, 20));
        jButton.setBounds(300, 450, 100, 60);
        jButton.setForeground(Color.blue);
         jButton.setBackground(Color.PINK);
        JButton jButton2=new JButton("找回密码");
        jButton2.setFont(new Font("宋体",Font.BOLD,20));
        jButton2.setForeground(Color.red);
        jButton2.setBounds(550,550,150,60);
//        jButton2.setBackground(Color.white);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jButton2){
                    new forgetpassword();
                }
            }
        });



       JButton jButton3=new JButton("确定");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dialog[0] =new JDialog(JFrameBackground.this,true);
                dialog[0].setLayout(new FlowLayout());
                if(e.getSource()==jButton&&s2=="员工用户"){

                    if(s1[0].matches("1\\d{4}")&&s1[1].length()>=8) {
                        new 普通员工();
                        JLabel l = new JLabel("登录成功");
                        dialog[0].add(l);
                        dialog[0].add(jButton3);
                    }
                    else{
                        JLabel l = new JLabel("登录失败");
                        dialog[0].add(l);
                        dialog[0].add(jButton3);
                    }
                    dialog[0].setTitle("登录状态");
                    dialog[0].setBounds(700,600,100,100);
                    dialog[0].setVisible(true);
                }
                else  if(e.getSource()==jButton&&s2=="管理员用户"){

                  if(s1[0].matches("a\\d{3}")) {
                        new 管理员();
                        JLabel l = new JLabel("登录成功");
                        dialog[0].add(l);
                        dialog[0].add(jButton3);
                    }
                    else{
                        JLabel l = new JLabel("登录失败");
                        dialog[0].add(l);
                        dialog[0].add(jButton3);
                    }
                    dialog[0].setTitle("登录状态");
                    dialog[0].setBounds(700,600,100,100);
                    dialog[0].setVisible(true);
                }
                else  if(e.getSource()==jButton&&s2=="部门管理员用户"){
                    if(s1[0].matches("2\\d{4}")&&s1[1].length()>=8){
                        new 部门管理员();
                        JLabel l = new JLabel("登录成功");
                        dialog[0].add(l);
                        dialog[0].add(jButton3);
                    }
                    else{
                        JLabel l = new JLabel("登录失败");
                        dialog[0].add(l);
                        dialog[0].add(jButton3);
                    }
                    dialog[0].setTitle("登录状态");
                    dialog[0].setBounds(700,600,100,100);
                    dialog[0].setVisible(true);

                }


            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog[0].dispose();
            }
        });



        ImageIcon imageIcon=new ImageIcon("src\\背景图片1.jpg");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT));
        JLabel jLabel=new JLabel(imageIcon);
        jLabel.setBounds(0, 0, 800, 800);

        JPanel jPanel=(JPanel)frame.getContentPane();
        jPanel.setOpaque(false);
        jPanel.setLayout(null);

        jPanel.add(jButton);jPanel.add(jButton2);

        jPanel.add(jLabel1);jPanel.add(jTextField);

        jPanel.add(jLabel2);jPanel.add(jPasswordField);



        jPanel.add(jLabel3,BorderLayout.CENTER);

        jPanel.add(cmb);
        jPanel.add(jLabel4);
        jPanel.add(field3);

        frame.getLayeredPane().setLayout(null);
        frame.getLayeredPane().add(jLabel,new Integer(Integer.MIN_VALUE));
        frame.setResizable(false);
//        jPanel.add(dialog);

    }

}
