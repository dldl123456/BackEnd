package entity;
/**
 * 用户实体类
 * @author Administrator
 *
 */
public class User {
	private int userId;
	private int userAccount;
	private String userName;
	private String userPassword;
	private int userCity;
	private String userPhone;
	private double userBalance;
	public User() {
		super();
	}//无参构造方法
	public User(int userAccount, String userPassword) {
		super();
		this.userAccount = userAccount;
		this.userPassword = userPassword;
	}//登录构造方法
	public User( int userAccount, String userName, String userPassword, int userCity, String userPhone) {
		super();
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCity = userCity;
		this.userPhone = userPhone;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserCity() {
		return userCity;
	}
	public void setUserCity(int userCity) {
		this.userCity = userCity;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public double getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userCity=" + userCity + ", userPhone=" + userPhone + ", userBalance=" + userBalance
				+ "]";
	}

}
