package project.StudentMS_4;

public class Administrator {
	//����Ա�˺�
	private String user = "";  //����Ա�û���
	private String pwd = "";  //����Ա����
	
	//���췽��(�޲�)
	public Administrator() {
		
	}
	//���췽��(����Ա�˺�)
	public Administrator(String user,String pwd) {
		this.user = user;
		this.pwd = pwd;
	}
	
	//Ϊ����Ա˽�����Կ��Žӿ�
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
	
	//Ĭ�Ϲ���Ա�˺�
	public static Administrator[] adminAccount(){
		Administrator[] admin = new Administrator[1];
		Administrator admin1 = new Administrator("admin", "123123");
		admin[0] = admin1;
		return admin;
	}

	//������
	public static void main(String[] args) {
		Administrator[] adminAccount = Administrator.adminAccount();  //ʵ��������Ա�˺Ŷ�������
		
		//����Ա�˺�
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
	}
}
