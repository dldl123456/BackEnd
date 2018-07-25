package contro;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.CodeGen;
import util.Help;

/**
 * 
 * @param 用户控制层
 * @author zmx2321
 * 
 */


public class UserContro {
	static UserService userService = new UserServiceImpl();
	static UserDao userDao = new UserDaoImpl();
	
	//登录
	public static User login(){
		String username = Help.getString("请输入账号：");
		String password = Help.getString("请输入密码：");

		boolean success = userService.login(username, password);
		
		if(success){
			System.out.println("\n" + username + "登陆成功!\n");
			
			User user= new UserDaoImpl().queryUser(username, password);
			return user;
		}else{
			System.out.println("用户名或密码错误，请重新输入");
		}
		
		return null;
	}
	
	//注册
	public static User regist(){
		String username = Help.getString("请输入账号：");
		String password = Help.getString("请输入密码：");
		String repassword = Help.getString("请确定密码：");
		
		int times = 3;  //计数器
		
		while (!password.equals(repassword)){
			repassword = Help.getString("两次密码不一致，请重新输入确定密码：");
			times--;
			
			if(times < 0){
				System.out.println("确认密码输入超出上限，已退出注册！\n");
				return null;
			}
		}

		String sex = Help.getString("请输入性别：");
		
		while(!(sex.equals("男") || sex.equals("女"))){
			System.out.println("性别输入有误，请输入男或者女");
			sex = Help.getString("请输入性别：");
		}
		
		String phone = Help.getString("请输入手机号码：");
		
		CodeGen.operaCodeGen();  //验证码

		User user = new User();
		user.setUser_name(username);
		user.setUser_password(repassword);
		user.setUser_sex(sex);
		user.setUser_phone(phone);

		boolean success = userService.regist(user);
		
		if (success) {
			System.out.println("注册成功！\n");
			return user;
		} else {
			System.out.println("注册失败！\n");
			return null;
		}
	}
	
	//个人信息
	public static void PersonalInformation(int user_id){
		boolean success = userService.querryUser(user_id);
		
		User user = userDao.queryUser(user_id);
		
		if(success){
			System.out.println("查询成功！\n");
			System.out.println(user + "\n");
		}else{
			System.out.println("查询失败！\n");
		}
	}
	
	//修改账户余额（充值）
	public static void updateAccount(int user_id){
		
		float user_balance = Help.getFloat("请输入您要充值的金额：");
		
		boolean success = userService.updateAccount(user_id, user_balance);
		
		//记录余额
		float user_balance1 = userDao.queryUserAccount(user_id);
		
		if(success){
			System.out.println("充值成功，您现在的余额为：" + user_balance1 + "\n");
		}else{
			System.out.println("充值失败！");
		}
	}
	
	//查看所有用户
	public static void queryUsers(){
		List<User> userList = userDao.querryUsers();
		
		if (userList.isEmpty()) {
			System.out.println("暂无用户");
		}
		
		boolean success = userService.querryUsers(userList);
		
		if (success) {
			for(User user : userList){
				System.out.println(user + "\n");
			}
			System.out.println();
		}else {
			System.out.println("查询失败！\n");
		}
		
		userList.clear();
	}
	
	//删除用户
	public static void deleteUser(){
		queryUsersName();
		
		int user_id = Help.getInt("请输入您要删除的用户编号：");
		
		boolean success = userService.deleteUser(user_id);
		
		if (success) {
			System.out.println("删除成功！\n");
			queryUsersName();
		} else {
			System.out.println("删除失败！\n");
		}
	}
	
	//查询用户名
	public static void queryUsersName(){
		List<User> userList = userDao.querryUsers();
		
		if (userList.isEmpty()) {
			System.out.println("暂无用户");
		}
		
		boolean success = userService.querryUsers(userList);
		
		if (success) {
			for(User user : userList){
				System.out.println(user.getUser_id() + "、" + user.getUser_name());
			}
			System.out.println();
		}else {
			System.out.println("查询失败！\n");
		}
		
		userList.clear();
	}
	
	//根据用户id修改账户余额(设置)
	public static void setupCount(int id, float user_balance){
		
		boolean success = userService.setupCount(id, user_balance);
		
		if(success){
			userDao.setupCount(id, user_balance);
		}else{
			System.out.println("系统错误！");
		}
	}

	//test
	public static void main(String[] args) {
		//登录
		/*User resultLogin = login();
		System.out.println(resultLogin);*/
		
		//注册
		/*User resultRegist = regist();
		System.out.println(resultRegist);*/
		
		//修改账户余额（充值）
		/*User ResultUpdateAccount = updateAccount();
		System.out.println(ResultUpdateAccount);*/
		
		//个人信息
		//PersonalInformation(3);
		
		//查看所有用户
		queryUsers();
		
		//删除用户
		//deleteUser();
		
		//查询用户名
		//queryUsersName();
		
		//根据用户id修改账户余额(设置)
		//setupCount(1, 900);
	}
}
