import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Select01 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon= DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/emp?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root",
                "000000");
        // Scanner sc = new Scanner(System.in);
        // System.out.println("请问你要进行什么操作：");
        // System.out.println("1.查询,2.添加,3.删除（请输入编号）");
        // int bh =sc.nextInt();//定义编号
        // if (bh==1){
        //     System.out.println("");
        // }
        PreparedStatement stmt = coon.prepareStatement("select job from emp where empno="+1234);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println(rs.getString("job"));
        }
        Scanner sc= new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println(name);
        if(name.length()==0){
            System.out.println("回车");
        }
    }
}
