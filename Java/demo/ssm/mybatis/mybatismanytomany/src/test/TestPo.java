package test;

import java.util.Iterator;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.StudentDao;
import po.Course;
import po.Student;
import utils.Utils;

public class TestPo {
	//根据用户id查身份证
	@Test
	public void testPoGetStudentById(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		StudentDao sd = sqlSession.getMapper(StudentDao.class);
		
		Student stu = sd.getStudentById(2);
		
		System.out.println(stu);
		
		//拿课程名需要遍历集合
		Set<Course> set = stu.getCourse();
		Iterator<Course> iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getCname());
		}
		
		sqlSession.close();
	}
}
