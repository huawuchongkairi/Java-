package Enterprisemanagementsystem;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.xml.transform.Result;
import java.awt.*;
import java.sql.*;

public class view extends JFrame {



    private JTable tabDemo;
    private JTableHeader jth;
    private JScrollPane scpDemo;

    public view(){
        super("员工考勤表");
        JLabel jTextField1=new JLabel("---部门考勤信息如下---");
        jTextField1.setBounds(10,10,300,30);
        jTextField1.setBackground(Color.cyan);
        jTextField1.setForeground(Color.MAGENTA);
        jTextField1.setFont(new Font("宋体", Font.BOLD, 20));
        this.setSize(800,500);
        this.setLayout(null);
        this.setLocation(800,500);
// 创建组件
        add(jTextField1);
        this.scpDemo = new JScrollPane();
        this.scpDemo.setBounds(10,50,750,450);


        check();
        add(this.scpDemo);

// 显示窗体
        this.setVisible(true);
    }
    public void check(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl =
                    "jdbc:sqlserver://127.0.0.1:1433;"
                            + "databaseName=企业考勤系统;"
                            + "user=sa;"
                            + "password=123456;";
            Connection conn = DriverManager.getConnection(connectionUrl);

            String sql="select * from dbo.考勤信息 where 部门='"+getkq.getDep1(JFrameBackground.s1[0])+"'"+" and 考勤时间>='"+考勤.s2[0]+"'"+" and 考勤时间<='"+考勤.s2[1]+"'";

            PreparedStatement pstm=conn.prepareStatement(sql);
            ResultSet rs =pstm.executeQuery();

            int count=0;
            while (rs.next()){
                count++;
            }
            rs=pstm.executeQuery();
            Object[][] info=new Object[count][5];
            count=0;
            while (rs.next()){
                info[count][0]=rs.getString("考勤状态");
                info[count][1]=rs.getString("考勤时间");
                info[count][2]=rs.getString("请假理由");
                info[count][3]=rs.getString("编号");
                info[count][4]=rs.getString("部门");
                count++;
            }
            String[] title={"考勤状态","考勤时间","请假理由","编号","部门"};
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

