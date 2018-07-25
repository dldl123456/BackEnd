package student;

import java.util.Arrays;
import java.util.Scanner;

public class Work2 {
	public static void main(String[] args) {
		Student[]arr=Student.getStudent();//取得学生信息的对象
		Student[]arr1=Student.str();//取得学生账号数组
		int elements=arr.length;
		Student[]arr2=new Student[elements];
		Manager[]managers=Manager.getMarrays();//取得管理员数组
		String user;
		int password;
		String name;//名字
		int age;//年龄
		String sex;//性别
		String address;//地址
		int math;//数学分数
		int English;//英语分数
		int sum;//总分
		
		System.out.println("***********欢迎来到学生管理系统************");
		System.out.println("1. 登录");
		System.out.println("2. 注册");
		System.out.println("3. 退出");
		System.out.println("*****************************************");
		System.out.println("请选择");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		switch (choice) {
			case 1:
				System.out.println("****************");
				System.out.println("1 学生登录");
				System.out.println("2 管理员登录");
				System.out.println("0 返回");
				System.out.println("****************");
				System.out.println("请选择");
				choice=in.nextInt();
				switch (choice) {
				case 1:
					
					break;
				case 2:
					System.out.println("请输入管理员账号");
					user=in.next();
					System.out.println("请输入管理员密码");
					password=in.nextInt();
					int answer=0;
					for (int i = 0; i < managers.length; i++) {
						if (managers[i].getAdmin().equals(user)&&managers[i].getPwd()==password) {
							answer=1;
						}
						switch (answer) {
						case 1:
							System.out.println("************主菜单功能***************");
							System.out.println("1.查看学生信息");
							System.out.println("2.添加学员信息");
							System.out.println("3.修改学员信息( 温馨提示：修改年龄和地址哦)");
							System.out.println("4.删除学员信息");
							System.out.println("5.返回");
							System.out.println("************************************");
							System.out.println("请选择");
							int answer1=in.nextInt();
							switch (answer1) {
								case 1:
									System.out.println("*******************************");
									System.out.println("您选择查看学生信息，功能如下：");
									System.out.println("1.查看所有学生信息");
									System.out.println("2.查看单个学生信息");
									System.out.println("3.查看总分排行榜");
									System.out.println("4.根据单个科目查看排行榜");
									int answer2=in.nextInt();
									switch (answer2) {
										case 1:
											System.out.println("名字\t性别\t年龄\t 数学\t英语\t总分");	
											for (int j = 0; j < arr.length; j++) {
												System.out.println(arr[j].toString());
											}
											break;
										case 2:
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
											break;
										case 3:
											for (int i1 = 0; i1 < arr.length-1; i1++) {
												for (int j = 0; j < arr.length-1-i1; j++) {
													if (arr[j].getMath()<arr[j+1].getMath()) {
														Student student=arr[j+1];
														arr[j+1]=arr[j];
														arr[j]=student;
													}
												}
											}
											System.out.println("名字\t性别\t年龄\t 数学\t英语\t总分");
											for (int k = 0; k< arr.length; k++) {
												System.out.println(arr[k].toString());
											}
											break;
										case 4:
											System.out.println("请输入您要查询的科目");
											String major=in.next();
											switch (major) {
											case "数学":
												for (int k = 0; k < arr.length-1; k++) {
													for (int j = 0; j < arr.length-1-i; j++) {
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
												break;
											default:
												System.out.println("您输入有误");
												break;
											}	
											break;
										default:
											System.out.println("您输入有误");
											break;
										}
										break;
								case 2:
									System.out.println("请输入学生姓名");	
									name=in.next();
									System.out.println("请输入年龄");
									age=in.nextInt();
									System.out.println("请输入性别");
									sex=in.next();
									System.out.println("请输入地址");
									address=in.next();
									System.out.println("请输入数学分数");
									math=in.nextInt();
									System.out.println("请输入英语分数");
									English=in.nextInt();
									sum=math+English;//总分
									arr=Arrays.copyOf(arr, arr.length+1);
									arr[arr.length-1]=new Student(name, age, sex, address, math, English, sum);
									System.out.println("增加成功");
									break;
								case 3:
									System.out.println("请输入您要修改的学生名字：");
									 name=in.next();
									boolean isTrue1=false;
									int index1=0;
									System.out.println(arr[0].getAddress());
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
									}else {
										System.out.println("您要修改的学生不存在");
									}
									break;							
								case 4:
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
									elements=arr.length;
									System.out.println(elements);
									System.out.println(arr[0].getAddress());
									for (int j = index2; j < arr.length-1; j++) {
										arr[j]=arr[j+1];
									}
									elements--;
									System.out.println(elements);
									System.out.println(arr[0].getAddress());
									}else {
										System.out.println("您要删除的学生不存在，删除失败");
									}
									break;
								default:
									System.out.println("您输入有误");
									break;
								}		
							break;

						default:
							System.out.println("您输入有误，请重新输入");
							break;
						}
					}
					break;
				case 3:
					
					break;
				default:
					System.out.println("您输入有误");
					break;
				}
				break;
			case 2:
				System.out.println("欢迎您注册学生管理系统账号");
				System.out.println("1. 注册管理员账号");
				System.out.println("2. 注册学生账号 ");
				System.out.println("0. 返回");
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
							System.out.println(managers[1]);
							managers[arr1.length-1]=new Manager(user, password);
							System.out.println("添加管理员成功");
							System.out.println(	managers[arr1.length-1].getAdmin());
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
					password=in.nextInt();
					for (int i = 0; i < arr1.length; i++) {
						if (arr1[i].getUser().equals(user)&&arr1[i].getPwd()==password) {
							isExit=0;
							break;
						}
					}
					switch (isExit) {
						case 1:
							arr1=Arrays.copyOf(arr1, arr1.length+1);//扩容
							System.out.println(arr1[1]);
							arr1[arr1.length-1]=new Student(user, password);
							System.out.println("添加学生成功");
							System.out.println(arr1.length);
							break;
						default:
							System.out.println("账号已存在");
							break;
						}
					break;
				case 3:
					
					break;
				default:
					break;
				}
				
				break;
			case 3:
				System.out.println("程序结束！！");
				return;
			default:
				System.out.println("您输入有误！");
				break;
			}
	}
}
