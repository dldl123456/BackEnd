package StudentMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
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
	double english = 0.0;  //Ӣ�����
	double chinese = 0.0;  //���ķ���
	double sum = 0;  //�ܷ�
	//�������
	int num = 0;  //���������û���ѡ��
	int index = 0;  //������������
	int times = 3;  //�����û�����Ĵ���
	int count = 0;  //������
	boolean isTrue = false;  //�����ж��Ƿ����
	boolean isNum = false;  //�����ж��Ƿ�Ϊ����
	boolean isExist = false;  //�����ж��Ƿ����
	int i,j;  //ѭ��
	
	//������λ���ظ�����֤��
	public static String getCodeGen(){
		//һ���ַ�����
		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		Random radom = new Random();  //�����
		StringBuilder sb = new StringBuilder();  //��̬�ַ���
		int count = 0;  //������
		
		while(true){
			//�������һ���±꣬ͨ���±�ȡ���ַ������еĶ�Ӧ���ַ�
			char c = codeSequence[radom.nextInt(codeSequence.length)];
			
			//����ȡ�������ַ��ڶ�̬�ַ����в����ڣ�����û���ظ�
			if(sb.indexOf(c + "") == -1){
				sb.append(c);  //׷�ӵ���̬�ַ�����
				count++;
				
				if(count == 4){
					break;
				}
			}
		}
		
		//�����ַ���
		return sb.toString();
	}
	
	//�ж���֤��
	public void codeGen(Scanner in){
		String codegen = "";  //����������֤��
		
		//�޶�������֤��Ĵ���
		do{
			String codeGenAuto = BaseMethod.getCodeGen();  //����RandomGen���е�����������������������ɵ����������һ���ַ���������
			System.out.println("������֤���ǣ�" + codeGenAuto);
			System.out.print("��������֤��(�����ִ�Сд)��");
			codegen = in.next();
			
			//�ж��û��������Ƿ���ȷ
			if(codegen.equalsIgnoreCase(codeGenAuto)){  //�����ִ�Сд
				System.out.println("��֤����ȷ\n");
				break;
			}else{
				if(count < times-1){
					System.out.println("��֤���������������\n");
				}
				count++;
				
				if(count == times){
					System.out.println("\n��֤��������󳬳�" + times + "�Σ�������ע��  \n�������!");
					System.exit(0);
				}
			}
		}while(count<times);
	} 
	
	//ע��������
	public List register(Scanner in, BaseMethod m, Administrator[] adminAccount, Student[] stuAccount, Student[] stuInfo) {
		List list=new ArrayList();
		do{	
			System.out.println("[1]����Աע��   [2]ѧ��ע��   [3]����\n");
			System.out.print("������������Ҫ�Ĳ�����");
			
			try{
				num = in.nextInt();  //���û�������Ҫѡ�����Ŀ
			}catch(InputMismatchException e){
				System.out.println("�Ƿ����룬�������!");
				System.exit(0);
			}
			
			switch(num){
				case 1:
					adminAccount = m.adminReg(in, adminAccount);
					list.add(adminAccount);
					isTrue = true;  //����ѭ��
					break;
				case 2:
					stuAccount = m.stuReg(in, stuAccount);  //ѧ��ע��
					list.add(stuAccount);
					isTrue = true;  //����ѭ��
					break;
				case 3:
					System.out.println("�����˳�ע��������~\n");
					isTrue = false;  //����ѭ��
					break;
				default:
					System.out.println("����������");
					isTrue = true;  //����ѭ��
					break;
			}
		}while(isTrue);
		return list;
	}
	
	//��¼������
	public void login(Scanner in, BaseMethod m, Student[] stuAccount, Student[] stuInfo, Administrator[] adminAccount){
		do{
			System.out.println("[1]����Ա��¼   [2]ѧ����¼   [3]����\n");
			System.out.print("������������Ҫ�Ĳ�����");
			
			try{
				num = in.nextInt();  //���û�������Ҫѡ�����Ŀ
			}catch(InputMismatchException e){
				System.out.println("�Ƿ����룬�������!");
				System.exit(0);
			}
			
			switch(num){
				case 1:
					System.out.println("����Ա��");
					for (int i = 0; i < adminAccount.length; i++) {
						System.out.println(adminAccount[i].getUser()+" "+adminAccount[i].getPwd());
					}
					m.adminLogin(in, adminAccount, m, stuInfo);  //����Ա��¼
					isTrue = true;  //����ѭ��
					break;
				case 2:
					System.out.println("ѧ����");
					for (int i = 0; i < stuAccount.length; i++) {
						System.out.println(stuAccount[i].getUser()+" "+stuAccount[i].getPwd());
					}
					m.stuLogin(in, stuAccount, m, stuInfo);  //ѧ����¼
					isTrue = true;  //����ѭ��
					break;
				case 3:
					System.out.println("�����˳���¼������~\n");
					isTrue = false;  //����ѭ��
					break;
				default:
					System.out.println("������������");
					isTrue = true;  //����ѭ��
					break;
			}
		}while(isTrue);
	}	

	//����Ա������
	public Student[] StuOperation(Scanner in, BaseMethod m, Student[] stuInfo){
		do{
			System.out.println("--����Ա������--");
			System.out.println("[1]�鿴ѧ����Ϣ");
			System.out.println("[2]���ѧ����Ϣ");
			System.out.println("[3]�޸�ѧ����Ϣ(����͵�ַ)");
			System.out.println("[4]ɾ��ѧ����Ϣ");
			System.out.println("[5]����\n");
			
			System.out.print("������������Ҫ�Ĳ�����");
			
			try{
				num = in.nextInt();  //���û�������Ҫѡ�����Ŀ
			}catch(InputMismatchException e){
				System.out.println("�Ƿ����룬�������!");
				System.exit(0);
			}

			switch(num){
				case 1:
					m.select(in, stuInfo);  //��ѯѧ����Ϣ
					isTrue = true;  //����ѭ��
					break;
				case 2:
					stuInfo = m.add(in, stuInfo);  //���
					isTrue = true;  //����ѭ��
					break;
				case 3:
					stuInfo = m.update(in, stuInfo);  //�޸�
					isTrue = true;  //����ѭ��
					break;
				case 4:
					stuInfo = m.delete( in, stuInfo);  //ɾ��
					isTrue = true;  //����ѭ��
					break;
				case 5:
					System.out.println("�����˳�����Ա������~\n");
					isTrue = false;  //����ѭ��
					break;
				default:
					System.out.println("����������");
					isTrue = true;  //����ѭ��
					break;
			}
		}while(isTrue);
		
		return stuInfo;
	}
	
	//����Աע��
	public Administrator[] adminReg(Scanner in, Administrator[] adminAccount){
		System.out.println("--�����ڽ��й���Աע��--");
		
		count = 1;  //�±�
		
		//����
		System.out.print("���������Ա�˺ţ�");
		user = in.next();
		System.out.print("���������룺");
		pwd = in.next();
		codeGen(in);  //��֤��
		
		adminAccount = Arrays.copyOf(adminAccount, adminAccount.length+1);
		adminAccount[adminAccount.length-1] = new Administrator(user, pwd);
		System.out.println("ע��ɹ���");
		
		for(Administrator i:adminAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return adminAccount;
	}
	
	//ѧ��ע��
	public Student[] stuReg(Scanner in, Student[] stuAccount){
		System.out.println("--�����ڽ���ѧ��ע��--");
		
		count = 1;  //�±�
		
		//����
		System.out.print("������ѧ���˺ţ�");
		user = in.next();
		System.out.print("���������룺");
		pwd = in.next();
		codeGen(in);  //��֤��
		
		stuAccount = Arrays.copyOf(stuAccount, stuAccount.length+1);
		stuAccount[stuAccount.length-1] = new Student(user, pwd);
		System.out.println("ע��ɹ���");
		
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
		
		return stuAccount;
	}
	
	//����Ա��¼
	public void adminLogin(Scanner in, Administrator[] adminAccount, BaseMethod m, Student[] stuInfo) {
		System.out.println("--�����ڽ��й���Ա��¼--");
		
		for(Administrator i:adminAccount){
			System.out.println("Ĭ�Ϲ���Ա���˺ţ�" + i.getUser() + "--" + i.getPwd() + "\n");
			
			do{
				System.out.print("���������Ա�˺ţ�");
				user = in.next();
				System.out.print("���������룺");
				pwd = in.next();
				
				if(i.getUser().equals(user) && i.getPwd().equals(pwd)){
					codeGen(in);  //��֤��
					System.out.println("��¼�ɹ���\n");
					m.StuOperation(in, m, stuInfo);
					isTrue = false;
				}else{
					System.out.println("---�û����������������������---");
					isTrue = true;
				}
			}while(isTrue);
		}
	}
	
	//ѧ����¼
	public void stuLogin(Scanner in, Student[] stuAccount, BaseMethod m, Student[] stuInfo){
		int num=0;
		System.out.println("--�����ڽ���ѧ����¼--");
		for (int j = 0; j < stuAccount.length; j++) {
			System.out.println(stuAccount[j].getUser()+" "+stuAccount[j].getPwd());
		}
		do{
				System.out.print("������ѧ���˺ţ�");
				user = in.next();
				System.out.print("���������룺");
				pwd = in.next();
				for (int i = 0; i < stuAccount.length; i++) {
					if(stuAccount[i].getUser().equals(user) && stuAccount[i].getPwd().equals(pwd)) {
						num=1;
					}
				}
				switch (num) {
				case 1:
					codeGen(in);  //��֤��
					System.out.println("��¼�ɹ���\n");
					m.select(in, stuInfo);
					isTrue = false;
					break;

				case 0:
					System.out.println("--�û����������������������--");
					isTrue = true;
					break;
				}
				
			}while(isTrue);
		
	}
		
	//��ѯѧ����Ϣ��ѧ�������棩
	public void select(Scanner in, Student[] stuInfo) {
		do {
			System.out.println("--�����ڽ���ѧ����Ϣ��ѯ--");
			System.out.println("[1]�鿴����ѧ����Ϣ(�����ܷ�����)  [2]�鿴����ѧ����Ϣ     [3]����\n");
			System.out.print("������������Ҫ�Ĳ�����");
			num = in.nextInt();  //���û�������Ҫѡ�����Ŀ
			
			switch (num) {
				case 1:
					//�鿴����ѧ����Ϣ�������ܷ����У�
					for (i = 0; i<stuInfo.length-1; i++) {  //��ð�ݶ�ѧ����Ϣ�����ִܷӴ�С����
						for (j = 0; j<stuInfo.length-1-i; j++) {
							if (stuInfo[j].getSum()<stuInfo[j+1].getSum()) {
								Student student = stuInfo[j+1];
								stuInfo[j+1] = stuInfo[j];
								stuInfo[j] = student;
							}
						}
					}
					
					//���
					System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
					for(Student i:stuInfo){
						System.out.println(i);
					}
					
					System.out.println("\n");  //��ʽ����
					isTrue = true;  //����ѭ��
					break;
				case 2:
					//�鿴����ѧ����Ϣ
					System.out.print("������Ҫ��ѯ��ѧ�����֣�");
					name = in.next();  //���û���������
					
					//����stuInfo����������в�ѯ��������������ֵ
					for (i=0; i<stuInfo.length; i++) {
						if (stuInfo[i].getName().equals(name)) {  //���û���������ֺ�ѧ�������е�����ƥ�䣬�����ѧ�����������е�ǰ���ֵ�����
							index = i;
							isExist = true;  //��isExist����ֵ��˵���Ѿ���ѯ�������������� 
						}
					}
					//isExist==true����ʾ����Ҫ��ѯ��ѧ������
					if (isExist) {
						System.out.println("����Ҫ��ѯ��ѧ����Ϣ���£�");
						System.out.println("����\t�Ա�\t����\t ��ѧ\t����\tӢ��\t�ܷ�\t��ַ\n");	
						System.out.println(stuInfo[index].toString());
					}else {
						System.out.println("��Ǹ����ѯ��ѧ��������Ϣ������");
					}
					
					isTrue = true;  //����ѭ��
					break;
				case 3:
					System.out.println("�����˳���ѯ����\n");
					isTrue = false;  //����ѭ��
					break;
				default:
					System.out.println("����������");
					isTrue = true;  //����ѭ��
					break;
				}
		} while (isTrue);
	}
	
	//���
	public Student[] add(Scanner in, Student[] stuInfo){
		System.out.println("--�����ڽ���ѧ����Ϣ���--");
		System.out.print("������ѧ��������");  //�������
		name = in.next();
		
		//�������
		System.out.print("���������䣺");
		isNum = in.hasNextInt();  //�ж��Ƿ�Ϊ����
		while (!isNum) {
			String str =  in.next();
			System.out.println("���������:" + str + ",�����������������(����)��");
			isNum = in.hasNextInt();
		}
		age = in.nextInt();
		while(age<0){
			System.out.print("������Ӧ�ô���0�����������룺");
			age = in.nextInt();
		}
		
		System.out.print("�������Ա�");  //����Ա�
		sex = in.next().charAt(0);
		
		System.out.println("�������ַ��");  //��ӵ�ַ
		address = in.next();
		
		System.out.print("��������ѧ�ɼ���");  //�����ѧ�ɼ�
		try{
			math = in.nextDouble();
			while(math<0||math>100){
				System.out.println("�����������������(0~100)��");
				math = in.nextDouble();
			}
		}catch(InputMismatchException e){
			System.out.println("�Ƿ����룬���������");
			System.exit(0);
		}catch(Exception e){
			System.out.println("�Ƿ����룬���������");
			System.exit(0);
		}
		
		System.out.print("���������ĳɼ���");  //������ĳɼ�
		try{
			chinese = in.nextDouble();
			while(math<0||math>100){
				System.out.println("�����������������(0~100)��");
				chinese = in.nextDouble();
			}
		}catch(InputMismatchException e){
			System.out.println("�Ƿ����룬���������");
			System.exit(0);
		}catch(Exception e){
			System.out.println("�Ƿ����룬���������");
			System.exit(0);
		}
		
		System.out.print("������Ӣ��ɼ���");  //���Ӣ��ɼ�
		try{
			english = in.nextDouble();
			while(math<0||math>100){
				System.out.println("�����������������(0~100)��");
				english = in.nextDouble();
			}
		}catch(InputMismatchException e){
			System.out.println("�Ƿ����룬���������");
			System.exit(0);
		}catch(Exception e){
			System.out.println("�Ƿ����룬���������");
			System.exit(0);
		}
		
		sum = math + chinese + english;  //�ܷ�
		
		stuInfo = Arrays.copyOf(stuInfo, stuInfo.length+1);
		stuInfo[stuInfo.length-1] = new Student(name, age, sex, address, math, chinese, english, sum);
		System.out.println("��ӳɹ���");
		
		for(Student i:stuInfo){
			System.out.println(i);  //��ͬ��i.toSting
		}
		
		System.out.println(""); //��ʽ����
		
		return stuInfo;
	}
	
	//�޸�(���ֺ͵�ַ)
	public Student[] update (Scanner in, Student[] stuInfo){
		System.out.println("--�����ڽ���ѧ����Ϣ�޸�--");
		
		//�޶��������
		do{
			System.out.print("��������Ҫ�޸ĵ�ѧ�����֣�");
			name=in.next();  //���û���������

			for (i = 0; i < stuInfo.length; i++) {
				if (stuInfo[i].getName().equals(name)) {
					index = i;
					isExist = true;
				}
			}
			if (isExist) {
				System.out.print("��������Ҫ�޸ĵ�ѧ�����䣺");
				age = in.nextInt();
				
				System.out.println("��������Ҫ�޸ĵ�ѧ����ַ��");
				address = in.next();
				
				stuInfo[index].setAge(age);
				stuInfo[index].setAddress(address);
				
				System.out.println("�޸ĳɹ���");
				break;
			}else {
				if(count < times-1){
					System.out.println("��Ҫ�޸ĵ�ѧ�������ڣ�����������");
				}
				count++;
				
				if(count == times){
					System.out.println("\n������󳬳�" + times + "�Σ� \n�������!");
					System.exit(0);
				}
			}
		}while(count<times);
		
		for(Student i:stuInfo){
			System.out.println(i);
		}
		
		System.out.println("");  //��ʽ����
		
		return stuInfo;
	}
	
	//ɾ��
	public Student[] delete(Scanner in, Student[] stuInfo) {
		System.out.println("--�����ڽ���ѧ����Ϣɾ��--");
		
		int arrLength = stuInfo.length;  //��������ĳ���
		
		//�޶��������
		do{
			System.out.print("��������Ҫɾ����ѧ��������");
			name = in.next();  //���û�����
			
			//�ҵ����ֶ�Ӧ���±�
			for (i = 0; i<stuInfo.length; i++) {
				if (stuInfo[i].getName().equals(name)) {
					index = i;
					isExist = true;
				}
			}
			//������ڣ�����ɾ��
			if (isExist) {	
				for (i = index; i<stuInfo.length-1; i++) {
					stuInfo[i] = stuInfo[i+1];
				}
				
				arrLength--;
				Student[] newCapacity = new Student[arrLength];
				
				for (i = 0; i < newCapacity.length; i++) {
					newCapacity[i] = stuInfo[i];
				}
				
				stuInfo=newCapacity;  //ɾ����Ķ������鸳ֵ��ԭ���Ķ�������
				
				System.out.println("ɾ���ɹ���");
				break;
			}else{
				if(count < times-1){
					System.out.println("��Ҫɾ����ѧ�������ڣ�����������");
				}
				count++;
				
				if(count == times){
					System.out.println("\n������󳬳�" + times + "�Σ� \n�������!");
					System.exit(0);
				}
			}
		}while(count<times);
		
		
		for(Student i:stuInfo){
			System.out.println(i);
		}
		
		return stuInfo;
	}	

	//������
	public static void main(String[] args) {
		/*Student[] stuInfo = Student.getStudent();  //ʵ����ѧ����Ϣ��������
		Student[] stuAccount = Student.stuAccount();  //ʵ����ѧ���˺Ŷ�������
		Administrator[] adminAccount = Administrator.adminAccount();  //ʵ��������Ա�˺Ŷ�������
		
		BaseMethod m = new BaseMethod();  //ʵ����������
		Scanner in=new Scanner(System.in);  //����*/
		
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
		
		//��ѧ����Ϣ���в���
		//m.StuOperation(in, m, stuInfo);
		
		//��ѯ
		//m.select(in, stuInfo);
		
		//����
		//m.add(in, stuInfo);
		
		//�޸�
		//m.update(in, stuInfo);
		
		//ɾ��
		//m.delete(in, stuInfo);
	}
}
