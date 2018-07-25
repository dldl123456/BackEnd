package student;

import java.util.Arrays;
import java.util.Scanner;

public class Manager {
	private  String admin;//管理员账号
	private int pwd;//管理员密码
	
	public Manager() {
		
	}
	public Manager(String admin,int pwd) {
		this.admin=admin;
		this.pwd=pwd;
	}
	public  String getAdmin() {
		return admin;
	}

	public  void setAdmin(String admin) {
		admin = admin;
	}

	public  int getPwd() {
		return pwd;
	}

	public  void setPwd(int pwd) {
		pwd = pwd;
	}
	
	//返回管理员数组
	public static Manager[] getMarrays(){
		Manager[] Marray=new Manager[1];
		Manager manager1=new Manager("admin", 123456);
		Marray[0]=manager1;
		 return Marray;
	}

}
