package Enterprisemanagementsystem;

import java.sql.*;
import java.util.Scanner;

public class delete {
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

    public void delete1() {

        con = this.getConnection();
        try {
//             Scanner sc=new Scanner(System.in);
//             String num=sc.next();
//             String name=sc.next();
//             String password=sc.next();
//             String depart=sc.next();
//             String gender=sc.next();
//             String number=sc.next();
          ck c1=new ck();StringBuffer s=new StringBuffer();
            System.out.println(s);
          String  sql ="delete from dbo.普通员工 where 员工编号=";
         s.append(sql);
         s.append(c1.s2[0]);
         Statement st=con.createStatement();

            st.executeUpdate(s.toString());
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
