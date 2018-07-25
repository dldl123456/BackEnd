package project.StudentMS_4;

import java.util.Arrays;
import java.util.Scanner;

//各种方法类
public class BaseMethod {
	//保存账号信息
	String user = "";  //用户名
	String pwd = "";  //密码
	//保存学生属性
	String name = "";  //名字
	String address = "";  //地址
	int age = 0;  //年龄
	char sex = 0;  //性别
	//保存学生成绩
	double math = 0.0;  //数学分数
	double English = 0.0;  //英语分数
	double chinese = 0.0;  //语文分数
	double sum = 0;  //总分
	//界面操作
	int num = 0;  //用来保存用户的选择
	boolean isTrue = false;  //用来判断是否进入
	int i,j;  //循环

	//判断验证码
	public int codeGen(Scanner in){
		String codegen = "";  //用来保存验证码
		int times = 3;  //限制用户输入的次数
		int count = 0;  //计数器
		int answer = 0;  //用来保存返回值
		
		//限定输入验证码的次数
		do{
			String codeGenAuto = RandomGen.getCodeGen();  //调用RandomGen类中的生成随机数方法，并将生成的随机数存入一个字符串变量中
			System.out.println("您的验证码是：" + codeGenAuto);
			System.out.print("请输入验证码(不区分大小写)：");
			codegen = in.next();
			
			//判断用户的输入是否正确
			if(codegen.equalsIgnoreCase(codeGenAuto)){  //不区分大小写
				System.out.println("验证码正确\n");
				answer = 1;
				break;
			}else{
				if(count < times-1){
					System.out.println("验证码错误，请重新输入\n");
				}
				count++;
				
				if(count == times){
					System.out.println("\n验证码输入错误超出" + times + "次，请重新注册  \n程序结束!");
					answer = 0;
					System.exit(0);
				}
			}
		}while(count<times);
		
		return answer;
	} 
	
	//注册主界面
	public void register(Scanner in, BaseMethod m, Administrator[] adminAccount, Student[] stuAccount, Student[] stuInfo) {
		System.out.println("[1]管理员注册   [2]学生注册   [3]返回");
		num = in.nextInt();  //让用户输入需要选择的项目
		
		switch(num){
			case 1:
				m.adminReg(in, adminAccount);
				break;
			case 2:
				m.stuReg(in, stuAccount);  //学生注册
				break;
			case 3:
				System.out.println("您已退出注册界面");
				break;
			default:
				System.out.println("您输入有误");
				break;
		}
	}
	
	//管理员注册
	public Administrator[] adminReg(Scanner in, Administrator[] adminAccount){
		System.out.println("您正在进行管理员注册");
		int count = 1;  //下标
		
		//输入
		System.out.print("请输入管理员账号：");
		user = in.next();
		System.out.print("请输入密码：");
		pwd = in.next();
		codeGen(in);  //验证码
		
		//对象数组扩容
		if(count>=adminAccount.length){
			int newCapacity = adminAccount.length + 1;  //扩容后的新数组的大小
			//把老数组(adminAccount)的数据拷贝到新数组(newCapacity)中,最后将数组名字换成adminAccount
			adminAccount = Arrays.copyOf(adminAccount, newCapacity);
		}
		//往对象数组中添加内容
		Administrator admin = new Administrator();
		admin.setUser(user);
		admin.setPwd(pwd);
		adminAccount[count++] = admin;  //存放admin到对象数组中
		
		System.out.println("恭喜你注册成功");
		
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return adminAccount;
	}
	
	//学生注册
	public Student[] stuReg(Scanner in, Student[] stuAccount){
		System.out.println("您正在进行学生注册");
		int count = 1;  //下标
		
		//输入
		System.out.print("请输入管理员账号：");
		user = in.next();
		System.out.print("请输入密码：");
		pwd = in.next();
		codeGen(in);  //验证码
		
		//对象数组扩容
		if(count>=stuAccount.length){
			int newCapacity = stuAccount.length + 1;  //扩容后的新数组的大小
			//把老数组(adminAccount)的数据拷贝到新数组(newCapacity)中,最后将数组名字换成adminAccount
			stuAccount = Arrays.copyOf(stuAccount, newCapacity);
		}
		//往对象数组中添加内容
		Student stu = new Student();
		stu.setUser(user);
		stu.setPwd(pwd);
		stuAccount[count++] = stu;  //存放stu到对象数组中
		
		System.out.println("恭喜你注册成功");
		
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return stuAccount;
	}
	
