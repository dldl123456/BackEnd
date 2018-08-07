package com.iotek.javabean;
/**
 * javabean对象本质就是一个类
 * @author Administrator
 *
 */
public class User implements java.io.Serializable{
      private String userName; 
      private String password;
      public User() {
		// TODO Auto-generated constructor stub
	  }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("userName"+userName);
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
      
      
}
