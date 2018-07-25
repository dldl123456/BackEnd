package test2;

//主方法（程序入口）
//测试类
public class EmployeeTest {
	public static void main(String[] args){
        Employee employee1=new Employee("Jim",28,'男',"软件工程师");  //实例化Employee类创建employee1对象
        Employee employee2=new Employee("Jim",28,'男',"软件工程师");  //实例化Employee类创建employee2对象
        
        employee1.getDetail();  //employee1对象调用getDetail方法输出
        employee2.getDetail();  //employee2对象调用getDetail方法输出
        
        System.out.println("判断两位职员是否“相等”:");  //提示
        
        System.out.println(employee1.equals(employee2));  //调用equals方法判断两个对象是否相等
    }
}