	//登录主界面
	public void login(Scanner in, BaseMethod m, Student[]stuAccount, Student[]stuInfo, Administrator[] adminAccount){
		System.out.println("[1]管理员登录   [2]学生登录   [3]返回");
		num = in.nextInt();  //让用户输入需要选择的项目
		
		switch(num){
			case 1:
				m.adminLogin(in, adminAccount);  //管理员登录
				//m.managerFunction(in, stuInfo, m);  //管理登录成功
				break;
			case 2:
				//int answer2 = 1;  //studentFunction中answer2为1时，进入到登录页面
				m.stuLogin(in, stuAccount);  //学生登录
				//m.studentFunction(answer2, in, stuInfo, isTrue, m);  //学生登录成功
				break;
			case 3:
				System.out.println("您已退出登录界面");
				break;
			default:
				System.out.println("您输入有误");
				break;
		}
	}
	
	//学生登录
	public void stuLogin(Scanner in, Student[] stuAccount){
		System.out.println("您正在进行学生登录：");
		
		for(Student i:stuAccount){
			System.out.println("默认学生账号：" + i.getUser() + "--" + i.getPwd());
			do{
				System.out.print("请输入学生账号：");
				user = in.next();
				System.out.print("请输入密码：");
				pwd = in.next();
				
				if(i.getUser().equals(user) && i.getPwd().equals(pwd)){
					codeGen(in);  //验证码
					System.out.println("登录成功！");
					isTrue = false;
				}else{
					System.out.println("--用户名或密码错误，请重新输入--");
					isTrue = true;
				}
			}while(isTrue);
		}
	}
	
	//管理员登录
	public void adminLogin(Scanner in, Administrator[] adminAccount){
		System.out.println("您正在进行管理员登录：");
		
		for(Administrator i:adminAccount){
			System.out.println("默认管理员生账号：" + i.getUser() + "--" + i.getPwd());
			
			do{
				System.out.print("请输入管理员账号：");
				user = in.next();
				System.out.print("请输入密码：");
				pwd = in.next();
				
				if(i.getUser().equals(user) && i.getPwd().equals(pwd)){
					codeGen(in);  //验证码
					System.out.println("登录成功！");
					isTrue = false;
				}else{
					System.out.println("---用户名或密码错误，请重新输入---");
					isTrue = true;
				}
			}while(isTrue);
		}
	}
		
