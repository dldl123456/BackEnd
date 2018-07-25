package arrays;

import java.util.Scanner;

import common.HandleInputMismatchException;
import entity.Student;
import test.Page;

//学生类数组及数组操作
public class StudentArr extends Student{
	public static Student[] stuu = new Student[15];//初始数组给定15个学生信息
	Student[] stuu1;//创建一个新数组，用于接收添加的学生信息
	protected Scanner input = new Scanner(System.in);
	int stuIndex=-1;//用来接收拿到学生的下标
	public StudentArr() {
		
	}
	//初始化的学生数据
	static{
		stuu[0] = new Student(170101,"王伟","000001",9,'男',"火山一号","羽毛球",0,89.0,95.0,75.0,259.0);
		stuu[1] = new Student(170102,"张天","000002",8,'男',"火山二号","蓝球",0,87.0,92.0,90.0,269.0);
		stuu[2] = new Student(170103,"李丽","000003",9,'女',"火山三号","排球",0,96.0,98.0,82.0,276.0);
		stuu[3] = new Student(170104,"刘翔","000004",9,'男',"火山一号","保龄球",0,92.0,80.0,93.0,265.0);
		stuu[4] = new Student(170105,"赵匡胤","000005",8,'男',"火山一号","足球",0,85.0,70.0,67.0,222.0);
		stuu[5] = new Student(170106,"孙思邈","000006",9,'男',"火山一号","乒乓球",0,73.0,95.0,72.0,240.0);
		stuu[6] = new Student(170107,"钱多多","000007",9,'男',"火山一号","橄榄球",0,98.0,88.0,78.0,264.0);
		stuu[7] = new Student(170108,"陈飞","000008",8,'男',"火山一号","玻璃球",0,79.0,89.0,77.0,245.0);
		stuu[8] = new Student(170109,"王美丽","000009",9,'男',"火山一号","毽子",0,90.0,99.0,89.0,278.0);
		stuu[9] = new Student(170110,"杜灿灿","000010",9,'男',"火山一号","打游戏",0,87.0,100.0,65.0,252.0);
		stuu[10] = new Student(170111,"张三丰","000011",9,'男',"火山一号","跑步",0,85.0,93.0,79.0,257.0);
		stuu[11] = new Student(170112,"周芷若","000012",8,'女',"火山一号","写作业",0,93.0,96.0,85.0,274.0);
		stuu[12] = new Student(170113,"阳顶天","000013",9,'男',"火山一号","唱歌",0,91.0,93.0,59.0,243.0);
		stuu[13] = new Student(170114,"乔峰","000014",10,'男',"火山一号","爬山",0,93.0,59.0,78.0,230.0);
		stuu[14] = new Student(170115,"慕容复","000015",9,'男',"火山一号","游泳",0,98.0,100.0,93.0,291.0);
	}
	/**
	 * 遍历数组按照姓名查找下标
	 */
	public int getIndexName(String stuName) {
		for(int i=0;i<stuu.length;i++) {
			if(stuName.equals(stuu[i].getName())) {
				stuIndex=i;
				break;
			}
		}
		return stuIndex;
	}
	/**
	 * 更改后的总分
	 * @param index  被更改的学生姓名下标
	 */
	public void newSum(int index) {
		stuu[index].setSum(stuu[index].getChiness(), stuu[index].getMath(), stuu[index].getEnglish());
	}
	/**
	 * 数组的添加方法
	 */
	public void addStu() {
		int length = stuu.length+1;
		setAccount(170100+length);
		newName();
		//默认密码设为6个0
		setPassword("000000");
		System.out.println("请输入年龄：");
		int newAge=0;
		newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
		setAge(newAge);
		System.out.println("请输入性别：");
		setSex(input.next().charAt(0));
		System.out.println("请输入地址：");
		setAddress(input.next());
		System.out.println("请输入爱好：");
		setHobbys(input.next());
		System.out.println("请输入语文成绩：");
		double chiness = 0;
		chiness =HandleInputMismatchException.handleInputMismatchException(chiness);
		setChiness(chiness);
		System.out.println("请输入数学成绩：");
		double math = 0;
		math =HandleInputMismatchException.handleInputMismatchException(math);
		setMath(math);
		System.out.println("请输入英语成绩：");
		double english = 0;
		english =HandleInputMismatchException.handleInputMismatchException(english);
		setEnglish(english);
		setSum(getChiness(),getMath(),getEnglish());
		System.out.println("总成绩为："+getSum());
		stuu1[stuu.length] = new Student(getAccount(),getName(),getPassword(),getAge(),
				getSex(),getAddress(),getHobbys(),getLoginTimes(),getChiness(),getMath(),getEnglish(),getSum());
		stuu = stuu1;
		System.out.println("添加成功，"+getName()+"的账号为:"+getAccount());
	}
	private String newName() {
		System.out.println("请输入要添加的学生姓名：");
		String stuName = input.next();
		setName(stuName);
		getIndexName(stuName);
		if(stuIndex!=-1) {
			System.out.println("该学生姓名已经存在，请选择下一步操作：");
			System.out.print("【1】、查看该学生信息\t\t【2】、查看所有学生信息\t\t【3】、继续添加其他学生\t\t【4】、返回上一步\n");
			int ch = 0;
			ch =HandleInputMismatchException.handleInputMismatchException(ch);
			switch(ch) {
			case 1:
				sayStuuOfName(stuName);
				break;
			case 2:
				ergodicStuu();
				break;
			case 3:
				addStu();
				break;
			case 4:
				Page.loginSuccess();
				break;
			default:
				System.out.println("您输入的指令有误，请重新输入：");
				break;
			}
			System.out.println("请选择您的下一步操作：");
			Page.loginSuccess();
		}else {
			//扩容
			stuu1 =new Student[stuu.length+1];
			for(int i=0;i<stuu.length;i++) {
				stuu1[i] = stuu[i];
			}
		}
		return stuName;
	}
	/**
	 * 删除学生信息
	 */
	public void deleteStu() {
		System.out.println("请输入要注销的学生姓名：");
		while(true) {
			String stuName = input.next();
			getIndexName(stuName);
			if(stuIndex!=-1) {
				Student[] stuu2 = new Student[stuu.length-1];
				if(stuIndex==0) {
					for(int i=1;i<stuu.length;i++) {
						stuu2[i-1] = stuu[i];
					}
				}else {
					for(int i=0;i<stuIndex;i++) {
						stuu2[i] = stuu[i];
					}
					for(int i=stuIndex+1;i<stuu.length;i++) {
						stuu2[i-1] = stuu[i];
					}
				}
				stuu=stuu2;
				System.out.println("删除成功，已为您返回上一级菜单");
				Page.loginSuccess();
			}else {
				System.out.println("对不起，系统中没有您要删除的学生，请选择下一步操作：");
				Page.loginSuccess();
			}
		}		
	}
	
