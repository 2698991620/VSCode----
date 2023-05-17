/*
 * @Descripttion: 
 * @version: 
 * @@Company: DCIT-SH
 * @Author: 宸
 * @Date: 2023-03-04 10:29:30
 * @LastEditors: 宸
 * @LastEditTime: 2023-03-05 18:48:05
 */
package playjdbc;


import java.util.Scanner;

public class Demo01 {
    /**
     * @name: 宸
     * @test: test font
     * @msg: 这是由宸创建.
     * @param {String[]} args
     * @return {*}
     */    
    public static void main(String[] args) throws Exception{
        EmpManager empManager = new EmpManager();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("------------------------------");
            System.out.println("1.查询员工信息");
            System.out.println("2.添加员工信息");
            System.out.println("3.修改员工信息");
            System.out.println("4.删除员工信息");
            int n = input.nextInt();
            switch(n){
                case 1:
                	System.out.println("请选择已知的员工信息：（1.姓名,2.编号）");
                    String Number = input.next();
                    System.out.println("请输入已知信息：");
                    String Attribute = input.next();
                    System.out.println("请输入需要查询的信息（需要查询所有信息请输入all）:");
                    String Data = input.next();
                    empManager.select(Number,Attribute,Data);
                    break;
                case 2:
                    System.out.println("请输入需要添加的员工信息（选填内容回车跳过）");
                    System.out.println("员工编号：（必填）");
                    int mpno = input.nextInt();
                    System.out.println("员工姓名：（选填）");
                    String name = input.next();
                    System.out.println("员工职位：（选填）");
                    String job = input.next();
                    System.out.println("上级编号：（选填）");
                    int mgr = input.nextInt();
                    System.out.println("入职日期：xxxx-xx-xx xx:xx:xx（选填）");
                    String hriedata = input.next();
                    System.out.println("薪金：（选填）");
                    int sal = input.nextInt();
                    System.out.println("佣金：（选填）");
                    int comm = input.nextInt();
                    System.out.println("部门编号：（选填）");
                    int deptno = input.nextInt();
                    empManager.insert();
                    break;
                case 3:
                    empManager.update();
                    break;
                case 4:
                    empManager.delete();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            System.out.println("是否继续？（y/n）");
            String yn = input.next();
            if(yn.equalsIgnoreCase("n")){
                break;
            };
        } while (true);
        
    }
    
}