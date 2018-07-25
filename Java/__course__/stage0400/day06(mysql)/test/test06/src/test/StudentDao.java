package test;

import java.util.List;

public interface StudentDao {
	//添加学生信息
	public int addStudent(Student student);
	
	//根据id删除学生
	public int deleteStudent(int  id);
	
	//修改学生信息
	public int updateStudent(Student student);
	
	//查询所有学生信息
	public List<Student> selectAll();
}
