package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhizuobiao.bean.User;
import com.zhizuobiao.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestDao {

	@Autowired
	private UserDao userDao;

	@Test
	public void demo1() {

		User user = userDao.getUser(5);
		System.out.println(user);

	}
}
