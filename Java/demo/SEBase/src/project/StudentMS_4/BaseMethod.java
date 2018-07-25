package project.StudentMS_4;

import java.util.Arrays;
import java.util.Scanner;

//���ַ�����
public class BaseMethod {
	//�����˺���Ϣ
	String user = "";  //�û���
	String pwd = "";  //����
	//����ѧ������
	String name = "";  //����
	String address = "";  //��ַ
	int age = 0;  //����
	char sex = 0;  //�Ա�
	//����ѧ���ɼ�
	double math = 0.0;  //��ѧ����
	double English = 0.0;  //Ӣ�����
	double chinese = 0.0;  //���ķ���
	double sum = 0;  //�ܷ�
	//�������
	int num = 0;  //���������û���ѡ��
	boolean isTrue = false;  //�����ж��Ƿ����
	int i,j;  //ѭ��

	//�ж���֤��
	public int codeGen(Scanner in){
		String codegen = "";  //����������֤��
		int times = 3;  //�����û�����Ĵ���
		int count = 0;  //������
		int answer = 0;  //�������淵��ֵ
		
		//�޶�������֤��Ĵ���
		do{
			String codeGenAuto = RandomGen.getCodeGen();  //����RandomGen���е�����������������������ɵ����������һ���ַ���������
			System.out.println("������֤���ǣ�" + codeGenAuto);
			System.out.print("��������֤��(�����ִ�Сд)��");
			codegen = in.next();
			
			//�ж��û��������Ƿ���ȷ
			if(codegen.equalsIgnoreCase(codeGenAuto)){  //�����ִ�Сд
				System.out.println("��֤����ȷ\n");
				answer = 1;
				break;
			}else{
				if(count < times-1){
					System.out.println("��֤���������������\n");
				}
				count++;
				
				if(count == times){
					System.out.println("\n��֤��������󳬳�" + times + "�Σ�������ע��  \n�������!");
					answer = 0;
					System.exit(0);
				}
			}
		}while(count<times);
		
		return answer;
	} 
	
	//ע��������
	public void register(Scanner in, BaseMethod m, Administrator[] adminAccount, Student[] stuAccount, Student[] stuInfo) {
		System.out.println("[1]����Աע��   [2]ѧ��ע��   [3]����");
		num = in.nextInt();  //���û�������Ҫѡ�����Ŀ
		
		switch(num){
			case 1:
				m.adminReg(in, adminAccount);
				break;
			case 2:
				m.stuReg(in, stuAccount);  //ѧ��ע��
				break;
			case 3:
				System.out.println("�����˳�ע�����");
				break;
			default:
				System.out.println("����������");
				break;
		}
	}
	
	//����Աע��
	public Administrator[] adminReg(Scanner in, Administrator[] adminAccount){
		System.out.println("�����ڽ��й���Աע��");
		int count = 1;  //�±�
		
		//����
		System.out.print("���������Ա�˺ţ�");
		user = in.next();
		System.out.print("���������룺");
		pwd = in.next();
		codeGen(in);  //��֤��
		
		//������������
		if(count>=adminAccount.length){
			int newCapacity = adminAccount.length + 1;  //���ݺ��������Ĵ�С
			//��������(adminAccount)�����ݿ�����������(newCapacity)��,����������ֻ���adminAccount
			adminAccount = Arrays.copyOf(adminAccount, newCapacity);
		}
		//�������������������
		Administrator admin = new Administrator();
		admin.setUser(user);
		admin.setPwd(pwd);
		adminAccount[count++] = admin;  //���admin������������
		
		System.out.println("��ϲ��ע��ɹ�");
		
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return adminAccount;
	}
	
	//ѧ��ע��
	public Student[] stuReg(Scanner in, Student[] stuAccount){
		System.out.println("�����ڽ���ѧ��ע��");
		int count = 1;  //�±�
		
		//����
		System.out.print("���������Ա�˺ţ�");
		user = in.next();
		System.out.print("���������룺");
		pwd = in.next();
		codeGen(in);  //��֤��
		
		//������������
		if(count>=stuAccount.length){
			int newCapacity = stuAccount.length + 1;  //���ݺ��������Ĵ�С
			//��������(adminAccount)�����ݿ�����������(newCapacity)��,����������ֻ���adminAccount
			stuAccount = Arrays.copyOf(stuAccount, newCapacity);
		}
		//�������������������
		Student stu = new Student();
		stu.setUser(user);
		stu.setPwd(pwd);
		stuAccount[count++] = stu;  //���stu������������
		
		System.out.println("��ϲ��ע��ɹ�");
		
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return stuAccount;
	}
	
