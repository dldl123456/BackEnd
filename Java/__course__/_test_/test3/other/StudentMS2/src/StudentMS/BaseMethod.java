package StudentMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
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
	double english = 0.0;  //英语分数
	double chinese = 0.0;  //语文分数
	double sum = 0;  //总分
	//界面操作
	int num = 0;  //用来保存用户的选择
	int index = 0;  //用来保存索引
	int times = 3;  //限制用户输入的次数
	int count = 0;  //计数器
	boolean isTrue = false;  //用来判断是否进入
	boolean isNum = false;  //用来判断是否为数字
	boolean isExist = false;  //用来判断是否存在
	int i,j;  //循环
	
	//生成四位不重复的验证码
	public static String getCodeGen(){
		//一个字符数组
		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		Random radom = new Random();  //随机数
		StringBuilder sb = new StringBuilder();  //动态字符串
		int count = 0;  //计数器
		
		while(true){
			//随机产生一个下标，通过下标取出字符数组中的对应的字符
			char c = codeSequence[radom.nextInt(codeSequence.length)];
			
			//假设取出来的字符在动态字符串中不存在，代表没有重复
			if(sb.indexOf(c + "") == -1){
				sb.append(c);  //追加到动态字符串中
				count++;
				
				if(count == 4){
					break;
				}
			}
		}
		
		//返回字符串
		return sb.toString();
	}
	
	//判断验证码
	public void codeGen(Scanner in){
		String codegen = "";  //用来保存验证码
		
		//限定输入验证码的次数
		do{
			String codeGenAuto = BaseMethod.getCodeGen();  //调用RandomGen类中的生成随机数方法，并将生成的随机数存入一个字符串变量中
			System.out.println("您的验证码是：" + codeGenAuto);
			System.out.print("请输入验证码(不区分大小写)：");
			codegen = in.next();
			
			//判断用户的输入是否正确
			if(codegen.equalsIgnoreCase(codeGenAuto)){  //不区分大小写
				System.out.println("验证码正确\n");
				break;
			}else{
				if(count < times-1){
					System.out.println("验证码错误，请重新输入\n");
				}
				count++;
				
				if(count == times){
					System.out.println("\n验证码输入错误超出" + times + "次，请重新注册  \n程序结束!");
					System.exit(0);
				}
			}
		}while(count<times);
	} 
	
	//注册主界面
	public List register(Scanner in, BaseMethod m, Administrator[] adminAccount, Student[] stuAccount, Student[] stuInfo) {
		List list=new ArrayList();
		do{	
			System.out.println("[1]管理员注册   [2]学生注册   [3]返回\n");
			System.out.print("请输入您所需要的操作：");
			
			try{
				num = in.nextInt();  //让用户输入需要选择的项目
			}catch(InputMismatchException e){
				System.out.println("非法输入，程序结束!");
				System.exit(0);
			}
			
			switch(num){
				case 1:
					adminAccount = m.adminReg(in, adminAccount);
					list.add(adminAccount);
					isTrue = true;  //继续循环
					break;
				case 2:
					stuAccount = m.stuReg(in, stuAccount);  //学生注册
					list.add(stuAccount);
					isTrue = true;  //继续循环
					break;
				case 3:
					System.out.println("您已退出注册主界面~\n");
					isTrue = false;  //继续循环
					break;
				default:
					System.out.println("您输入有误");
					isTrue = true;  //继续循环
					break;
			}
		}while(isTrue);
		return list;
	}
	
	//登录主界面
	public void login(Scanner in, BaseMethod m, Student[] stuAccount, Student[] stuInfo, Administrator[] adminAccount){
		do{
			System.out.println("[1]管理员登录   [2]学生登录   [3]返回\n");
			System.out.print("请输入您所需要的操作：");
			
			try{
				num = in.nextInt();  //让用户输入需要选择的项目
			}catch(InputMismatchException e){
				System.out.println("非法输入，程序结束!");
				System.exit(0);
			}
			
			switch(num){
				case 1:
					System.out.println("管理员：");
					for (int i = 0; i < adminAccount.length; i++) {
						System.out.println(adminAccount[i].getUser()+" "+adminAccount[i].getPwd());
					}
					m.adminLogin(in, adminAccount, m, stuInfo);  //管理员登录
					isTrue = true;  //继续循环
					break;
				case 2:
					System.out.println("学生：");
					for (int i = 0; i < stuAccount.length; i++) {
						System.out.println(stuAccount[i].getUser()+" "+stuAccount[i].getPwd());
					}
					m.stuLogin(in, stuAccount, m, stuInfo);  //学生登录
					isTrue = true;  //继续循环
					break;
				case 3:
					System.out.println("您已退出登录主界面~\n");
					isTrue = false;  //跳出循环
					break;
				default:
					System.out.println("您的输入有误");
					isTrue = true;  //继续循环
					break;
			}
		}while(isTrue);
	}	

	//管理员主界面
	public Student[] StuOperation(Scanner in, BaseMethod m, Student[] stuInfo){
		do{
			System.out.println("--管理员主界面--");
			System.out.println("[1]查看学生信息");
			System.out.println("[2]添加学生信息");
			System.out.println("[3]修改学生信息(年龄和地址)");
			System.out.println("[4]删除学生信息");
			System.out.println("[5]返回\n");
			
			System.out.print("请输入您所需要的操作：");
			
			try{
				num = in.nextInt();  //让用户输入需要选择的项目
			}catch(InputMismatchException e){
				System.out.println("非法输入，程序结束!");
				System.exit(0);
			}

			switch(num){
				case 1:
					m.select(in, stuInfo);  //查询学生信息
					isTrue = true;  //继续循环
					break;
				case 2:
					stuInfo = m.add(in, stuInfo);  //添加
					isTrue = true;  //继续循环
					break;
				case 3:
					stuInfo = m.update(in, stuInfo);  //修改
					isTrue = true;  //继续循环
					break;
				case 4:
					stuInfo = m.delete( in, stuInfo);  //删除
					isTrue = true;  //继续循环
					break;
				case 5:
					System.out.println("您已退出管理员主界面~\n");
					isTrue = false;  //跳出循环
					break;
				default:
					System.out.println("您输入有误");
					isTrue = true;  //继续循环
					break;
			}
		}while(isTrue);
		
		return stuInfo;
	}
	
	//管理员注册
	public Administrator[] adminReg(Scanner in, Administrator[] adminAccount){
		System.out.println("--您正在进行管理员注册--");
		
		count = 1;  //下标
		
		//输入
		System.out.print("请输入管理员账号：");
		user = in.next();
		System.out.print("请输入密码：");
		pwd = in.next();
		codeGen(in);  //验证码
		
		adminAccount = Arrays.copyOf(adminAccount, adminAccount.length+1);
		adminAccount[adminAccount.length-1] = new Administrator(user, pwd);
		System.out.println("注册成功！");
		
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return adminAccount;
	}
	
	//学生注册
	public Student[] stuReg(Scanner in, Student[] stuAccount){
		System.out.println("--您正在进行学生注册--");
		
		count = 1;  //下标
		
		//输入
		System.out.print("请输入学生账号：");
		user = in.next();
		System.out.print("请输入密码：");
		pwd = in.next();
		codeGen(in);  //验证码
		
		stuAccount = Arrays.copyOf(stuAccount, stuAccount.length+1);
		stuAccount[stuAccount.length-1] = new Student(user, pwd);
		System.out.println("注册成功！");
		
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return stuAccount;
	}
	
	//管理员登录
	public void adminLogin(Scanner in, Administrator[] adminAccount, BaseMethod m, Student[] stuInfo) {
		System.out.println("--您正在进行管理员登录--");
		
		for(Administrator i:adminAccount){
			System.out.println("默认管理员生账号：" + i.getUser() + "--" + i.getPwd() + "\n");
			
			do{
				System.out.print("请输入管理员账号：");
				user = in.next();
				System.out.print("请输入密码：");
				pwd = in.next();
				
				if(i.getUser().equals(user) && i.getPwd().equals(pwd)){
					codeGen(in);  //验证码
					System.out.println("登录成功！\n");
					m.StuOperation(in, m, stuInfo);
					isTrue = false;
				}else{
					System.out.println("---用户名或密码错误，请重新输入---");
					isTrue = true;
				}
			}while(isTrue);
		}
	}
	
	//学生登录
	public void stuLogin(Scanner in, Student[] stuAccount, BaseMethod m, Student[] stuInfo){
		int num=0;
		System.out.println("--您正在进行学生登录--");
		for (int j = 0; j < stuAccount.length; j++) {
			System.out.println(stuAccount[j].getUser()+" "+stuAccount[j].getPwd());
		}
		do{
				System.out.print("请输入学生账号：");
				user = in.next();
				System.out.print("请输入密码：");
				pwd = in.next();
				for (int i = 0; i < stuAccount.length; i++) {
					if(stuAccount[i].getUser().equals(user) && stuAccount[i].getPwd().equals(pwd)) {
						num=1;
					}
				}
				switch (num) {
				case 1:
					codeGen(in);  //验证码
					System.out.println("登录成功！\n");
					m.select(in, stuInfo);
					isTrue = false;
					break;

				case 0:
					System.out.println("--用户名或密码错误，请重新输入--");
					isTrue = true;
					break;
				}
				
			}while(isTrue);
		
	}
		
	//查询学生信息（学生主界面）
	public void select(Scanner in, Student[] stuInfo) {
		do {
			System.out.println("--您正在进行学生信息查询--");
			System.out.println("[1]查看所有学生信息(根据总分排行)  [2]查看单个学生信息     [3]返回\n");
			System.out.print("请输入您所需要的操作：");
			num = in.nextInt();  //让用户输入需要选择的项目
			
			switch (num) {
				case 1:
					//查看所有学生信息（根据总分排行）
					for (i = 0; i<stuInfo.length-1; i++) {  //用冒泡对学生信息根据总分从大到小排序
						for (j = 0; j<stuInfo.length-1-i; j++) {
							if (stuInfo[j].getSum()<stuInfo[j+1].getSum()) {
								Student student = stuInfo[j+1];
								stuInfo[j+1] = stuInfo[j];
								stuInfo[j] = student;
							}
						}
					}
					
					//输出
					System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
					for(Student i:stuInfo){
						System.out.println(i);
					}
					
					System.out.println("\n");  //格式换行
					isTrue = true;  //继续循环
					break;
				case 2:
					//查看单个学生信息
					System.out.print("请输入要查询的学生名字：");
					name = in.next();  //让用户输入名字
					
					//遍历stuInfo对象数组进行查询，并返回其索引值
					for (i=0; i<stuInfo.length; i++) {
						if (stuInfo[i].getName().equals(name)) {  //若用户输入的名字和学生数据中的名字匹配，则输出学生对象数组中当前名字的索引
							index = i;
							isExist = true;  //当isExist被赋值，说明已经查询出所需对象的索引 
						}
					}
					//isExist==true，表示当所要查询的学生存在
					if (isExist) {
						System.out.println("您需要查询的学生信息如下：");
						System.out.println("名字\t性别\t年龄\t 数学\t语文\t英语\t总分\t地址\n");	
						System.out.println(stuInfo[index].toString());
					}else {
						System.out.println("抱歉您查询的学生基本信息不存在");
					}
					
					isTrue = true;  //继续循环
					break;
				case 3:
					System.out.println("您已退出查询界面\n");
					isTrue = false;  //跳出循环
					break;
				default:
					System.out.println("您输入有误");
					isTrue = true;  //继续循环
					break;
				}
		} while (isTrue);
	}
	
	//添加
	public Student[] add(Scanner in, Student[] stuInfo){
		System.out.println("--您正在进行学生信息添加--");
		System.out.print("请输入学生姓名：");  //添加姓名
		name = in.next();
		
		//添加年龄
		System.out.print("请输入年龄：");
		isNum = in.hasNextInt();  //判断是否为数字
		while (!isNum) {
			String str =  in.next();
			System.out.println("您输入的是:" + str + ",输入错误，请重新输入(数字)：");
			isNum = in.hasNextInt();
		}
		age = in.nextInt();
		while(age<0){
			System.out.print("您年龄应该大于0，请重新输入：");
			age = in.nextInt();
		}
		
		System.out.print("请输入性别：");  //添加性别
		sex = in.next().charAt(0);
		
		System.out.println("请输入地址：");  //添加地址
		address = in.next();
		
		System.out.print("请输入数学成绩：");  //添加数学成绩
		try{
			math = in.nextDouble();
			while(math<0||math>100){
				System.out.println("输入错误，请重新输入(0~100)：");
				math = in.nextDouble();
			}
		}catch(InputMismatchException e){
			System.out.println("非法输入，程序结束！");
			System.exit(0);
		}catch(Exception e){
			System.out.println("非法输入，程序结束！");
			System.exit(0);
		}
		
		System.out.print("请输入语文成绩：");  //添加语文成绩
		try{
			chinese = in.nextDouble();
			while(math<0||math>100){
				System.out.println("输入错误，请重新输入(0~100)：");
				chinese = in.nextDouble();
			}
		}catch(InputMismatchException e){
			System.out.println("非法输入，程序结束！");
			System.exit(0);
		}catch(Exception e){
			System.out.println("非法输入，程序结束！");
			System.exit(0);
		}
		
		System.out.print("请输入英语成绩：");  //添加英语成绩
		try{
			english = in.nextDouble();
			while(math<0||math>100){
				System.out.println("输入错误，请重新输入(0~100)：");
				english = in.nextDouble();
			}
		}catch(InputMismatchException e){
			System.out.println("非法输入，程序结束！");
			System.exit(0);
		}catch(Exception e){
			System.out.println("非法输入，程序结束！");
			System.exit(0);
		}
		
		sum = math + chinese + english;  //总分
		
		stuInfo = Arrays.copyOf(stuInfo, stuInfo.length+1);
		stuInfo[stuInfo.length-1] = new Student(name, age, sex, address, math, chinese, english, sum);
		System.out.println("添加成功！");
		
		for(Student i:stuInfo){
			System.out.println(i);  //等同于i.toSting
		}
		
		System.out.println(""); //格式换行
		
		return stuInfo;
	}
	
	//修改(名字和地址)
	public Student[] update (Scanner in, Student[] stuInfo){
		System.out.println("--您正在进行学生信息修改--");
		
		//限定输入次数
		do{
			System.out.print("请输入您要修改的学生名字：");
			name=in.next();  //让用户输入名字

			for (i = 0; i < stuInfo.length; i++) {
				if (stuInfo[i].getName().equals(name)) {
					index = i;
					isExist = true;
				}
			}
			if (isExist) {
				System.out.print("请输入想要修改的学生年龄：");
				age = in.nextInt();
				
				System.out.println("请输入想要修改的学生地址：");
				address = in.next();
				
				stuInfo[index].setAge(age);
				stuInfo[index].setAddress(address);
				
				System.out.println("修改成功！");
				break;
			}else {
				if(count < times-1){
					System.out.println("您要修改的学生不存在，请重新输入");
				}
				count++;
				
				if(count == times){
					System.out.println("\n输入错误超出" + times + "次， \n程序结束!");
					System.exit(0);
				}
			}
		}while(count<times);
		
		for(Student i:stuInfo){
			System.out.println(i);
		}
		
		System.out.println("");  //格式换行
		
		return stuInfo;
	}
	
	//删除
	public Student[] delete(Scanner in, Student[] stuInfo) {
		System.out.println("--您正在进行学生信息删除--");
		
		int arrLength = stuInfo.length;  //保存数组的长度
		
		//限定输入次数
		do{
			System.out.print("请输入您要删除的学生姓名：");
			name = in.next();  //让用户输入
			
			//找到名字对应的下标
			for (i = 0; i<stuInfo.length; i++) {
				if (stuInfo[i].getName().equals(name)) {
					index = i;
					isExist = true;
				}
			}
			//如果存在，进行删除
			if (isExist) {	
				for (i = index; i<stuInfo.length-1; i++) {
					stuInfo[i] = stuInfo[i+1];
				}
				
				arrLength--;
				Student[] newCapacity = new Student[arrLength];
				
				for (i = 0; i < newCapacity.length; i++) {
					newCapacity[i] = stuInfo[i];
				}
				
				stuInfo=newCapacity;  //删除后的对象数组赋值给原来的对象数组
				
				System.out.println("删除成功！");
				break;
			}else{
				if(count < times-1){
					System.out.println("您要删除的学生不存在，请重新输入");
				}
				count++;
				
				if(count == times){
					System.out.println("\n输入错误超出" + times + "次， \n程序结束!");
					System.exit(0);
				}
			}
		}while(count<times);
		
		
		for(Student i:stuInfo){
			System.out.println(i);
		}
		
		return stuInfo;
	}	

	//测试类
	public static void main(String[] args) {
		/*Student[] stuInfo = Student.getStudent();  //实例化学生信息对象数组
		Student[] stuAccount = Student.stuAccount();  //实例化学生账号对象数组
		Administrator[] adminAccount = Administrator.adminAccount();  //实例化管理员账号对象数组
		
		BaseMethod m = new BaseMethod();  //实例化方法类
		Scanner in=new Scanner(System.in);  //输入*/
		
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
		
		//对学生信息进行操作
		//m.StuOperation(in, m, stuInfo);
		
		//查询
		//m.select(in, stuInfo);
		
		//新增
		//m.add(in, stuInfo);
		
		//修改
		//m.update(in, stuInfo);
		
		//删除
		//m.delete(in, stuInfo);
	}
}
