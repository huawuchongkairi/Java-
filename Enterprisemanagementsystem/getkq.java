package Enterprisemanagementsystem;

import java.sql.*;

public class getkq {
    static Connection con;
    public static String getDep1(String name) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("连接失败");
        }
        String connectionUr1 =
                "jdbc:sqlserver://127.0.0.1:1433;"
                        + "databaseName=企业考勤系统;"
                        + "user=sa;"
                        + "password=123456;";

        Connection con1;
        con1= DriverManager.getConnection(connectionUr1);
        Statement state1=con1.createStatement();
        //查找权限
        String s1="select * from 部门管理员 where 部门管理员编号='"+name+"'";
        String eDep="";
        ResultSet rs1=state1.executeQuery(s1);
        while(rs1.next())
        {
            eDep=rs1.getString("部门");
        }
        return eDep;
    }


}
