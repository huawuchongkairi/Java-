package Enterprisemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.Writer;

public class enroll extends JFrame {
    public static String[]s1=new String[6];//保存注册信息
    private JDialog dialog=new JDialog(enroll.this,"");
    public enroll(){


        this.setLayout(null);
        JLabel lblLogin= new JLabel("添加员工信息");
        lblLogin.setBounds(100,10,200,30);
        lblLogin.setFont(new Font("楷体",Font.BOLD,20));

        JLabel jLabel1=new JLabel("员工编号");

        jLabel1.setBounds(20,50,100,40);

        JTextField field1=new JTextField();

        field1.setBounds(120,50,160,30);
        field1.setFont(new Font("楷体",Font.BOLD,20));
        jLabel1.setFont(new Font("楷体",Font.BOLD,20));


//        JPanel zhname=new JPanel();
////        zhname.add(jLabel1);
////        zhname.add(field1);
        this.add(jLabel1);
        this.add(lblLogin);
        this.add(field1);
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
        jLabe2.setBounds(20,110,100,40);
        JTextField field2=new JTextField();
        field2.setBounds(120,110,160,30);

        field2.setFont(new Font("楷体",Font.BOLD,20));
        jLabe2.setFont(new Font("楷体",Font.BOLD,20));
//        field2.setEchoChar('#');
//        JPanel pwd=new JPanel();
//        pwd.add(jLabe2);
//        pwd.add(field2);
        this.add(jLabe2);
        this.add(field2);
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
        jLabel3.setBounds(20,170,100,40);
        JTextField field3=new JTextField();
        field3.setBounds(120,170,160,30);

        field3.setFont(new Font("楷体",Font.BOLD,20));
        jLabel3.setFont(new Font("楷体",Font.BOLD,20));

        this.add(jLabel3);
        this.add(field3);
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
                jLabel4.setBounds(20,230,100,40);
        JTextField field4=new JTextField();
        field4.setBounds(150,230,100,30);
        field4.setFont(new Font("楷体",Font.BOLD,20));
        jLabel4.setFont(new Font("楷体",Font.BOLD,20));
       this.add(field4);
       this.add(jLabel4);
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



//        JPanel xb=new JPanel();
        JLabel jLabel5 = new JLabel("性别:");
        jLabel5.setBounds(20,290,100,40);
        jLabel5.setFont(new Font("楷体",Font.BOLD,20));
        JComboBox<String>comboBox=new JComboBox<String>();
        comboBox.addItem("--性别--");
        comboBox.addItem("男");
        comboBox.addItem("女");
        comboBox.setEditable(true);
        comboBox.setBounds(150,290,100,30);
        comboBox.setFont(new Font("楷体",Font.BOLD,20));
        this.add(jLabel5);
        this.add(comboBox);
       // comboBox.setEditable(true);
        comboBox.addItemListener(new ItemListener() {
                                     @Override
                                     public void itemStateChanged(ItemEvent e) {
                                         s1[4] = comboBox.getSelectedItem().toString();
                                     }
                                 });



        JLabel jLabel6=new JLabel("部门");
        JTextField field6=new JTextField();
        jLabel6.setBounds(20,350,100,40);
        jLabel6.setFont(new Font("楷体",Font.BOLD,20));
        field6.setBounds(130,350,130,30);
        field6.setFont(new Font("楷体",Font.BOLD,20));
       this.add(jLabel6);
       this.add(field6);
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


                JButton jButton = new JButton("点击添加");
//        JPanel zc=new JPanel();
        this.add(jButton);
        jButton.setBounds(80,400,150,30);
        jButton.setForeground(Color.blue);
       jButton.setFont(new Font("楷体",Font.BOLD,20));
        JButton jButton2=new JButton("确定");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //  judge j1=new judge();
                dialog = new JDialog(enroll.this, true);
                dialog.setLayout(new FlowLayout());
                 if(s1[0].matches("\\d{5}")==true&&s1[1].matches("\\d{8,}")==true&&s1[2].matches("\\d{11,12}")==true&&s1[3].length()!=0&&s1[4].length()!=0&&s1[5].length()!=0)
                 {
                    // JButton jButton2=new JButton("成功");
                     JLabel l = new JLabel("添加成功");
                     dialog.add(l);
                     dialog.add(jButton2);
                     add a1 = new add();
                     a1.insert();
                 }
                 else
                 {
                   //  JButton jButton2=new JButton("失败");
                     JLabel l = new JLabel("注册失败");
                     dialog.add(l);
                     dialog.add(jButton2);
                 }
              dialog.setTitle("注册状态");
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



        ImageIcon img = new ImageIcon("src\\Enterprisemanagementsystem\\绿色.jpg");
        JLabel label = new JLabel(img);


        label.setSize(img.getIconWidth(), img.getIconHeight());

        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JPanel pan = (JPanel) this.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);



        this.add(jButton);

        this.setTitle("注册界面");
        this.setSize(300,500);
        this.setLocation(550,150);
        this.setVisible(true);
        this.setResizable(false);
    }


}
