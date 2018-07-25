package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Student;

/**
 * 里面放的都是接口  
 * 接口里面放的是增删改查方法的声明
 * 接口本身就是一种规范;面向接口进行编程
 * 提高也扩展性,灵活性
 * 符合多态,
 * 一个类不要依赖于具体的类进行编程,依赖于接口--抽象类
 * 
 * @author Administrator
 *
 */
public interface StudentDao {
	/**
	 * 添加学生信息
	 * @param student 你要插入的学生对象
	 * @return 0-- 代表插入失败 <br> !0 成功
	 */
	public int addStudent(Student student);
	
	/**
	 * 根据id删除学生
	 * @param  id 
	 * @return 0-- 代表插入失败 <br> !0 成功
	 */
	public int deleteStudent(int  id );
	
	/**
	 * 修改学生信息
	 * update 表名 set score=? where id=?
	 * @param student
	 * @return 0-- 代表插入失败 <br> !0 成功
	 */
	public int updateStudent(Student student);
	
	/**
	 * 查询所有学生信息
	 * @return List<Student>返回查到的所有的学生对象信息 -- list--
	 */
	public List<Student> selectAll();
	
}
