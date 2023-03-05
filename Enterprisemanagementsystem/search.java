package Enterprisemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class search extends JFrame {

    static Connection con;
    static PreparedStatement sql;
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
    public search(){
        String mm = null;

        con = this.getConnection();
        try {
//            sql=con.prepareStatement("select 登录密码 from 普通员工 where 联系电话=？");
            String s1="select * from 普通员工 where 联系电话='"+forgetpassword.s1[0]+"'";
//            sql.setString(1,forgetpassword.s1[0]);
          Statement sta=con.createStatement();

           ResultSet re =sta.executeQuery(s1);
           while (re.next()){
               mm=re.getString("登录密码");
           }
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

        this.setTitle("查找结果");


        JLabel jLabel=new JLabel("您的登录密码为:");
        jLabel.setFont(new Font("楷体",Font.BOLD,25));
       jLabel.setBounds(0,0,200,30);



        JTextField jTextField=new JTextField("");
        jTextField.setText(String.valueOf(mm));
        jTextField.setBounds(300,70,60,30);
        jTextField.setFont(new Font("楷体",Font.BOLD,25));
        jTextField.setForeground(Color.red);

       this.setBounds(300,300,300,150);
       this.add(jLabel);
      this.add(jTextField);
      this.setVisible(true);
    }


}
