package project.StudentMS_4;

public class Administrator {
	//管理员账号
	private String user = "";  //管理员用户名
	private String pwd = "";  //管理员密码
	
	//构造方法(无参)
	public Administrator() {
		
	}
	//构造方法(管理员账号)
	public Administrator(String user,String pwd) {
		this.user = user;
		this.pwd = pwd;
	}
	
	//为管理员私有属性开放接口
	public  String getUser() {  //user
		return user;
	}
	public  void setUser (String user) {
		this.user = user;
	}

	public  String getPwd() {  //pwd
		return pwd;
	}
	public  void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//默认管理员账号
	public static Administrator[] adminAccount(){
		Administrator[] admin = new Administrator[1];
		Administrator admin1 = new Administrator("admin", "123123");
		admin[0] = admin1;
		return admin;
	}

	//测试类
	public static void main(String[] args) {
		Administrator[] adminAccount = Administrator.adminAccount();  //实例化管理员账号对象数组
		
		//管理员账号
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
	}
}
