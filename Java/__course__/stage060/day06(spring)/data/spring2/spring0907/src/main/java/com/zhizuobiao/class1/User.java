package com.zhizuobiao.class1;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user9")
public class User {

	@Value("99")
	private int id;
	@Value("vvv")
	private String username;
	@Value("ppp")
	private String password;

	// 方式一
	// @Autowired
	// @Qualifier("cat9") // 指定其他名字
	// 另一种方式
	// @Resource(name = "cat9")
	@Resource
	private Cat cat;
	private List list;
	private Map map;
	
	
	// 测试mvc
	@Resource
	private UserDao userDao;
	@Resource
	private UserService userService;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public User() {

	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", cat=" + cat + ", list="
				+ list + ", map=" + map + "]";
	}

}
