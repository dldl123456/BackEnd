package view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.Userdao;
import dao.impl.AssessmentDaoImpl;
import dao.impl.CityDaoImpl;
import dao.impl.FilmTicketDaoImpl;
import dao.impl.MovieDaoImpl;
import dao.impl.SessionDaoImpl;
import dao.impl.UserDaoImpl;
import entity.FilmTicket;
import entity.Movie;
import entity.User;
import help.HandleInputMismatchException;
import help.JudjePhoneNumber;
import help.ProvingNum;
import help.RandomAccount;
import help.Time;
import view.choose.UserViewChoose;

/**
 * 用户登录页面展示
 * @author Useristrator
 *
 */
public class UserView {
	public static int userNum=0;//用来存用户编号
	static Scanner input = new Scanner(System.in);
	static UserViewChoose uvc = new UserViewChoose();
	static Userdao usi = new UserDaoImpl();
	static UserDaoImpl udi = new UserDaoImpl();
	static User user= null;
	public static void userFirstPage() {
		System.out.println("近期热映：");
		MovieView.movieRankListPage();
		System.out.println("请选择您需要的操作：");
		System.out.println("【1】、登录");
		System.out.println("【2】、注册");
		System.out.println("【3】、忘记密码");
		System.out.println("【4】、退出");
		try {
			uvc.userFirstPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void userMeanPage() {
		System.out.println("以下是您的功能列表请输入要选择的序号：");
		System.out.println("【1】、查看电影列表");
		System.out.println("【2】、查看某个电影详细信息");
		System.out.println("【3】、买票");
		System.out.println("【4】、退票");
		System.out.println("【5】、写影评");
		System.out.println("【6】、修改个人密码");
		System.out.println("【7】、修改电话号码");
		System.out.println("【8】、退出");
		try {
			uvc.userMeanPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查看电影列表
	 */
	public static void userSeeMovieList() {
		System.out.println("下面是所有电影列表：");
		try {
			List<Movie> movies = new MovieDaoImpl().queryMovies();
			for(Movie movie:movies) {
				System.out.println(MovieView.movieToString1(movie));
			}
			System.out.println("已为您跳转到上级列表");
			userMeanPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void UserSeeAllPage() {
		try {
			List<User> users;
			users = usi.queryUsers();
			System.out.println("id\t账号\t\t姓名\t城市\t电话\t\t余额");
			for(User user :users) {
				System.out.println(UserToString(user));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateUserPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void UserSeeCityPage() throws Exception {
		System.out.println("请输入你要查询的城市ID：");
		int cityId=0;
		cityId=HandleInputMismatchException.handleInputMismatchException(cityId);
		if(new CityDaoImpl().comparisonCityId(cityId)!=-1) {
			try {
				List<User> users;
				users =usi.queryUsersByCity(cityId);
				System.out.println("id\t账号\t\t姓名\t城市\t电话\t\t余额");
				for(User user :users) {
					System.out.println(UserToString(user));
				}
				System.out.println("请选择其他操作：");
				AdminView.adminOperateUserPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("您输入的城市编号不存在，请查证后重新输入！！！");
			UserSeeCityPage();
		}		
	}
	public static void UserSeePage() throws Exception {
		System.out.println("请输入你要查询的用户ID：");
		int userId=0;
		userId=HandleInputMismatchException.handleInputMismatchException(userId);
		if(new UserDaoImpl().comparisonUserId(userId)!=-1) {
			try {
				System.out.println("id\t账号\t\t姓名\t城市\t电话\t\t余额");
				System.out.println(UserToString(usi.queryUserById(userId)));
				System.out.println("请选择其他操作：");
				AdminView.adminOperateUserPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("您输入的用户ID不存在，请查证后再输入：");
			UserSeePage();
		}	
	}
	
	/**
	 * 查看单个电影详细信息
	 * @throws Exception
	 */
	public static void userSeeMovie() throws Exception {
		System.out.println("请输入要查看的电影名称：");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)!=-1) {
			Movie movie=new MovieDaoImpl().queryMovie(movieName);
			System.out.println("下面是您要查看的电影信息：");
			System.out.println(MovieView.movieToString(movie));
			userMeanPage();
		}else {
			System.out.println("系统中没有您要查看的电影，请查证后重新输入！！！");
			System.out.println("已为您跳转回上级页面：");
			userMeanPage();
		}
	}

	public static void userbuyTictetPage(int userId) throws Exception {
		User user = new UserDaoImpl().queryUserById(userId);
		int cityId = user.getUserCity();
		String cityName = new CityDaoImpl().queryCityById(cityId).getCityName();
		System.out.println("系统检测到您当前所在城市是："+cityName);
		FilmTicket ticket =FilmTicketView.FilmTicketBuyPage(userId, cityId);
		if(ticket!=null) {
			new FilmTicketDaoImpl().addFilmTicket(ticket);
			System.out.println("购票成功，以下是您的电影票信息：");
			System.out.println(FilmTicketView.ticketToString(ticket));
			System.out.println("请选择下一步操作：");
			System.out.println("【1】、继续购买");
			System.out.println("【2】、返回上一级页面");
			System.out.println("【3】、退出");
			uvc.buyTicketPageChoose();
		}else {
			System.out.println("购票失败");
		}
	}

	public static void userRefundTicketPage() throws Exception {
		FilmTicketView.FilmTicketRefund();
	}
	/**
	 * 用户评价方法
	 * @throws Exception
	 */
	public static void userWriteAssessmentPage() throws Exception{
		System.out.println("请选择您要评价的订单，并输入订单号：");
		List<FilmTicket> tickets;
		tickets = new FilmTicketDaoImpl().queryFilmTicketsByUser(userNum);
		for(FilmTicket ticket :tickets) {
			/*
			 * 判断场次时间是否在当前时间之前
			 * 并且要判断是否退票
			 */
			String starttime = new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSeesionStoptime();
			Date date1 = Time.StringToDate(starttime);
			Date date2 = new Date();
			if(Time.compareTo2(date1, date2)&&ticket.getTicketStatus()==0) {
				System.out.println(FilmTicketView.ticketToString1(ticket));
			}else {
				continue;
			}			
		}
		int number=0;
		number=HandleInputMismatchException.handleInputMismatchException(number);
		if(new FilmTicketDaoImpl().comparisonTicketId(number, userNum)!=-1) {
			if(new AssessmentDaoImpl().queryAssessmentByTicketId(number)==null) {
				AssessmentView.AssessmentAddPage(number);				
			}else {
				System.out.println("您不能对同一场电影进行多次评价，请选择下一步操作：");
				userMeanPage();
			}
		}else {
			System.out.println("您输入的订单号不存在，请重新输入：");
			userWriteAssessmentPage();
		}
	}
	
	public static void userUpdatePasswordPage(int userId) throws Exception {
		User user = new UserDaoImpl().queryUserById(userId);
		a:while(true) {
			System.out.println("请输入当前密码：");
			String oldPassword = input.next();
			//String userAccount=user.getUserPassword(); 
			if(oldPassword.equals(user.getUserPassword())) {
				b:while(true) {
					System.out.println("请输入要更改的密码：");
					String newPassword = input.next();
					System.out.println("请确认密码：");
					String newPass = input.next();
					if(newPassword.equals(newPass)) {
						int i=new UserDaoImpl().updateUserPassword(user.getUserName(),newPass);
						System.out.println(i);
						if(i>0) {
							System.out.println("密码已修改，请重新登录：");
							userLoginPage();
						}else {
							System.out.println("密码修改失败！！");
						}
					}else {
						System.out.println("密码错误，请重新修改密码：");
						continue b;
					}
					break;
				}
			}else {
				System.out.println("密码错误，请重新输入：");
				continue a;
			}
			break;
		}	
	}
	public static void userUpdatePasswordtoZeroPage() throws Exception {
		System.out.println("请输入用户账号：");
		int userAccount =0;
		userAccount =HandleInputMismatchException.handleInputMismatchException(userAccount);
		String userName = udi.queryUserByAccount(userAccount).getUserName();
		if(udi.comparisonUserAccount(userAccount)!=-1) {
			System.out.println("是否要重置密码：重置(1)  放弃(输入除1以外的任意数字)");
			int choose=0;
			choose =HandleInputMismatchException.handleInputMismatchException(choose);
			switch(choose) {
			case 1:
				new UserDaoImpl().updateUserPassword(userName,"000000");//改成000000
				System.out.println("密码已修改，已为您返回上一级页面：");
				AdminView.adminOperateUserPage();
				break;
			default:
				AdminView.adminOperateUserPage();
				break;
			}
		}else {
			System.out.println("您输入的用户不存在，请确认后重新输入：");
			userUpdatePasswordtoZeroPage();
		}	
	}
	/**
	 * 余额增加
	 * @param moviePrice
	 * @throws Exception
	 */
	public static void userUpBalance(double moviePrice) throws Exception{
		double oldBalance =udi.queryUserById(userNum).getUserBalance();
		double newBalance =oldBalance+moviePrice;
		udi.updateUserBalance(userNum, newBalance);
	}
	/**
	 * 余额减少
	 * @param moviePrice
	 * @throws Exception
	 */
	public static void userDownBalance(double moviePrice) throws Exception{		
		double oldBalance =udi.queryUserById(userNum).getUserBalance();
		System.out.println(oldBalance);
		double newBalance =oldBalance-moviePrice;
		if(newBalance<0) {
			System.out.println("您的账户余额不足，请先进行充值：");
			System.out.println("是否呼叫管理员进行充值：\n【1】、呼叫管理员\n【2】、返回上一层列表");
			a:while(true) {
				int choose =0;
				choose =HandleInputMismatchException.handleInputMismatchException(choose);
				switch(choose) {
				case 1:
					userCallAdmin();
					break;
				case 2:
					userMeanPage();
					break;
				default:
					System.out.println("您输入的选项有误，请重新输入：【1】、呼叫管理员,【2】、返回上一层列表");
					continue a;
				}
			}			
		}
		System.out.println(newBalance);
		udi.updateUserBalance(userNum, newBalance);
	}
	/*
	 * 管理员对用户进行充值
	 */
	public static void userUpdateBalance() throws Exception{
		System.out.println("请输入用户账号：");
		int userAccount =0;
		userAccount =HandleInputMismatchException.handleInputMismatchException(userAccount);
		int userId = udi.queryUserByAccount(userAccount).getUserId();
		if(udi.comparisonUserAccount(userAccount)!=-1) {
			double oldBalance =udi.queryUserById(userId).getUserBalance();
			System.out.println("用户："+userAccount+" 账户余额为："+oldBalance);
			System.out.println("请输入要充值金额：");
			double money = 0;
			money =HandleInputMismatchException.handleInputMismatchException(money);
			System.out.println("确认充值请输入1，放弃输入其他数字：");
			int choose=0;
			choose =HandleInputMismatchException.handleInputMismatchException(choose);
			if(choose==1) {				
				double newBalance =(oldBalance+money);
				int i=udi.updateUserBalance(userId, newBalance);
				if(i>0) {
					System.out.println("充值成功 当前余额为："+newBalance);
					AdminView.adminOperateUserPage();
				}else {
					System.out.println("充值失败");
				}
			}else {
				AdminView.adminOperateUserPage();
			}
		}else {
			System.out.println("您输入的用户不存在，请确认后重新输入：");
			userUpdateBalance();
		}	
	}
	public static void userUpdatePhone(int userId) throws Exception {
		User user = new UserDaoImpl().queryUserById(userId);
		a:while(true) {
			System.out.println("请输入当前手机号码：");
			String phone = input.next();
			if(phone.equals(user.getUserPhone())){
				b:while(true) {
					String proving=ProvingNum.provingNum();
					System.out.println(proving);
					System.out.println("请输入上面的验证码：");
					String prov = input.next();
					if(prov.equals(proving)) {
						System.out.println("请输入要修改的电话号码：");
						String newPhone =input.next();
						System.out.println("您要修改的新电话号码是："+newPhone);
						System.out.println("确认修改请输入1，放弃则随便输入非1整数");
						int choose=0;
						choose=HandleInputMismatchException.handleInputMismatchException(choose);
						switch(choose) {
						case 1:
							int i=new UserDaoImpl().updateUserPhone(user.getUserId(), newPhone);
							if(i>0) {
								System.out.println("电话号码修改成功，已为您跳转到上级页面");
								userMeanPage();
							}else {
								System.out.println("修改失败！！");
							}						
						default:
							System.out.println("您已经放弃了修改电话号码，请选择下一步操作：");
							userMeanPage();
						}
					}else {
						System.out.println("验证码输入错误，请重新输入验证码：");
						continue b;
					}
					break;
				}
			}else {
				System.out.println("手机号码不匹配，请您重新输入：");
				continue a;
			}
			break;
		}
	}
	
	public static User userLoginPage() throws Exception {
		//User user = null;
		a:while(true) {
			System.out.println("请输入您的账号：");
			int userAccount=0;
			userAccount=HandleInputMismatchException.handleInputMismatchException(userAccount);
			Userdao ud = new UserDaoImpl();
			if(ud.comparisonUserAccount(userAccount)!=-1) {
				b:while(true) {
					System.out.println("请输入账户密码：");
					String userPassword=input.next();
					if(ud.comparisonUserPas(userAccount, userPassword)!=-1) {
						user = new UserDaoImpl().userLogin(userAccount, userPassword);
						userNum=user.getUserId();
						System.out.println("登录成功，欢迎您："+user.getUserName());
						userMeanPage();
						break;
					}else {
						System.out.println("密码错误，请重新输入：");
						continue b;
					}
				}
			}else {
				System.out.println("您输入的账户名称不正确，请重新输入：");
				continue a;
			}
			break;
		}
	return user;
	}
	
	public static void userForgetPassWord() throws Exception{
		System.out.println("请选择您的操作：\n【1】、使用电话号码验证登录\n【2】、呼叫管理员进行密码重置\n【3】、退出");
		uvc.userForgetPassWord();
	}
	/**
	 * 用户呼叫管理员的方法
	 */
	public static void userCallAdmin() {
		System.out.println("稍等片刻，已经安排了管理员来为您处理：");
		for(int i=0;i<6;i++) {
			try {
				Thread.sleep(1000);
				System.out.print(". ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n让您久等了，我先进行登陆哈");
		try {
			AdminView.adminLoginPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 用电话号码和验证码登录
	 */
	public static User LoginByPhone() throws Exception {
		a:while(true) {
			System.out.println("请输入您的账号：");
			int userAccount=0;
			userAccount=HandleInputMismatchException.handleInputMismatchException(userAccount);
			Userdao ud = new UserDaoImpl();
			if(ud.comparisonUserAccount(userAccount)!=-1) {
				b:while(true) {
					System.out.println("请输入您的电话号码：");
					String userPhone=input.next();
					boolean boo = JudjePhoneNumber.isMobileNO(userPhone);//判断电话号码格式
			        if (boo) {
			        	if(ud.comparisonUserPhone(userAccount, userPhone)!=-1) {
			        		//给一个验证码
			        		c:while(true) {
			        			String proving=ProvingNum.provingNum();
								System.out.println(proving);
								System.out.println("请输入上面的验证码：");
								String prov = input.next();
								if(prov.equals(proving)) {
									user = new UserDaoImpl().userLoginByPhone(userAccount, userPhone);
									userNum=user.getUserId();//给一个全局使用的用户编号
									System.out.println("登录成功，欢迎您："+user.getUserName());
									userMeanPage();
								}else {
									System.out.println("验证码输入错误，请重新输入验证码：");
									continue c;
								}	
			        			break;
			        		}		        								
						}else {
							System.out.println("对不起，你输入的电话号码与预留的电话号码不一致，请重新输入：");
							continue b;
						}
			        } else {  
			            System.out.println("电话号码错误,请输入正确的电话号码：（13********* ,15********,18*********）");
			            continue b;
			        }					
			        break;
				}
			}else {
				System.out.println("您出入的账户名称不正确，请重新输入：");
				continue a;
			}
			break;
		}
		return user;
	}
	public static void userRegister() throws Exception{
		int userAccount = RandomAccount.randomAccount();
		System.out.println("请输入姓名：");
		String userName = input.next();
		System.out.println("请输入密码：");
		String userPassword = input.next();
		System.out.println("请输入常住城市编号：");
		int userCity=0;
		userCity=HandleInputMismatchException.handleInputMismatchException(userCity);
		a:while(true) {
			System.out.println("请输入电话号码");
			String userPhone = input.next();
			boolean boo = JudjePhoneNumber.isMobileNO(userPhone);
	        if (boo) {
	        	User user = new User(userAccount,userName,userPassword,userCity,userPhone);
	    		int i = new UserDaoImpl().userRegister(user);
	    		if(i>0) {
	    			b:while(true) {
	    				System.out.println("注册成功，您的账号是："+user.getUserAccount()+"，请牢记您的账号！！！");
	    				System.out.println("是否立即登录，1、是，2、否");
	    				int choose=0;
	    				choose=HandleInputMismatchException.handleInputMismatchException(choose);
	    				switch(choose) {
	    				case 1:
	    					userLoginPage();
	    					break;
	    				case 2:
	    					System.out.println("已为您跳转到首页面");
	    					HomePage.homePage();
	    					break;
	    				default:
	    					System.out.println("您输入的指令错误，请重新输入：");
	    					continue b;
	    				}
	    				break;
	    			}
	    		}
	            break;  
	        } else {  
	            System.out.println("电话号码错误,请输入正确的电话号码：（13********* ,15********,18*********）");
	            continue a;
	        }  
		}	
	}
	public static String UserToString(User user) {
		return user.getUserId()+"\t"+user.getUserAccount()+"\t"+user.getUserName()
		+"\t"+user.getUserCity()+"\t"+user.getUserPhone()+"\t"+user.getUserBalance();
	}
}