	//��¼������
	public void login(Scanner in, BaseMethod m, Student[]stuAccount, Student[]stuInfo, Administrator[] adminAccount){
		System.out.println("[1]����Ա��¼   [2]ѧ����¼   [3]����");
		num = in.nextInt();  //���û�������Ҫѡ�����Ŀ
		
		switch(num){
			case 1:
				m.adminLogin(in, adminAccount);  //����Ա��¼
				//m.managerFunction(in, stuInfo, m);  //�����¼�ɹ�
				break;
			case 2:
				//int answer2 = 1;  //studentFunction��answer2Ϊ1ʱ�����뵽��¼ҳ��
				m.stuLogin(in, stuAccount);  //ѧ����¼
				//m.studentFunction(answer2, in, stuInfo, isTrue, m);  //ѧ����¼�ɹ�
				break;
			case 3:
				System.out.println("�����˳���¼����");
				break;
			default:
				System.out.println("����������");
				break;
		}
	}
	
	//ѧ����¼
	public void stuLogin(Scanner in, Student[] stuAccount){
		System.out.println("�����ڽ���ѧ����¼��");
		
		for(Student i:stuAccount){
			System.out.println("Ĭ��ѧ���˺ţ�" + i.getUser() + "--" + i.getPwd());
			do{
				System.out.print("������ѧ���˺ţ�");
				user = in.next();
				System.out.print("���������룺");
				pwd = in.next();
				
				if(i.getUser().equals(user) && i.getPwd().equals(pwd)){
					codeGen(in);  //��֤��
					System.out.println("��¼�ɹ���");
					isTrue = false;
				}else{
					System.out.println("--�û����������������������--");
					isTrue = true;
				}
			}while(isTrue);
		}
	}
	
	//����Ա��¼
	public void adminLogin(Scanner in, Administrator[] adminAccount){
		System.out.println("�����ڽ��й���Ա��¼��");
		
		for(Administrator i:adminAccount){
			System.out.println("Ĭ�Ϲ���Ա���˺ţ�" + i.getUser() + "--" + i.getPwd());
			
			do{
				System.out.print("���������Ա�˺ţ�");
				user = in.next();
				System.out.print("���������룺");
				pwd = in.next();
				
				if(i.getUser().equals(user) && i.getPwd().equals(pwd)){
					codeGen(in);  //��֤��
					System.out.println("��¼�ɹ���");
					isTrue = false;
				}else{
					System.out.println("---�û����������������������---");
					isTrue = true;
				}
			}while(isTrue);
		}
	}
		