	//查询学生信息
	public void select(Scanner in,Student[]stuInfo) {
		do {
			System.out.println("*******************************");
			System.out.println("请选择您需要的操作");
			System.out.println("[1] 查看所有学生信息");
			System.out.println("[2] 查看单个学生信息");
			System.out.println("[3] 查看总分排行榜");
			System.out.println("[4] 根据单个科目查看排行榜");
			System.out.println("[5] 返回");
			num = in.nextInt();
			switch (num) {
				case 1:
					//查看所有学生信息
					System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
					for (i = 0; i < stuInfo.length; i++) {
						System.out.println(stuInfo[j].toString());
					}
					isTrue=true;
					break;
				case 2:
					//查看单个学生信息
					System.out.println("请输入要查询的学生名字");
					String name1=in.next();
					int index=0;
					for (j = 0; j < stuInfo.length; j++) {
						if (stuInfo[j].getName().equals(name1)) {
							index=j;
							isTrue=true;
						}
					}
						if (isTrue) {
							System.out.println("您需要查询的学生信息如下：");
							System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
							System.out.println(stuInfo[index].toString());
						}else {
							System.out.println("抱歉您查询的学生基本信息不存在");
						}
						isTrue=true;
					break;
				case 3:
					//查看总分排行榜
					for (i = 0; i < stuInfo.length-1; i++) {
						for (j = 0; j < stuInfo.length-1-i; j++) {
							if (stuInfo[j].getSum()<stuInfo[j+1].getSum()) {
								Student student=stuInfo[j+1];
								stuInfo[j+1]=stuInfo[j];
								stuInfo[j]=student;
							}
						}
					}
					System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
					for (i = 0; i< stuInfo.length; i++) {
						System.out.println(stuInfo[i].toString());
					}
					isTrue=true;
					break;
				case 4:
					//根据单个科目查看排行榜
					System.out.println("请输入您要查询的科目(数学/语文/英语)");
					String major=in.next();
					switch (major) {
						case "数学":
							for (i = 0; i < stuInfo.length-1; i++) {
								for (j = 0; j < stuInfo.length-1-i; j++) {
									if (stuInfo[j].getMath()<stuInfo[j+1].getMath()) {
										Student student=stuInfo[j+1];
										stuInfo[j+1]=stuInfo[j];
										stuInfo[j]=student;
									}
								}
							}
							System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
							for (i = 0; i < stuInfo.length; i++) {
								System.out.println(stuInfo[i].toString());
							}
							isTrue=true;
							break;
						case "语文":
							for (i = 0; i < stuInfo.length-1; i++) {
								for (j = 0; j < stuInfo.length-1-i; j++) {
									if (stuInfo[j].getChinese()<stuInfo[j+1].getChinese()) {
										Student student=stuInfo[j+1];
										stuInfo[j+1]=stuInfo[j];
										stuInfo[j]=student;
									}
								}
							}
							System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
							for (i = 0; i < stuInfo.length; i++) {
								System.out.println(stuInfo[i].toString());
							}
							isTrue=true;
							break;
						case "英语":
							for (i = 0; i < stuInfo.length-1; i++) {
								for (j = 0; j < stuInfo.length-1-i; j++) {
									if (stuInfo[j].getEnglish()<stuInfo[j+1].getEnglish()) {
										Student student=stuInfo[j+1];
										stuInfo[j+1]=stuInfo[j];
										stuInfo[j]=student;
									}
								}
							}
							System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
							for (i = 0; i < stuInfo.length; i++) {
								System.out.println(stuInfo[i].toString());
							}
							isTrue=true;
							break;
						default:
							System.out.println("您输入有误");
							isTrue=true;
							break;
						}	
					break;
				case 0:
					System.out.println("您已退出查询模块");
					isTrue=false;
					break;
				default:
					System.out.println("您输入有误");
					isTrue=true;
					break;
				}
			
		} while (isTrue);
	}
	
	
	
	//管理功能模块
	public Student[] managerFunction(Scanner in,Student[]stuInfo, BaseMethod m) {
		boolean isEnteragain=false;
		do {
			System.out.println("************主菜单功能***************");
			System.out.println("1.查看学生信息");
			System.out.println("2.添加学员信息");
			System.out.println("3.修改学员信息( 温馨提示：修改年龄和地址哦)");
			System.out.println("4.删除学员信息");
			System.out.println("0.返回");
			System.out.println("************************************");
			System.out.println("请选择");
			boolean isTrue = in.hasNextInt();
			while (!isTrue) {//不是数字进入
				String str =  in.next();
				System.out.println("您输入的是:"+str+"  只能输入数字哦！");
				System.out.println("请重新输入：");
				isTrue=in.hasNextInt();
			}
			num=in.nextInt();//取出数字
			while (num>4||num<0) {
				System.out.println("您输入的格式,不符合您的口味哦,数字需要在1~5之间");
				System.out.println("请重新输入：");
				num=in.nextInt();
			}
			int answer1=num;
			switch (answer1) {
				case 1:
				m.select(in, stuInfo);//学生查询模块
					isEnteragain=true;
						break;
				case 2:
					stuInfo=m.add( in, isTrue,  stuInfo);//增加
					isEnteragain=true;
					break;
				case 3:
					stuInfo=m.update( in, stuInfo);//查询模块
					isEnteragain=true;
					break;							
				case 4:
					stuInfo=m.delete( in, stuInfo);//删除模块
					isEnteragain=true;
					break;
				case 0:
					System.out.println("您已退出管理员操作哦");
					isEnteragain=false;
					break;
				}		
		} while (isEnteragain);
		return stuInfo;	
	}
	

	
	//管理员添加模块
	public Student[] add(Scanner in,boolean isTrue,Student[]stuInfo){
		System.out.println("请输入学生姓名");
		name=in.next();
		System.out.println("请输入年龄");
		isTrue=in.hasNextInt();
		while (!isTrue) {//不是数字进入
			String str =  in.next();
			System.out.println("您输入的是:"+str+"  只能输入数字哦！");
			isTrue=in.hasNextInt();
		}
		age=in.nextInt();
		System.out.println("请输入性别");
		sex=in.next().charAt(0);
		System.out.println("请输入地址");
		address=in.next();
		System.out.println("请输入数学分数");
		isTrue=in.hasNextInt();
		while (!isTrue) {//不是数字进入
			String str =  in.next();
			System.out.println("您输入的是:"+str+"  只能输入数字哦！");
			System.out.println("请重新输入："+"1.学生登录  2.管理员登录 0.返回");
			isTrue=in.hasNextInt();
		}
		int choice=in.nextInt();//取出数字
		while (choice>100||choice<0) {
			System.out.println("您输入的格式,不符合您的口味哦,数字需要在0到100之间");
			System.out.println("请重新输入："+"数学分数");
			choice=in.nextInt();
		}
		math=choice;
		System.out.println("请输入英语分数");
		isTrue=in.hasNextInt();
		while (!isTrue) {//不是数字进入
			String str =  in.next();
			System.out.println("您输入的是:"+str+"  只能输入数字哦！");
			System.out.println("请重新输入："+"英语分数");
			isTrue=in.hasNextInt();
		}
		choice=in.nextInt();//取出数字
		while (choice>100||choice<0) {
			System.out.println("您输入的格式,不符合您的口味哦,数字需要在0到100之间");
			System.out.println("请重新输入："+"");
			choice=in.nextInt();
		}
		English=choice;
		sum=math+English;//总分
		stuInfo=Arrays.copyOf(stuInfo, stuInfo.length+1);
		stuInfo[stuInfo.length-1]=new Student(name, age, sex, address, math, chinese, English, sum);
		System.out.println("增加成功");
		return stuInfo;
	}
	
