package com.iotek.service;

import java.util.List;

import com.iotek.entity.Student;

/**
 * 业务逻辑层   
 * @author Administrator
 *
 */
public interface StudentBiz {
	
	/**
	 * 注册
	 * @param student 你要插入的学生对象
	 * @return 0-- 代表插入失败 <br> !0 成功
	 */
	public int addStudent(Student student);
	
	/**
	 * 查询所有学生对象
	 * @return List<Student>
	 */
	public List<Student> selectAll();

	public boolean isExistName(String name);

	public boolean judgeNameAndPsw(String name, String psw);


}
