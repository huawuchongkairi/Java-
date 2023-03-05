package Enterprisemanagementsystem;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Test extends JFrame{
    // 定义组件
    private JScrollPane scpDemo;
    private JTableHeader jth;
    private JTable tabDemo;
    private JButton btnShow;
    // 构造方法
    public Test(){
// 窗体的相关属性的定义
        super("员工信息表");
        JLabel jTextField1=new JLabel("---员工信息如下---");
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

// 将组件加入到窗体中
        show1();
        add(this.scpDemo);
//        add(this.btnShow);
// 显示窗体
        this.setVisible(true);
    }

//    // 点击按钮时的事件处理
//    public void btnShow_ActionPerformed(ActionEvent ae){
// 以下是连接数据源和显示数据的具体处理方法，请注意下
    public void show1(){
        try{
// 获得连接
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl =
                    "jdbc:sqlserver://127.0.0.1:1433;"
                            + "databaseName=企业考勤系统;"
                            + "user=sa;"
                            + "password=123456;";
            Connection conn = DriverManager.getConnection(connectionUrl);
// 建立查询条件
            String sql = "select * from 普通员工";
            PreparedStatement pstm = conn.prepareStatement(sql);
// 执行查询
            ResultSet rs = pstm.executeQuery();
// 计算有多少条记录
            int count = 0;
            while(rs.next()){
                count++;
            }
            rs = pstm.executeQuery();
// 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] info = new Object[count][6];
            count = 0;
            while(rs.next()){
                info[count][0]=rs.getString("员工编号");
                info[count][1]=rs.getString("登录密码");
                info[count][2]=rs.getString("联系电话");
                info[count][3]=rs.getString("员工姓名");
                info[count][4]=rs.getString("性别");
                info[count][5]=rs.getString("部门");
                count++;
            }
// 定义表头
            String[] title={"员工编号","登录密码","联系电话","员工姓名","性别","部门"};
// 创建JTable
            this.tabDemo = new JTable(info,title);
// 显示表头
            this.jth = this.tabDemo.getTableHeader();
// 将JTable加入到带滚动条的面板中
            this.scpDemo.getViewport().add(tabDemo);
        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }
}