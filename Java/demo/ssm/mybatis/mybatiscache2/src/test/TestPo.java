/*
 *  二级缓存
 *  Ehcache第三方缓存插件（内存/磁盘，提高程序性能）
 *  使用缓存条件：被缓存的数据应该不经常发生变化
 */

package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.DepartmentDao;
import po.Department;
import utils.Utils;

public class TestPo {
	//根据id查部门
	@Test
	public void testPoGetPersonById(){
		SqlSession sqlSession1 = Utils.getSqlSessionFactory().openSession();
		SqlSession sqlSession2 = Utils.getSqlSessionFactory().openSession();
		
		DepartmentDao gd1 = sqlSession1.getMapper(DepartmentDao.class);
		DepartmentDao gd2 = sqlSession1.getMapper(DepartmentDao.class);
		
		Department dm1 = gd1.geDeptById(1);
		Department dm2 = gd2.geDeptById(1);
		
		System.out.println(dm1);
		System.out.println(dm2);
		
		sqlSession1.close();
		sqlSession2.close();
		
	}
}
