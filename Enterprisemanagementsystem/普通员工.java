package Enterprisemanagementsystem;

import com.sun.org.apache.bcel.internal.generic.Select;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.Calendar;

public class 普通员工 extends JFrame {
    static Connection con;
   private JTable tabDemo ;
   private JTableHeader jth;
   private JScrollPane scpDemo;


    static PreparedStatement sql;
    static ResultSet res;
    private JDialog dialog=new JDialog(普通员工.this,"");
    public static void main(String[] args) {
        new 普通员工();
    }
    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionUrl =
                "jdbc:sqlserver://127.0.0.1:1433;"
                        + "databaseName=企业考勤系统;"
                        + "user=sa;"
                        + "password=123456;";
        try {
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public 普通员工() {

        JFrame jf = new JFrame("普通用户界面");

        ImageIcon img = new ImageIcon("src\\Enterprisemanagementsystem\\打工人你好.jpg");
        JLabel label = new JLabel(img);

        label.setSize(img.getIconWidth(), img.getIconHeight());

        jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JPanel pan = (JPanel) jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);

        JLabel jTextField1 = new JLabel("普通用户员工,你好");
        jTextField1.setBackground(Color.cyan);
        jTextField1.setForeground(Color.red);
        jTextField1.setFont(new Font("楷体", Font.BOLD, 30));
        jTextField1.setBounds(300, 100, 350, 30);

        JTextField jTextField2 = new JTextField("考勤中心");
        jTextField2.setBackground(Color.cyan);
        jTextField2.setForeground(Color.MAGENTA);
        jTextField2.setFont(new Font("楷体", Font.BOLD, 25));
        jTextField2.setBounds(100, 300, 120, 50);

        JTextField jTextField3=new JTextField("查看中心");
        jTextField3.setBackground(Color.cyan);
        jTextField3.setForeground(Color.MAGENTA);
        jTextField3.setFont(new Font("楷体", Font.BOLD, 25));
        jTextField3.setBounds(100, 500, 120, 50);



        JButton btn1 = new JButton("上班");
        JButton btn2 = new JButton("下班");
        JButton btn3 = new JButton("请假");
        JButton btn4=new JButton("确定");

        JButton jButton1=new JButton("查看个人信息");
       jButton1.setBounds(300, 500, 200, 50);
       jButton1.setFont(new Font("宋体", Font.BOLD, 20));

       JButton jButton2=new JButton("查看个人考勤");
        jButton2.setBounds(520, 500, 200, 50);
        jButton2.setFont(new Font("宋体", Font.BOLD, 20));








       jButton1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
//               dialog = new JDialog(普通员工.this, true);
//               dialog.setLayout(new FlowLayout());
//               JLabel l=new JLabel("查询成功");
//               dialog.add(l);
//               dialog.add(btn4);
               new view1();
           }
       });

       jButton2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             new 个人考勤();
           }
       });





//   JFrameBackground j1=new JFrameBackground();
        btn1.setBounds(300, 300, 80, 50);
        btn1.setFont(new Font("宋体", Font.BOLD, 20));


        String[] s5=new String[3];



        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
            con=普通员工.getConnection();
                dialog = new JDialog(普通员工.this, true);
                dialog.setLayout(new FlowLayout());
                JLabel l=new JLabel("打卡成功");
                dialog.add(l);
                dialog.add(btn4);
            try{
                s5[0]=get.getDep(JFrameBackground.s1[0]);
              sql=con.prepareStatement("insert into dbo.考勤信息(考勤状态,编号,部门) values ('上班',?,?)");
                sql.setString(1,JFrameBackground.s1[0]);
                sql.setString(2, s5[0]);
                sql.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
                dialog.setTitle("打卡状态");
                dialog.setBounds(700,500,100,100);
                dialog.setVisible(true);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                con=普通员工.getConnection();
                dialog = new JDialog(普通员工.this, true);
                dialog.setLayout(new FlowLayout());
                JLabel l=new JLabel("打卡成功");
                dialog.add(l);
                dialog.add(btn4);
                try {
                    s5[0]=get.getDep(JFrameBackground.s1[0]);
                    sql=con.prepareStatement("insert into dbo.考勤信息(考勤状态,编号,部门) values ('下班',?,?)");
                    sql.setString(1,JFrameBackground.s1[0]);
                    sql.setString(2, s5[0]);
                    sql.executeUpdate();
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                dialog.setTitle("打卡状态");
                dialog.setBounds(700,500,100,100);
                dialog.setVisible(true);
            }
        });


        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String[] qj = new String[1];
                con=普通员工.getConnection();
                JFrame jFr=new JFrame("请假");
                jFr.setLayout(new GridLayout(2,2));
                JLabel jLabel88=new JLabel("请假理由");
                jLabel88.setBounds(300,500,150,140);
                JTextField jqj=new JTextField(20);
                jqj.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        qj[0] =jqj.getText();
                    }
                });
                JButton btn10=new JButton("确定");
                btn10.setForeground(Color.red);
                btn10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        try {
                            s5[0]=get.getDep(JFrameBackground.s1[0]);
                            sql=con.prepareStatement("insert into dbo.考勤信息(考勤状态,请假理由,编号,部门) values ('请假',?,?,?)");
                            sql.setString(1,qj[0]);
                            sql.setString(2,JFrameBackground.s1[0]);
                            sql.setString(3, s5[0]);
                            sql.executeUpdate();
                        }catch (Exception e1) {
                            e1.printStackTrace();
                        }finally {
                            if (con != null) {
                                try {
                                    con.close();
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }
                        }
                        jFr.dispose();
                    }
                });
                JPanel 请假=new JPanel();
                JPanel qd=new JPanel();
                qd.add(btn10);
                请假.add(jLabel88);
                请假.add(jqj);
                jFr.setVisible(true);

                jFr.setBounds(600,600,300,140);
//                jqj.setBounds(420,500,300,300);
                jFr.add(请假);
                jFr.add(qd);

//                jf.add(jFr);

            }
        });



        btn2.setFont(new Font("宋体", Font.BOLD, 20));
        btn2.setBounds(420, 300, 80, 50);
        btn3.setFont(new Font("宋体", Font.BOLD, 20));
        btn3.setBounds(540, 300, 80, 50);

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

        jf.add(jTextField1);
        jf.add(jTextField2);
        jf.add(jTextField3);
        jf.add(jButton1);
        jf.add(jButton2);
        jf.add(btn1);
        jf.add(btn2);
        jf.add(btn3);
        jf.add(btn9);
//          jf.add(jFr)

        jf.setSize(img.getIconWidth(), img.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);


    }
}
