package Enterprisemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 增加考勤 extends JFrame {
    static Connection con;
    static PreparedStatement sql;
    public static String[]s2=new String[2];
    private JDialog dialog=new JDialog(增加考勤.this,"");
    public  增加考勤() {
        this.setLayout(new GridLayout(3,1));
        JLabel jLabel= new JLabel("请输入员工编号:");
        JTextField field1=new JTextField(5);
        JPanel j1=new JPanel();
        j1.add(jLabel);
        j1.add(field1);

        JPanel j2=new JPanel();
        JLabel jLabel2=new JLabel("请输入该员工考勤状态");
        JTextField jTextField = new JTextField(5);
        j2.add(jLabel2);
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
        field1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
              s2[1]=field1.getText();
            }
        });

        JButton jButton1=new JButton("确定增加");
        JPanel jPanel=new JPanel();
        jPanel.add(jButton1);


        JButton jButton2=new JButton("确定");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog(增加考勤.this, true);
                dialog.setLayout(new FlowLayout());
                if(s2[1].matches("1\\d{4}")){
                    JLabel l=new JLabel("增加成功");
                    dialog.add(l);
                    dialog.add(jButton2);
                    inset();
                }
                else
                {
                    JLabel l=new JLabel("无该员工");
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
        this.add(jPanel);
//        this.add(jButton1);
        this.setTitle("考勤界面");
        this.setSize(300,200);
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
    public void inset() {

        con = this.getConnection();
        try {
            sql = con.prepareStatement("insert into dbo.考勤信息(考勤状态,编号,部门) values (?,?,?)");
           sql.setString(1,s2[0]);
           sql.setString(2,s2[1]);
           sql.setString(3,getkq.getDep1(JFrameBackground.s1[0]));
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
    }
}