	//��ѯѧ����Ϣ
	public void select(Scanner in,Student[]stuInfo) {
		do {
			System.out.println("*******************************");
			System.out.println("��ѡ������Ҫ�Ĳ���");
			System.out.println("[1] �鿴����ѧ����Ϣ");
			System.out.println("[2] �鿴����ѧ����Ϣ");
			System.out.println("[3] �鿴�ܷ����а�");
			System.out.println("[4] ���ݵ�����Ŀ�鿴���а�");
			System.out.println("[5] ����");
			num = in.nextInt();
			switch (num) {
				case 1:
					//�鿴����ѧ����Ϣ
					System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
					for (i = 0; i < stuInfo.length; i++) {
						System.out.println(stuInfo[j].toString());
					}
					isTrue=true;
					break;
				case 2:
					//�鿴����ѧ����Ϣ
					System.out.println("������Ҫ��ѯ��ѧ������");
					String name1=in.next();
					int index=0;
					for (j = 0; j < stuInfo.length; j++) {
						if (stuInfo[j].getName().equals(name1)) {
							index=j;
							isTrue=true;
						}
					}
						if (isTrue) {
							System.out.println("����Ҫ��ѯ��ѧ����Ϣ���£�");
							System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
							System.out.println(stuInfo[index].toString());
						}else {
							System.out.println("��Ǹ����ѯ��ѧ��������Ϣ������");
						}
						isTrue=true;
					break;
				case 3:
					//�鿴�ܷ����а�
					for (i = 0; i < stuInfo.length-1; i++) {
						for (j = 0; j < stuInfo.length-1-i; j++) {
							if (stuInfo[j].getSum()<stuInfo[j+1].getSum()) {
								Student student=stuInfo[j+1];
								stuInfo[j+1]=stuInfo[j];
								stuInfo[j]=student;
							}
						}
					}
					System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
					for (i = 0; i< stuInfo.length; i++) {
						System.out.println(stuInfo[i].toString());
					}
					isTrue=true;
					break;
				case 4:
					//���ݵ�����Ŀ�鿴���а�
					System.out.println("��������Ҫ��ѯ�Ŀ�Ŀ(��ѧ/����/Ӣ��)");
					String major=in.next();
					switch (major) {
						case "��ѧ":
							for (i = 0; i < stuInfo.length-1; i++) {
								for (j = 0; j < stuInfo.length-1-i; j++) {
									if (stuInfo[j].getMath()<stuInfo[j+1].getMath()) {
										Student student=stuInfo[j+1];
										stuInfo[j+1]=stuInfo[j];
										stuInfo[j]=student;
									}
								}
							}
							System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
							for (i = 0; i < stuInfo.length; i++) {
								System.out.println(stuInfo[i].toString());
							}
							isTrue=true;
							break;
						case "����":
							for (i = 0; i < stuInfo.length-1; i++) {
								for (j = 0; j < stuInfo.length-1-i; j++) {
									if (stuInfo[j].getChinese()<stuInfo[j+1].getChinese()) {
										Student student=stuInfo[j+1];
										stuInfo[j+1]=stuInfo[j];
										stuInfo[j]=student;
									}
								}
							}
							System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
							for (i = 0; i < stuInfo.length; i++) {
								System.out.println(stuInfo[i].toString());
							}
							isTrue=true;
							break;
						case "Ӣ��":
							for (i = 0; i < stuInfo.length-1; i++) {
								for (j = 0; j < stuInfo.length-1-i; j++) {
									if (stuInfo[j].getEnglish()<stuInfo[j+1].getEnglish()) {
										Student student=stuInfo[j+1];
										stuInfo[j+1]=stuInfo[j];
										stuInfo[j]=student;
									}
								}
							}
							System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
							for (i = 0; i < stuInfo.length; i++) {
								System.out.println(stuInfo[i].toString());
							}
							isTrue=true;
							break;
						default:
							System.out.println("����������");
							isTrue=true;
							break;
						}	
					break;
				case 0:
					System.out.println("�����˳���ѯģ��");
					isTrue=false;
					break;
				default:
					System.out.println("����������");
					isTrue=true;
					break;
				}
			
		} while (isTrue);
	}
	
	
	
