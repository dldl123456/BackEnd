package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/*
 * 方法类实现增删改查接口
 */
public class Methodstu implements Student_add,Student_delete,Student_update,Student_select{
	String user = null;//用户名
	int password = 0;//密码
	String name = null;//名字
	int age = 0;//年龄
	String sex = null;//性别
	String address = null;//地址
	int math = 0;//数学分数
	int English = 0;//英语分数
	int sum = 0;//总分
	int choice=0;
	/*
	 * 一、主界面
	 */
	public void Login() {
		System.out.println("***********欢迎来到学生管理系统************");
		System.out.println("1. 登录");
		System.out.println("2. 注册");
		System.out.println("3. 退出");
		System.out.println("*****************************************");
		System.out.println("请选择");
	}
	/*
	 * 二、登录模块
	 */
	public boolean enter(Scanner in,Student[]arr1,Student[]arr,Manager[]managers,boolean isAgin,int elements,Methodstu m) {
		boolean isEnter=false;
		System.out.println("****************");
		System.out.println("1.学生登录");
		System.out.println("2.管理员登录");
		System.out.println("0.返回");
		System.out.println("****************");
		System.out.println("请选择");
		boolean isTrue=in.hasNextInt();
		while (!isTrue) {//不是数字进入
			String str =  in.next();
			System.out.println("您输入的是:"+str+"  只能输入数字哦！");
			System.out.println("请重新输入："+"1.学生登录  2.管理员登录 0.返回");
			isTrue=in.hasNextInt();
		}
		choice=in.nextInt();//取出数字
		while (choice>2||choice<0) {
			System.out.println("您输入的格式,不符合您的口味哦,数字需要在0~2之间");
			System.out.println("请重新输入："+"1.学生登录  2.管理员登录 0.返回");
			choice=in.nextInt();
		}
		switch (choice) {
		case 1:
			int answer2 = 0;
			try {
				answer2 = m.studentEnter(user, in, password, arr1, m);//学生账号验证
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			m.studentFunction(answer2, in, arr, isAgin,m);//学生登陆成功的功能
			isEnter=true;
			break;
		case 2:
			int answer=m.managerEnter(in, managers);//管理登录验证
			switch (answer) {
				case 1:
					m.managerFunction(in, arr, m);//管理功能模块
					break;
				default:
					System.out.println("您输入有误，请重新输入");//密码输入错误
					break;
				}
			break;
		case 0:
			System.out.println("您选择退出登录");
			isEnter=false;
			break;
		default:
			System.out.println("您输入有误");
			break;
		}
		return isEnter;
	}
	
	/*
	 * 二、
	 * 1.验证码功能
	 */
	public  int IdentityCode() {
		 String a="1234567890qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
	        Random i=new Random();
	        int answer=0;
	        int[] array=new int[4];
	        for(int j=0;j<4;j++)
	        {
	            array[j]=i.nextInt(62);
	            System.out.print(a.charAt(array[j])+" ");
	        }
	        System.out.println("请输入上图验证码，注意大小写：");
	        Scanner c=new Scanner(System.in);
	        String d=c.next();
	        char[] e={a.charAt(array[0]),a.charAt(array[1]),a.charAt(array[2]),a.charAt(array[3])};
	        String f=new String(e);//强制转换相同类型，方便比较
	        boolean g=d.equals(f);
	        if(g==true)
	        {
	           System.out.println("验证码输入正确");
	           answer=1;
	         }else {
				System.out.println("输入错误");
				answer=0;
			} 
	        return answer;
	}
	
	/*
	 * 二、
	 * 2.学生登录验证
	 */
		public int studentEnter(String user,Scanner in,int password,Student []arr1,Methodstu m) throws Exception{
			int answer1=0;
			System.out.println("请输入学生账号");
			user=in.next();
			System.out.println("请输入密码");
			if (in.hasNextInt()) {
				password=in.nextInt();
			}else {
				Exception Exception = null;
				throw Exception;
			}
			int answer2=0;
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i].getUser().equals(user)&&arr1[i].getPwd()==password) {
					answer2=1;
				}
			}
			int answer3=m.IdentityCode();//验证码
			if (answer2==1&&answer3==1) {
				answer1=1;
			}
			return answer1;
		}
	  
	
	/*二、
	 * 3.学生账号功能模块
	 */
		public void studentFunction(int answer2,Scanner in,Student[]arr,boolean isAgin,Methodstu m) {
			switch (answer2) {
			  case 1:
				m.select(in, arr, isAgin);
				break;
			default:
				System.out.println("您输入信息有误");
				break;
			}
		}
		/*
		 * 二、管理账号登录模块
		 */
		public int managerEnter(Scanner in,Manager[]managers) {
			System.out.println("请输入管理员账号");
			user=in.next();
			System.out.println("请输入管理员密码");
			try {
				password=in.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			int answer=0;
			boolean isEnter = true;
			for (int i = 0; i < managers.length; i++) {
				if (managers[i].getAdmin().equals(user)&&managers[i].getPwd()==password) {
					answer=1;
				}
			}
			return answer;
		}
		
		/*
		 * 管理功能模块
		 */
		public Student[] managerFunction(Scanner in,Student[]arr,Methodstu m) {
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
				choice=in.nextInt();//取出数字
				while (choice>4||choice<0) {
					System.out.println("您输入的格式,不符合您的口味哦,数字需要在1~5之间");
					System.out.println("请重新输入：");
					choice=in.nextInt();
				}
				int answer1=choice;
				switch (answer1) {
					case 1:
					boolean isAgin = false;
					m.select(in, arr, isAgin);//学生查询模块
						isEnteragain=true;
							break;
					case 2:
						arr=m.add( in, isTrue,  arr);//增加
						isEnteragain=true;
						break;
					case 3:
						arr=m.update( in, arr);//查询模块
						isEnteragain=true;
						break;							
					case 4:
						arr=m.delete( in, arr);//删除模块
						isEnteragain=true;
						break;
					case 0:
						System.out.println("您已退出管理员操作哦");
						isEnteragain=false;
						break;
					}		
			} while (isEnteragain);
			return arr;	
		}
	/*
	 * 二、
	 * 3.查询功能模块(学生/管理员公用)
	 */
	public void select(Scanner in,Student[]arr,boolean isAgin) {
		do {
			System.out.println("*******************************");
			System.out.println("您选择查看学生信息，功能如下：");
			System.out.println("1.查看所有学生信息");
			System.out.println("2.查看单个学生信息");
			System.out.println("3.查看总分排行榜");
			System.out.println("4.根据单个科目查看排行榜");
			System.out.println("0.返回");
			int answer3=in.nextInt();
			switch (answer3) {
				case 1:
					//查看所有学生信息
					System.out.println("名字\t性别\t年龄\t 数学\t英语\t总分");	
					for (int j = 0; j < arr.length; j++) {
						System.out.println(arr[j].toString());
					}
					isAgin=true;
					break;
				case 2:
					//查看单个学生信息
					System.out.println("请输入要查询的学生名字");
					String name1=in.next();
					boolean isTrue=false;
					int index=0;
					for (int j = 0; j < arr.length; j++) {
						if (arr[j].getName().equals(name1)) {
							index=j;
							isTrue=true;
						}
					}
						if (isTrue) {
							System.out.println("您需要查询的学生信息如下：");
							System.out.println("名字\t性别\t年龄\t 数学\t英语\t总分");
							System.out.println(arr[index].toString());
						}else {
							System.out.println("抱歉您查询的学生基本信息不存在");
						}
						isAgin=true;
					break;
				case 3:
					//查看总分排行榜
					for (int i1 = 0; i1 < arr.length-1; i1++) {
						for (int j = 0; j < arr.length-1-i1; j++) {
							if (arr[j].getSum()<arr[j+1].getSum()) {
								Student student=arr[j+1];
								arr[j+1]=arr[j];
								arr[j]=student;
							}
						}
					}
					System.out.println("名字\t性别\t年龄\t 数学\t英语\t总分\t地址");
					for (int k = 0; k< arr.length; k++) {
						System.out.println(arr[k].toString());
					}
					isAgin=true;
					break;
				case 4:
					//根据单个科目查看排行榜
					System.out.println("请输入您要查询的科目(数学/英语)");
					String major=in.next();
					switch (major) {
						case "数学":
							for (int k = 0; k < arr.length-1; k++) {
								for (int j = 0; j < arr.length-1-k; j++) {
									if (arr[j].getMath()<arr[j+1].getMath()) {
										Student student=arr[j+1];
										arr[j+1]=arr[j];
										arr[j]=student;
									}
								}
							}
							System.out.println("名字\t性别\t年龄\t 数学\t英语\t总分");
							for (int q = 0; q < arr.length; q++) {
								System.out.println(arr[q].toString());
							}
							isAgin=true;
							break;
						case "英语":
							for (int i1 = 0; i1 < arr.length-1; i1++) {
								for (int j = 0; j < arr.length-1-i1; j++) {
									if (arr[j].getEnglish()<arr[j+1].getEnglish()) {
										Student student=arr[j+1];
										arr[j+1]=arr[j];
										arr[j]=student;
									}
								}
							}
							System.out.println("名字\t性别\t年龄\t 数学\t英语\t总分");
							for (int j = 0; j < arr.length; j++) {
								System.out.println(arr[j].toString());
							}
							isAgin=true;
							break;
						default:
							System.out.println("您输入有误");
							isAgin=true;
							break;
						}	
					break;
				case 0:
					System.out.println("您已退出查询模块");
					isAgin=false;
					break;
				default:
					System.out.println("您输入有误");
					break;
				}
			
		} while (isAgin);
	}
	
	/*
	 * 管理员添加模块
	 */
	public Student[] add(Scanner in,boolean isTrue,Student[]arr){
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
		sex=in.next();
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
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=new Student(name, age, sex, address, math, English, sum);
		System.out.println("增加成功");
		return arr;
	}
	/*
	 * 二、
	 * 管理员删除模块
	 */
	public Student[] delete(Scanner in,Student[]arr) {
		int elements=arr.length;
		System.out.println("请输入删除学生的信息");
		name=in.next();
		boolean isTrue2=false;
		int index2=0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j].getName().equals(name)) {
				index2=j;
				isTrue2=true;
			}
		}
		if (isTrue2) {	
		for (int j = index2; j < arr.length-1; j++) {
			arr[j]=arr[j+1];
		}
		elements--;
		Student[]arrNew=new Student[elements];
		for (int i = 0; i < arrNew.length; i++) {
			arrNew[i]=arr[i];
		}
		arr=arrNew;//删除后的对象数组赋值给原来的对象数组
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}
		return arr;
		}else {
			System.out.println("您要删除的学生不存在，删除失败");
		}
		return arr;
	}
	
	/*
	 * 二、
	 * 管理员修改模块
	 */
	public Student[] update (Scanner in,Student[]arr){
		System.out.println("请输入您要修改的学生名字：");
		name=in.next();
		boolean isTrue1=false;
		int index1=0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j].getName().equals(name)) {
				index1=j;
				isTrue1=true;
			}
		}
		if (isTrue1) {
			System.out.println("请输入想要修改的学生年龄");
			int age1=in.nextInt();
			System.out.println("请输入想要修改的学生地址");
			String address1=in.next();
			arr[index1].setAge(age1);
			arr[index1].setAddress(address1);
			System.out.println("修改成功");
			return arr;
		}else {
			System.out.println("您要修改的学生不存在");
		}
		return arr;
	}
	
	/*
	 * 三、注册模块
	 */
	public List register(Scanner in,Manager[]managers,Student[]arr1) {
		List list=new ArrayList();
		System.out.println("欢迎您注册学生管理系统账号");
		System.out.println("1. 注册管理员账号");
		System.out.println("2. 注册学生账号 ");
		System.out.println("0. 返回");
		System.out.println("请选择");
		int register=in.nextInt();
		int isExit=1;
		switch (register) {
		case 1:
			System.out.println("请输入管理员账号");
			user=in.next();
			System.out.println("请输入密码");
			password=in.nextInt();
			//验证是否存在
			for (int i = 0; i < managers.length; i++) {
				if (managers[i].getAdmin().equals(user)&&managers[i].getPwd()==password) {
					isExit=0;
					break;
				}
			}
			switch (isExit) {
				case 1:
					managers=Arrays.copyOf(managers, managers.length+1);//扩容
					managers[arr1.length-1]=new Manager(user, password);
					System.out.println("添加管理员成功");
					list.add(managers);
					break;
				default:
					System.out.println("账号已存在");
					break;
				}
			break;
		case 2:
			System.out.println("请输入学生账号");
			user=in.next();
			System.out.println("请输入密码");
			try {
				password=in.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i].getUser().equals(user)&&arr1[i].getPwd()==password) {
					isExit=0;
					break;
				}
			}
			switch (isExit) {
				case 1:
					arr1=Arrays.copyOf(arr1, arr1.length+1);//扩容
					arr1[arr1.length-1]=new Student(user, password);
					System.out.println("添加学生成功");
					list.add(arr1);
					break;
				default:
					System.out.println("账号已存在");
					break;
				}
			break;
		case 0:
			System.out.println("您选择退出注册");
			break;
		default:
			System.out.println("您输入有误，必须在0~2");
			break;
		}
		return list;
	}
	
}
