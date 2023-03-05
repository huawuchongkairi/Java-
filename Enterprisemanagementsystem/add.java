package Enterprisemanagementsystem;

import java.sql.*;
import java.util.Scanner;

public class add {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

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

    public void insert() {

        con = this.getConnection();
        try {
//             Scanner sc=new Scanner(System.in);
//             String num=sc.next();
//             String name=sc.next();
//             String password=sc.next();
//             String depart=sc.next();
//             String gender=sc.next();
//             String number=sc.next();
            enroll e1 = new enroll();
            sql = con.prepareStatement("insert into dbo.普通员工(员工编号,登录密码,联系电话,员工姓名,性别,部门) values (?,?,?,?,?,?)");
            sql.setString(1, e1.s1[0]);
            sql.setString(2, e1.s1[1]);
            sql.setString(3, e1.s1[2]);
            sql.setString(4, e1.s1[3]);
            sql.setString(5, e1.s1[4]);
            sql.setString(6, e1.s1[5]);
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