	//������ģ��
	public Student[] managerFunction(Scanner in,Student[]stuInfo, BaseMethod m) {
		boolean isEnteragain=false;
		do {
			System.out.println("************���˵�����***************");
			System.out.println("1.�鿴ѧ����Ϣ");
			System.out.println("2.���ѧԱ��Ϣ");
			System.out.println("3.�޸�ѧԱ��Ϣ( ��ܰ��ʾ���޸�����͵�ַŶ)");
			System.out.println("4.ɾ��ѧԱ��Ϣ");
			System.out.println("0.����");
			System.out.println("************************************");
			System.out.println("��ѡ��");
			boolean isTrue = in.hasNextInt();
			while (!isTrue) {//�������ֽ���
				String str =  in.next();
				System.out.println("���������:"+str+"  ֻ����������Ŷ��");
				System.out.println("���������룺");
				isTrue=in.hasNextInt();
			}
			num=in.nextInt();//ȡ������
			while (num>4||num<0) {
				System.out.println("������ĸ�ʽ,���������Ŀ�ζŶ,������Ҫ��1~5֮��");
				System.out.println("���������룺");
				num=in.nextInt();
			}
			int answer1=num;
			switch (answer1) {
				case 1:
				m.select(in, stuInfo);//ѧ����ѯģ��
					isEnteragain=true;
						break;
				case 2:
					stuInfo=m.add( in, isTrue,  stuInfo);//����
					isEnteragain=true;
					break;
				case 3:
					stuInfo=m.update( in, stuInfo);//��ѯģ��
					isEnteragain=true;
					break;							
				case 4:
					stuInfo=m.delete( in, stuInfo);//ɾ��ģ��
					isEnteragain=true;
					break;
				case 0:
					System.out.println("�����˳�����Ա����Ŷ");
					isEnteragain=false;
					break;
				}		
		} while (isEnteragain);
		return stuInfo;	
	}
	

	
	//����Ա���ģ��
	public Student[] add(Scanner in,boolean isTrue,Student[]stuInfo){
		System.out.println("������ѧ������");
		name=in.next();
		System.out.println("����������");
		isTrue=in.hasNextInt();
		while (!isTrue) {//�������ֽ���
			String str =  in.next();
			System.out.println("���������:"+str+"  ֻ����������Ŷ��");
			isTrue=in.hasNextInt();
		}
		age=in.nextInt();
		System.out.println("�������Ա�");
		sex=in.next().charAt(0);
		System.out.println("�������ַ");
		address=in.next();
		System.out.println("��������ѧ����");
		isTrue=in.hasNextInt();
		while (!isTrue) {//�������ֽ���
			String str =  in.next();
			System.out.println("���������:"+str+"  ֻ����������Ŷ��");
			System.out.println("���������룺"+"1.ѧ����¼  2.����Ա��¼ 0.����");
			isTrue=in.hasNextInt();
		}
		int choice=in.nextInt();//ȡ������
		while (choice>100||choice<0) {
			System.out.println("������ĸ�ʽ,���������Ŀ�ζŶ,������Ҫ��0��100֮��");
			System.out.println("���������룺"+"��ѧ����");
			choice=in.nextInt();
		}
		math=choice;
		System.out.println("������Ӣ�����");
		isTrue=in.hasNextInt();
		while (!isTrue) {//�������ֽ���
			String str =  in.next();
			System.out.println("���������:"+str+"  ֻ����������Ŷ��");
			System.out.println("���������룺"+"Ӣ�����");
			isTrue=in.hasNextInt();
		}
		choice=in.nextInt();//ȡ������
		while (choice>100||choice<0) {
			System.out.println("������ĸ�ʽ,���������Ŀ�ζŶ,������Ҫ��0��100֮��");
			System.out.println("���������룺"+"");
			choice=in.nextInt();
		}
		English=choice;
		sum=math+English;//�ܷ�
		stuInfo=Arrays.copyOf(stuInfo, stuInfo.length+1);
		stuInfo[stuInfo.length-1]=new Student(name, age, sex, address, math, chinese, English, sum);
		System.out.println("���ӳɹ�");
		return stuInfo;
	}
	
	//����Աɾ��ģ��
	public Student[] delete(Scanner in,Student[]stuInfo) {
		int elements=stuInfo.length;
		System.out.println("������ɾ��ѧ������Ϣ");
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
		stuInfo=arrNew;//ɾ����Ķ������鸳ֵ��ԭ���Ķ�������
		for (int i = 0; i < stuInfo.length; i++) {
			System.out.println(stuInfo[i].toString());
		}
		return stuInfo;
		}else {
			System.out.println("��Ҫɾ����ѧ�������ڣ�ɾ��ʧ��");
		}
		return stuInfo;
	}
	
	//����Ա�޸�ģ��
	public Student[] update (Scanner in,Student[]stuInfo){
		System.out.println("��������Ҫ�޸ĵ�ѧ�����֣�");
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
			System.out.println("��������Ҫ�޸ĵ�ѧ������");
			int age1=in.nextInt();
			System.out.println("��������Ҫ�޸ĵ�ѧ����ַ");
			String address1=in.next();
			stuInfo[index1].setAge(age1);
			stuInfo[index1].setAddress(address1);
			System.out.println("�޸ĳɹ�");
			return stuInfo;
		}else {
			System.out.println("��Ҫ�޸ĵ�ѧ��������");
		}
		return stuInfo;
	}
	
	//������
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Student[] stuInfo = Student.getStudent();  //ʵ����ѧ����Ϣ��������
		Student[] stuAccount = Student.stuAccount();  //ʵ����ѧ���˺Ŷ�������
		Administrator[] adminAccount = Administrator.adminAccount();  //ʵ��������Ա�˺Ŷ�������
		
		BaseMethod m = new BaseMethod();
		Scanner in=new Scanner(System.in);  //����
		
		/*//ѧ������
		for(Student i:stuInfo){
			System.out.println(i);  //��ͬ��i.toSting
		}
		
		//ѧ���˺�
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		//����Ա�˺�
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}*/
		
		//ע��
		//m.register(in, m, adminAccount, stuAccount, stuInfo);
		
		//��¼
		//m.login(in, m, stuAccount, stuInfo, adminAccount);
		
		//��ѯ
		m.select(in, stuInfo);
		
		
	}
	
}
