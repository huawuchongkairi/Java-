package Enterprisemanagementsystem;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class forgetpassword extends JFrame {
    public static String[]s1=new String[6];
    private JDialog dialog=new JDialog(forgetpassword.this,"");
    public forgetpassword(){
        this.setLayout(null);
        JLabel lblLogin= new JLabel("找回个人密码");
        lblLogin.setBounds(100,10,200,30);
        lblLogin.setFont(new Font("楷体",Font.BOLD,20));

        JLabel jLabel1=new JLabel("请输入你的手机号");
        jLabel1.setBounds(20,50,200,30);
        jLabel1.setFont(new Font("楷体",Font.BOLD,20));
        JTextField jTextField1=new JTextField();
        jTextField1.setBounds(200,50,200,30);
        jTextField1.setFont(new Font("楷体",Font.BOLD,20));


        JLabel jLabel2=new JLabel("请输入验证码");
        jLabel2.setBounds(20,100,200,30);
        jLabel2.setFont(new Font("楷体",Font.BOLD,25));
        JTextField jTextField2=new JTextField();
        jTextField2.setBounds(200,100,100,30);
        jTextField2.setFont(new Font("楷体",Font.BOLD,20));
        jTextField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
           s1[1]=jTextField2.getText();
            }
        });








        JButton button3=new JButton("获取验证码");
        button3.setBounds(420,50,150,30);

        button3.setEnabled(false);

        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               button3.setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                   if(jTextField1.getText().length()==0)
                   {
                       button3.setEnabled(false);
                   }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {

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
                 s1[0]=jTextField1.getText();
            }
        });

        JButton button=new JButton("下一步");
        button.setForeground(Color.blue);
        button.setBounds(250,200,100,30);

        JButton button2=new JButton("确定");

        dialog.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));







          button3.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dialog = new JDialog(forgetpassword.this, true);
                  dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
                  if (s1[0].matches("\\d{11,12}")) {
                      JLabel l1 = new JLabel("已发送");
                      dialog.add(l1);
                      dialog.add(button2);

                  } else {
                      JLabel l2 = new JLabel("手机号错误");
                      dialog.add(l2);
                      dialog.add(button2);
                  }
                  dialog.setTitle("发送状态");
                  dialog.setBounds(600, 400, 200, 130);
                  dialog.setVisible(true);
              }

          });








          button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dialog = new JDialog(forgetpassword.this, true);
                  dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
                  if(s1[1].matches("\\w{5}")&&s1[0].matches("\\d{11,12}")){
                      JLabel l = new JLabel("查找成功");
                      dialog.add(l);
                      dialog.add(button2);
                      new search();

                  }
                  else{
                      JLabel l = new JLabel("验证码错误");
                      dialog.add(l);
                      dialog.add(button2);
                  }
                  dialog.setTitle("查找状态");
                  dialog.setBounds(600, 400, 200, 130);
                  dialog.setVisible(true);
              }
          });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        ImageIcon img = new ImageIcon("src\\Enterprisemanagementsystem\\乔巴.jpg");
        JLabel label = new JLabel(img);


        label.setSize(600, 300);

        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JPanel pan = (JPanel) this.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);




        this.setTitle("找回密码");
        this.add(jLabel1);

        this.add(jTextField1);
         this.add(jLabel2);
         this.add(jTextField2);
        this.add(button);
        this.add(button3);
        this.setBounds(300,300,600,300);
        this.setVisible(true);



    }
}
