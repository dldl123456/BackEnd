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
 * �û���¼ҳ��չʾ
 * @author Useristrator
 *
 */
public class UserView {
	public static int userNum=0;//�������û����
	static Scanner input = new Scanner(System.in);
	static UserViewChoose uvc = new UserViewChoose();
	static Userdao usi = new UserDaoImpl();
	static UserDaoImpl udi = new UserDaoImpl();
	static User user= null;
	public static void userFirstPage() {
		System.out.println("������ӳ��");
		MovieView.movieRankListPage();
		System.out.println("��ѡ������Ҫ�Ĳ�����");
		System.out.println("��1������¼");
		System.out.println("��2����ע��");
		System.out.println("��3������������");
		System.out.println("��4�����˳�");
		try {
			uvc.userFirstPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void userMeanPage() {
		System.out.println("���������Ĺ����б�������Ҫѡ�����ţ�");
		System.out.println("��1�����鿴��Ӱ�б�");
		System.out.println("��2�����鿴ĳ����Ӱ��ϸ��Ϣ");
		System.out.println("��3������Ʊ");
		System.out.println("��4������Ʊ");
		System.out.println("��5����дӰ��");
		System.out.println("��6�����޸ĸ�������");
		System.out.println("��7�����޸ĵ绰����");
		System.out.println("��8�����˳�");
		try {
			uvc.userMeanPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �鿴��Ӱ�б�
	 */
	public static void userSeeMovieList() {
		System.out.println("���������е�Ӱ�б�");
		try {
			List<Movie> movies = new MovieDaoImpl().queryMovies();
			for(Movie movie:movies) {
				System.out.println(MovieView.movieToString1(movie));
			}
			System.out.println("��Ϊ����ת���ϼ��б�");
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
			System.out.println("id\t�˺�\t\t����\t����\t�绰\t\t���");
			for(User user :users) {
				System.out.println(UserToString(user));
			}
			System.out.println("��ѡ������������");
			AdminView.adminOperateUserPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void UserSeeCityPage() throws Exception {
		System.out.println("��������Ҫ��ѯ�ĳ���ID��");
		int cityId=0;
		cityId=HandleInputMismatchException.handleInputMismatchException(cityId);
		if(new CityDaoImpl().comparisonCityId(cityId)!=-1) {
			try {
				List<User> users;
				users =usi.queryUsersByCity(cityId);
				System.out.println("id\t�˺�\t\t����\t����\t�绰\t\t���");
				for(User user :users) {
					System.out.println(UserToString(user));
				}
				System.out.println("��ѡ������������");
				AdminView.adminOperateUserPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("������ĳ��б�Ų����ڣ����֤���������룡����");
			UserSeeCityPage();
		}		
	}
	public static void UserSeePage() throws Exception {
		System.out.println("��������Ҫ��ѯ���û�ID��");
		int userId=0;
		userId=HandleInputMismatchException.handleInputMismatchException(userId);
		if(new UserDaoImpl().comparisonUserId(userId)!=-1) {
			try {
				System.out.println("id\t�˺�\t\t����\t����\t�绰\t\t���");
				System.out.println(UserToString(usi.queryUserById(userId)));
				System.out.println("��ѡ������������");
				AdminView.adminOperateUserPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("��������û�ID�����ڣ����֤�������룺");
			UserSeePage();
		}	
	}
	
	/**
	 * �鿴������Ӱ��ϸ��Ϣ
	 * @throws Exception
	 */
	public static void userSeeMovie() throws Exception {
		System.out.println("������Ҫ�鿴�ĵ�Ӱ���ƣ�");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)!=-1) {
			Movie movie=new MovieDaoImpl().queryMovie(movieName);
			System.out.println("��������Ҫ�鿴�ĵ�Ӱ��Ϣ��");
			System.out.println(MovieView.movieToString(movie));
			userMeanPage();
		}else {
			System.out.println("ϵͳ��û����Ҫ�鿴�ĵ�Ӱ�����֤���������룡����");
			System.out.println("��Ϊ����ת���ϼ�ҳ�棺");
			userMeanPage();
		}
	}

	public static void userbuyTictetPage(int userId) throws Exception {
		User user = new UserDaoImpl().queryUserById(userId);
		int cityId = user.getUserCity();
		String cityName = new CityDaoImpl().queryCityById(cityId).getCityName();
		System.out.println("ϵͳ��⵽����ǰ���ڳ����ǣ�"+cityName);
		FilmTicket ticket =FilmTicketView.FilmTicketBuyPage(userId, cityId);
		if(ticket!=null) {
			new FilmTicketDaoImpl().addFilmTicket(ticket);
			System.out.println("��Ʊ�ɹ������������ĵ�ӰƱ��Ϣ��");
			System.out.println(FilmTicketView.ticketToString(ticket));
			System.out.println("��ѡ����һ��������");
			System.out.println("��1������������");
			System.out.println("��2����������һ��ҳ��");
			System.out.println("��3�����˳�");
			uvc.buyTicketPageChoose();
		}else {
			System.out.println("��Ʊʧ��");
		}
	}

	public static void userRefundTicketPage() throws Exception {
		FilmTicketView.FilmTicketRefund();
	}
	/**
	 * �û����۷���
	 * @throws Exception
	 */
	public static void userWriteAssessmentPage() throws Exception{
		System.out.println("��ѡ����Ҫ���۵Ķ����������붩���ţ�");
		List<FilmTicket> tickets;
		tickets = new FilmTicketDaoImpl().queryFilmTicketsByUser(userNum);
		for(FilmTicket ticket :tickets) {
			/*
			 * �жϳ���ʱ���Ƿ��ڵ�ǰʱ��֮ǰ
			 * ����Ҫ�ж��Ƿ���Ʊ
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
				System.out.println("�����ܶ�ͬһ����Ӱ���ж�����ۣ���ѡ����һ��������");
				userMeanPage();
			}
		}else {
			System.out.println("������Ķ����Ų����ڣ����������룺");
			userWriteAssessmentPage();
		}
	}
	
	public static void userUpdatePasswordPage(int userId) throws Exception {
		User user = new UserDaoImpl().queryUserById(userId);
		a:while(true) {
			System.out.println("�����뵱ǰ���룺");
			String oldPassword = input.next();
			//String userAccount=user.getUserPassword(); 
			if(oldPassword.equals(user.getUserPassword())) {
				b:while(true) {
					System.out.println("������Ҫ���ĵ����룺");
					String newPassword = input.next();
					System.out.println("��ȷ�����룺");
					String newPass = input.next();
					if(newPassword.equals(newPass)) {
						int i=new UserDaoImpl().updateUserPassword(user.getUserName(),newPass);
						System.out.println(i);
						if(i>0) {
							System.out.println("�������޸ģ������µ�¼��");
							userLoginPage();
						}else {
							System.out.println("�����޸�ʧ�ܣ���");
						}
					}else {
						System.out.println("��������������޸����룺");
						continue b;
					}
					break;
				}
			}else {
				System.out.println("����������������룺");
				continue a;
			}
			break;
		}	
	}
	public static void userUpdatePasswordtoZeroPage() throws Exception {
		System.out.println("�������û��˺ţ�");
		int userAccount =0;
		userAccount =HandleInputMismatchException.handleInputMismatchException(userAccount);
		String userName = udi.queryUserByAccount(userAccount).getUserName();
		if(udi.comparisonUserAccount(userAccount)!=-1) {
			System.out.println("�Ƿ�Ҫ�������룺����(1)  ����(�����1�������������)");
			int choose=0;
			choose =HandleInputMismatchException.handleInputMismatchException(choose);
			switch(choose) {
			case 1:
				new UserDaoImpl().updateUserPassword(userName,"000000");//�ĳ�000000
				System.out.println("�������޸ģ���Ϊ��������һ��ҳ�棺");
				AdminView.adminOperateUserPage();
				break;
			default:
				AdminView.adminOperateUserPage();
				break;
			}
		}else {
			System.out.println("��������û������ڣ���ȷ�Ϻ��������룺");
			userUpdatePasswordtoZeroPage();
		}	
	}
	/**
	 * �������
	 * @param moviePrice
	 * @throws Exception
	 */
	public static void userUpBalance(double moviePrice) throws Exception{
		double oldBalance =udi.queryUserById(userNum).getUserBalance();
		double newBalance =oldBalance+moviePrice;
		udi.updateUserBalance(userNum, newBalance);
	}
	/**
	 * ������
	 * @param moviePrice
	 * @throws Exception
	 */
	public static void userDownBalance(double moviePrice) throws Exception{		
		double oldBalance =udi.queryUserById(userNum).getUserBalance();
		System.out.println(oldBalance);
		double newBalance =oldBalance-moviePrice;
		if(newBalance<0) {
			System.out.println("�����˻����㣬���Ƚ��г�ֵ��");
			System.out.println("�Ƿ���й���Ա���г�ֵ��\n��1�������й���Ա\n��2����������һ���б�");
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
					System.out.println("�������ѡ���������������룺��1�������й���Ա,��2����������һ���б�");
					continue a;
				}
			}			
		}
		System.out.println(newBalance);
		udi.updateUserBalance(userNum, newBalance);
	}
	/*
	 * ����Ա���û����г�ֵ
	 */
	public static void userUpdateBalance() throws Exception{
		System.out.println("�������û��˺ţ�");
		int userAccount =0;
		userAccount =HandleInputMismatchException.handleInputMismatchException(userAccount);
		int userId = udi.queryUserByAccount(userAccount).getUserId();
		if(udi.comparisonUserAccount(userAccount)!=-1) {
			double oldBalance =udi.queryUserById(userId).getUserBalance();
			System.out.println("�û���"+userAccount+" �˻����Ϊ��"+oldBalance);
			System.out.println("������Ҫ��ֵ��");
			double money = 0;
			money =HandleInputMismatchException.handleInputMismatchException(money);
			System.out.println("ȷ�ϳ�ֵ������1�����������������֣�");
			int choose=0;
			choose =HandleInputMismatchException.handleInputMismatchException(choose);
			if(choose==1) {				
				double newBalance =(oldBalance+money);
				int i=udi.updateUserBalance(userId, newBalance);
				if(i>0) {
					System.out.println("��ֵ�ɹ� ��ǰ���Ϊ��"+newBalance);
					AdminView.adminOperateUserPage();
				}else {
					System.out.println("��ֵʧ��");
				}
			}else {
				AdminView.adminOperateUserPage();
			}
		}else {
			System.out.println("��������û������ڣ���ȷ�Ϻ��������룺");
			userUpdateBalance();
		}	
	}
	public static void userUpdatePhone(int userId) throws Exception {
		User user = new UserDaoImpl().queryUserById(userId);
		a:while(true) {
			System.out.println("�����뵱ǰ�ֻ����룺");
			String phone = input.next();
			if(phone.equals(user.getUserPhone())){
				b:while(true) {
					String proving=ProvingNum.provingNum();
					System.out.println(proving);
					System.out.println("�������������֤�룺");
					String prov = input.next();
					if(prov.equals(proving)) {
						System.out.println("������Ҫ�޸ĵĵ绰���룺");
						String newPhone =input.next();
						System.out.println("��Ҫ�޸ĵ��µ绰�����ǣ�"+newPhone);
						System.out.println("ȷ���޸�������1����������������1����");
						int choose=0;
						choose=HandleInputMismatchException.handleInputMismatchException(choose);
						switch(choose) {
						case 1:
							int i=new UserDaoImpl().updateUserPhone(user.getUserId(), newPhone);
							if(i>0) {
								System.out.println("�绰�����޸ĳɹ�����Ϊ����ת���ϼ�ҳ��");
								userMeanPage();
							}else {
								System.out.println("�޸�ʧ�ܣ���");
							}						
						default:
							System.out.println("���Ѿ��������޸ĵ绰���룬��ѡ����һ��������");
							userMeanPage();
						}
					}else {
						System.out.println("��֤���������������������֤�룺");
						continue b;
					}
					break;
				}
			}else {
				System.out.println("�ֻ����벻ƥ�䣬�����������룺");
				continue a;
			}
			break;
		}
	}
	
	public static User userLoginPage() throws Exception {
		//User user = null;
		a:while(true) {
			System.out.println("�����������˺ţ�");
			int userAccount=0;
			userAccount=HandleInputMismatchException.handleInputMismatchException(userAccount);
			Userdao ud = new UserDaoImpl();
			if(ud.comparisonUserAccount(userAccount)!=-1) {
				b:while(true) {
					System.out.println("�������˻����룺");
					String userPassword=input.next();
					if(ud.comparisonUserPas(userAccount, userPassword)!=-1) {
						user = new UserDaoImpl().userLogin(userAccount, userPassword);
						userNum=user.getUserId();
						System.out.println("��¼�ɹ�����ӭ����"+user.getUserName());
						userMeanPage();
						break;
					}else {
						System.out.println("����������������룺");
						continue b;
					}
				}
			}else {
				System.out.println("��������˻����Ʋ���ȷ�����������룺");
				continue a;
			}
			break;
		}
	return user;
	}
	
	public static void userForgetPassWord() throws Exception{
		System.out.println("��ѡ�����Ĳ�����\n��1����ʹ�õ绰������֤��¼\n��2�������й���Ա������������\n��3�����˳�");
		uvc.userForgetPassWord();
	}
	/**
	 * �û����й���Ա�ķ���
	 */
	public static void userCallAdmin() {
		System.out.println("�Ե�Ƭ�̣��Ѿ������˹���Ա��Ϊ������");
		for(int i=0;i<6;i++) {
			try {
				Thread.sleep(1000);
				System.out.print(". ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n�����õ��ˣ����Ƚ��е�½��");
		try {
			AdminView.adminLoginPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * �õ绰�������֤���¼
	 */
	public static User LoginByPhone() throws Exception {
		a:while(true) {
			System.out.println("�����������˺ţ�");
			int userAccount=0;
			userAccount=HandleInputMismatchException.handleInputMismatchException(userAccount);
			Userdao ud = new UserDaoImpl();
			if(ud.comparisonUserAccount(userAccount)!=-1) {
				b:while(true) {
					System.out.println("���������ĵ绰���룺");
					String userPhone=input.next();
					boolean boo = JudjePhoneNumber.isMobileNO(userPhone);//�жϵ绰�����ʽ
			        if (boo) {
			        	if(ud.comparisonUserPhone(userAccount, userPhone)!=-1) {
			        		//��һ����֤��
			        		c:while(true) {
			        			String proving=ProvingNum.provingNum();
								System.out.println(proving);
								System.out.println("�������������֤�룺");
								String prov = input.next();
								if(prov.equals(proving)) {
									user = new UserDaoImpl().userLoginByPhone(userAccount, userPhone);
									userNum=user.getUserId();//��һ��ȫ��ʹ�õ��û����
									System.out.println("��¼�ɹ�����ӭ����"+user.getUserName());
									userMeanPage();
								}else {
									System.out.println("��֤���������������������֤�룺");
									continue c;
								}	
			        			break;
			        		}		        								
						}else {
							System.out.println("�Բ���������ĵ绰������Ԥ���ĵ绰���벻һ�£����������룺");
							continue b;
						}
			        } else {  
			            System.out.println("�绰�������,��������ȷ�ĵ绰���룺��13********* ,15********,18*********��");
			            continue b;
			        }					
			        break;
				}
			}else {
				System.out.println("��������˻����Ʋ���ȷ�����������룺");
				continue a;
			}
			break;
		}
		return user;
	}
	public static void userRegister() throws Exception{
		int userAccount = RandomAccount.randomAccount();
		System.out.println("������������");
		String userName = input.next();
		System.out.println("���������룺");
		String userPassword = input.next();
		System.out.println("�����볣ס���б�ţ�");
		int userCity=0;
		userCity=HandleInputMismatchException.handleInputMismatchException(userCity);
		a:while(true) {
			System.out.println("������绰����");
			String userPhone = input.next();
			boolean boo = JudjePhoneNumber.isMobileNO(userPhone);
	        if (boo) {
	        	User user = new User(userAccount,userName,userPassword,userCity,userPhone);
	    		int i = new UserDaoImpl().userRegister(user);
	    		if(i>0) {
	    			b:while(true) {
	    				System.out.println("ע��ɹ��������˺��ǣ�"+user.getUserAccount()+"�����μ������˺ţ�����");
	    				System.out.println("�Ƿ�������¼��1���ǣ�2����");
	    				int choose=0;
	    				choose=HandleInputMismatchException.handleInputMismatchException(choose);
	    				switch(choose) {
	    				case 1:
	    					userLoginPage();
	    					break;
	    				case 2:
	    					System.out.println("��Ϊ����ת����ҳ��");
	    					HomePage.homePage();
	    					break;
	    				default:
	    					System.out.println("�������ָ��������������룺");
	    					continue b;
	    				}
	    				break;
	    			}
	    		}
	            break;  
	        } else {  
	            System.out.println("�绰�������,��������ȷ�ĵ绰���룺��13********* ,15********,18*********��");
	            continue a;
	        }  
		}	
	}
	public static String UserToString(User user) {
		return user.getUserId()+"\t"+user.getUserAccount()+"\t"+user.getUserName()
		+"\t"+user.getUserCity()+"\t"+user.getUserPhone()+"\t"+user.getUserBalance();
	}
}
