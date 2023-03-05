package Enterprisemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class 修改考勤 extends JFrame {
    static Connection con;
    static PreparedStatement sql;
    public static String[]s2=new String[5];
    private JDialog dialog=new JDialog(修改考勤.this,"");
    public  修改考勤() {
        this.setLayout(new GridLayout(5,1));
        JLabel jLabel= new JLabel("请输入员工编号:");
        JTextField field1=new JTextField(5);
        JPanel j1=new JPanel();
        j1.add(jLabel);
        j1.add(field1);

        JPanel j2=new JPanel();
        JLabel jLabel2=new JLabel("请输入修改的考勤日期");
        JTextField field2 = new JTextField(10);
        j2.add(jLabel2);
        j2.add(field2);

        JPanel j3=new JPanel();
        JLabel jLabel3=new JLabel("请输入修改后的信息");
        j3.add(jLabel3);


        JPanel j4=new JPanel();
        JLabel jLabel4=new JLabel("修改后的考勤状态");
        JTextField field3=new JTextField(10);
        JLabel jLabel5=new JLabel("修改后的考勤日期");
        JTextField field4=new JTextField(10);
        j4.add(jLabel4);
        j4.add(field3);
        j4.add(jLabel5);
        j4.add(field4);


        field1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s2[0] = field1.getText();
            }
        });
        field2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                s2[1]=field2.getText();
            }
        });
        field3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                     s2[2]=field3.getText();
            }
        });
        field4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
               s2[3]=field4.getText();
            }
        });

        JButton jButton1=new JButton("确定修改");
        JPanel jPanel=new JPanel();
        jPanel.add(jButton1);


        JButton jButton2=new JButton("确定");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog(修改考勤.this, true);
                dialog.setLayout(new FlowLayout());
                if(s2[0].matches("1\\d{4}")){
                    JLabel l=new JLabel("修改成功");
                    dialog.add(l);
                    dialog.add(jButton2);
                    revise();
                }
                else
                {
                    JLabel l=new JLabel("修改失败,无该员工");
                    dialog.add(l);
                    dialog.add(jButton2);
                }
                dialog.setTitle("增加状态");
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
        this.add(j3);
        this.add(j4);
        this.add(jPanel);
//        this.add(jButton1);
        this.setTitle("考勤界面");
        this.setSize(300,380);
        this.setLocation(600,600);
        this.setVisible(true);
        this.setResizable(false);

    }
    public Connection getConnection() {
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
    public void revise() {

        con = this.getConnection();
        try {
            String sql ="update dbo.考勤信息 set 考勤状态='"+s2[2]+"',考勤时间='"+s2[3]+"' where 考勤时间>'"+s2[1]+"'and 编号='"+s2[0]+"'";
            Statement st=con.createStatement();
            st.executeUpdate(sql);
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
    }
}

