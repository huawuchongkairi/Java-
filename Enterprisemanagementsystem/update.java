package Enterprisemanagementsystem;

import java.sql.*;
import java.util.Scanner;

public class update {
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

    public void update1() {

        con = this.getConnection();
        try {
            xiugai x1 = new xiugai();

                   sql = con.prepareStatement("update dbo.普通员工 set 员工编号=?,登录密码=?,联系电话=?,员工姓名=?,性别=?,部门=?  where 员工编号=?");
            sql.setString(1, x1.s1[0]);
            sql.setString(2, x1.s1[1]);
            sql.setString(3, x1.s1[2]);
            sql.setString(4, x1.s1[3]);
            sql.setString(5, x1.s1[4]);
            sql.setString(6, x1.s1[5]);
            sql.setString(7, x1.s1[6]);
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
