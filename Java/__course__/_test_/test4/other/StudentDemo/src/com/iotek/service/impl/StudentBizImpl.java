package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.StudentDao;
import com.iotek.dao.impl.StudentDaoImpl;
import com.iotek.entity.Student;
import com.iotek.service.StudentBiz;

/**
 * 业务逻辑层 
 * 业务逻辑--- 链接底层(dao)   
 * @author Administrator
 *
 */
public class StudentBizImpl implements StudentBiz {
	
	private StudentDao stuDao;
	
	public StudentBizImpl() {
		stuDao = new StudentDaoImpl();
	}
	
	public int addStudent(Student student){
		return stuDao.addStudent(student);
		
	}
	
	public List<Student> selectAll() {
		return stuDao.selectAll();
	}

	@Override
	public boolean isExistName(String name) {
		return false;
	}

	@Override
	public boolean judgeNameAndPsw(String name, String psw) {
		return false;
	}

}
