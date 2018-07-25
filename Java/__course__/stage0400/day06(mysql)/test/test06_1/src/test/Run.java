/**
 * 1、编写代码测试最基本JDBC步骤： 加-连-预-执-使 
 * 2、编写代码实现简单增删改查学员信息
 */

package test;

import java.util.List;

public class Run {
	public static void main(String[] args) {
		//返回结果
		int addResult1 = 0,  //添加1
			addResult2 = 0,  //添加2
			delResult = 0,  //删除
			updateResult = 0;  //修改
		
		//实例化数据库操作接口实现类
		StudentDaoImpl stuDao = new StudentDaoImpl();
		
		//实例化学生类
		Student newStu1 = new Student("小明", 32, 66);
		Student newStu2 = new Student("王五", 28, 33);
		Student newStu3 = new Student(1, "路人甲", 20, 99.9);
		
		//增
		System.out.println("***** 新增 *****");
		addResult1 = stuDao.addStudent(newStu1);
		addResult2 = stuDao.addStudent(newStu2);
		
		if(addResult1 == 1){
			System.out.println("数据1插入成功！");
		}else{
			System.out.println("数据1插入失败！");
		}
		
		if(addResult2 == 1){
			System.out.println("数据2插入成功！");
		}else{
			System.out.println("数据2插入失败！");
		}
		System.out.println();
		
		//删
		System.out.println("***** 删除 *****");
		delResult =  stuDao.deleteStudent(2);
		if(delResult == 1){
			System.out.println("id为2的数据删除成功！");
		}else{
			System.out.println("id为2的数据删除失败！");
		}
		System.out.println();
		
		//改
		System.out.println("***** 修改 *****");
		updateResult = stuDao.updateStudent(newStu3);
		if(updateResult == 1){
			System.out.println("id为1的数据修改成功！");
		}else{
			System.out.println("id为1的数据修改失败！");
		}
		System.out.println();
		
		//查
		System.out.println("***** 查询 *****");
		List<Student> stuList = stuDao.selectAll();
		for(Student stu:stuList){
			System.out.println(stu);
		}
	}
}
