/*
 * 多对多：一个课程里面有很多学生，一个学生也可以报很多课程 
 */

package dao;

import po.Student;

public interface StudentDao {
	//根据学生id查学生
	public Student getStudentById(int sid);
}