	//管理员删除模块
	public Student[] delete(Scanner in,Student[]stuInfo) {
		int elements=stuInfo.length;
		System.out.println("请输入删除学生的信息");
		name=in.next();
		boolean isTrue2=false;
		int index2=0;
		for (int j = 0; j < stuInfo.length; j++) {
			if (stuInfo[j].getName().equals(name)) {
				index2=j;
				isTrue2=true;
			}
		}
		if (isTrue2) {	
		for (int j = index2; j < stuInfo.length-1; j++) {
			stuInfo[j]=stuInfo[j+1];
		}
		elements--;
		Student[]arrNew=new Student[elements];
		for (int i = 0; i < arrNew.length; i++) {
			arrNew[i]=stuInfo[i];
		}
		stuInfo=arrNew;//删除后的对象数组赋值给原来的对象数组
		for (int i = 0; i < stuInfo.length; i++) {
			System.out.println(stuInfo[i].toString());
		}
		return stuInfo;
		}else {
			System.out.println("您要删除的学生不存在，删除失败");
		}
		return stuInfo;
	}
	
	//管理员修改模块
	public Student[] update (Scanner in,Student[]stuInfo){
		System.out.println("请输入您要修改的学生名字：");
		name=in.next();
		boolean isTrue1=false;
		int index1=0;
		for (int j = 0; j < stuInfo.length; j++) {
			if (stuInfo[j].getName().equals(name)) {
				index1=j;
				isTrue1=true;
			}
		}
		if (isTrue1) {
			System.out.println("请输入想要修改的学生年龄");
			int age1=in.nextInt();
			System.out.println("请输入想要修改的学生地址");
			String address1=in.next();
			stuInfo[index1].setAge(age1);
			stuInfo[index1].setAddress(address1);
			System.out.println("修改成功");
			return stuInfo;
		}else {
			System.out.println("您要修改的学生不存在");
		}
		return stuInfo;
	}
	
	//测试类
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Student[] stuInfo = Student.getStudent();  //实例化学生信息对象数组
		Student[] stuAccount = Student.stuAccount();  //实例化学生账号对象数组
		Administrator[] adminAccount = Administrator.adminAccount();  //实例化管理员账号对象数组
		
		BaseMethod m = new BaseMethod();
		Scanner in=new Scanner(System.in);  //输入
		
		/*//学生属性
		for(Student i:stuInfo){
			System.out.println(i);  //等同于i.toSting
		}
		
		//学生账号
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		//管理员账号
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}*/
		
		//注册
		//m.register(in, m, adminAccount, stuAccount, stuInfo);
		
		//登录
		//m.login(in, m, stuAccount, stuInfo, adminAccount);
		
		//查询
		m.select(in, stuInfo);
		
		
	}
	
}