	/**
	 * 遍历并输出数组信息（全部信息）
	 */
	public void ergodicStuu() {
		for(int i=0;i<stuu.length;i++) {
			System.out.println(stuu[i].toString());
		}
	}
	/**
	 * 遍历并输出数组信息（成绩）
	 */
	public void ergodicStuuScore() {
		for(int i=0;i<stuu.length;i++) {
			System.out.println(stuu[i].toString2());
		}
	}
	/**
	 * 根据姓名查看数组内容
	 */
	public void  sayStuuOfName(String stuName) {	
		getIndexName(stuName);
		if(stuIndex!=-1) {
			System.out.println("账号\t"+ "姓名\t"+"年龄\t"+"性别\t"+"家庭住址\t"+"兴趣爱好\t"+"状态");
			System.out.println(StudentArr.stuu[stuIndex].toString());
		}else {
			System.out.println("对不起，您输入的姓名不在系统中，请重新输入：");
			stuName = input.next();
			sayStuuOfName(stuName);
		}
	}
	/**
	 * 根据姓名更改数组信息（成绩）
	 */
	public void reviseStuuScore(String stuName) {
		getIndexName(stuName);
		if(stuIndex!=-1) {
			System.out.println(stuName+"的成绩如下：");
			System.out.println("姓名\t语文成绩\t数学成绩\t英语成绩\t总成绩");
			System.out.println(stuu[stuIndex].toString2());
			System.out.println("请输入要修改的科目：");
			b:while(true) {
				String subject = input.next();
				switch(subject) {
				case "语文":
					System.out.println("请输入要修改的分数：");
					double newChiness = 0;
					newChiness =HandleInputMismatchException.handleInputMismatchException(newChiness);
					stuu[stuIndex].setChiness(newChiness);
					newSum(stuIndex);//修改总分
					break;
				case "数学":
					System.out.println("请输入要修改的分数：");
					double newMath = 0;
					newMath =HandleInputMismatchException.handleInputMismatchException(newMath);
					stuu[stuIndex].setMath(newMath);
					newSum(stuIndex);
					break;
				case "英语":
					System.out.println("请输入要修改的分数：");
					double newEnglish = 0;
					newEnglish =HandleInputMismatchException.handleInputMismatchException(newEnglish);
					stuu[stuIndex].setEnglish(newEnglish);
					newSum(stuIndex);
					break;
				default:
					System.out.println("对不起，您输入的科目不正确，请重新输入：");
					continue b;
				}
				break;
			}
			System.out.println("修改后的成绩如下：");
			System.out.println("姓名\t语文成绩\t数学成绩\t英语成绩\t总成绩");
			System.out.println(stuu[stuIndex].toString2());
		}else {
			System.out.println("对不起，您输入的姓名不在系统中，请重新输入：");
			stuName = input.next();
			reviseStuuScore(stuName);
		}
	}

}
