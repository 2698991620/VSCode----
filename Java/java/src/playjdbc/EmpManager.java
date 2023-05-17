/*
 * @Descripttion: 
 * @version: 
 * @@Company: DCIT-SH
 * @Author: 宸
 * @Date: 2023-03-04 10:33:04
 * @LastEditors: 宸
 * @LastEditTime: 2023-03-05 18:43:38
 */
package playjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpManager {
    public String Attribute;
    public String Number;
    public String Data;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public String getAttribute() {
        return Attribute;
    }
    public void setAttribute(String attribute) {
        Attribute = attribute;
    }
    public void setNumber(String number) {
        Number = number;
    }
    public void setData(String data) {
        Data = data;
    }
    public String getNumber() {
        return Number;
    }
    public String getData() {
        return Data;
    }

    // static{

    //     Class.forName("com.mysql.cj.jdbc.Driver");

    // }

    public void before() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/emp?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root",
                "000000");
    }

    public void ShutDown() throws Exception{
        rs.close();
		ps.close();
		conn.close();
    }
    
    /**
     * @author:数据查询方法
     * @param Number
     * @param Attribute
     * @param Data
     */
    public void select(String Number,String Attribute,String Data){
        try{
            before();
            switch (Number){
                case "1":
                Number = "ename";
                break;
                case "2":
                Number = "empno";
                break;
            }
            if (Data.equals("all")){
                ps = conn.prepareStatement("select * from emp where "+ Number + " = '" + Attribute + "'");
                rs = ps.executeQuery();
                while(rs.next()) {
                    String empno = rs.getString("empno");
                    String ename = rs.getString("ename");
                    String hiredate = rs.getString("hiredate");
                    String sal = rs.getString("sal");
                    String job = rs.getString("job");
                    String deptno = rs.getString("deptno");
                    System.out.println(empno+"  "+ename+"  "+hiredate+"  "+sal+"  "+deptno+"  "+job);
                }
            }
            else{
                PreparedStatement ps = conn.prepareStatement("select "+Data+" from emp where "+ Number + " = '" + Attribute + "'");
                rs = ps.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString(Data));
                }
            }
        ShutDown();
        }catch(Exception e){
            System.out.println("信息录入错误，如有需要请再次尝试。");
        }
    }

    /**
     * @author:
     * @throws Exception
     */
    public void insert() throws Exception{
        before();
        System.out.println(2);;
    }

    /**
     * @name: 宸
     * @test: test font
     * @msg: 这是由宸创建.
     * @return {*}
     */    
    public void update(){
        System.out.println(3);;
    }

    /**
     * @name: 宸
     * @test: test font
     * @msg: 这是由宸创建.
     * @return {*}
     */    
    public void delete(){
        System.out.println(4);;
    }
    
}