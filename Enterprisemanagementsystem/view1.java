package Enterprisemanagementsystem;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;

public class view1 extends JFrame{

    private JTable tabDemo;
    private JTableHeader jth;
    private JScrollPane scpDemo;
    public view1(){
        super("个人信息表");
        JLabel jTextField1=new JLabel("---个人信息如下---");
        jTextField1.setBounds(10,10,300,30);
        jTextField1.setBackground(Color.cyan);
        jTextField1.setForeground(Color.MAGENTA);
        jTextField1.setFont(new Font("宋体", Font.BOLD, 20));
        this.setSize(800,200);
        this.setLayout(null);
        this.setLocation(800,500);
// 创建组件
        add(jTextField1);
        this.scpDemo = new JScrollPane();
        this.scpDemo.setBounds(10,50,750,450);


         check1();
        add(this.scpDemo);
//        add(this.btnShow);
// 显示窗体
        this.setVisible(true);
    }


    public void check1(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl =
                    "jdbc:sqlserver://127.0.0.1:1433;"
                            + "databaseName=企业考勤系统;"
                            + "user=sa;"
                            + "password=123456;";
            Connection conn = DriverManager.getConnection(connectionUrl);
            String sql="select * from dbo.普通员工 where 员工编号='"+JFrameBackground.s1[0]+"'";
            PreparedStatement pstm=conn.prepareStatement(sql);
            ResultSet rs =pstm.executeQuery();
            int count=0;
            while (rs.next()){
                count++;
            }
            rs=pstm.executeQuery();
            Object[][] info=new Object[count][6];
            count=0;
            while (rs.next()){
                info[count][0]=rs.getString("员工编号");
                info[count][1]=rs.getString("登录密码");
                info[count][2]=rs.getString("联系电话");
                info[count][3]=rs.getString("员工姓名");
                info[count][4]=rs.getString("性别");
                info[count][5]=rs.getString("部门");
                count++;
            }

            String[] title={"员工编号","登录密码","联系电话","员工姓名","性别","部门"};
            this.tabDemo=new JTable(info,title);
            this.jth = this.tabDemo.getTableHeader();

            this.scpDemo.getViewport().add(tabDemo);

        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }
}
