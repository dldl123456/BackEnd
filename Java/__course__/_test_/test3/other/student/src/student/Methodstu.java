package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/*
 * ������ʵ����ɾ�Ĳ�ӿ�
 */
public class Methodstu implements Student_add,Student_delete,Student_update,Student_select{
	String user = null;//�û���
	int password = 0;//����
	String name = null;//����
	int age = 0;//����
	String sex = null;//�Ա�
	String address = null;//��ַ
	int math = 0;//��ѧ����
	int English = 0;//Ӣ�����
	int sum = 0;//�ܷ�
	int choice=0;
	/*
	 * һ��������
	 */
	public void Login() {
		System.out.println("***********��ӭ����ѧ������ϵͳ************");
		System.out.println("1. ��¼");
		System.out.println("2. ע��");
		System.out.println("3. �˳�");
		System.out.println("*****************************************");
		System.out.println("��ѡ��");
	}
	/*
	 * ������¼ģ��
	 */
	public boolean enter(Scanner in,Student[]arr1,Student[]arr,Manager[]managers,boolean isAgin,int elements,Methodstu m) {
		boolean isEnter=false;
		System.out.println("****************");
		System.out.println("1.ѧ����¼");
		System.out.println("2.����Ա��¼");
		System.out.println("0.����");
		System.out.println("****************");
		System.out.println("��ѡ��");
		boolean isTrue=in.hasNextInt();
		while (!isTrue) {//�������ֽ���
			String str =  in.next();
			System.out.println("���������:"+str+"  ֻ����������Ŷ��");
			System.out.println("���������룺"+"1.ѧ����¼  2.����Ա��¼ 0.����");
			isTrue=in.hasNextInt();
		}
		choice=in.nextInt();//ȡ������
		while (choice>2||choice<0) {
			System.out.println("������ĸ�ʽ,���������Ŀ�ζŶ,������Ҫ��0~2֮��");
			System.out.println("���������룺"+"1.ѧ����¼  2.����Ա��¼ 0.����");
			choice=in.nextInt();
		}
		switch (choice) {
		case 1:
			int answer2 = 0;
			try {
				answer2 = m.studentEnter(user, in, password, arr1, m);//ѧ���˺���֤
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			m.studentFunction(answer2, in, arr, isAgin,m);//ѧ����½�ɹ��Ĺ���
			isEnter=true;
			break;
		case 2:
			int answer=m.managerEnter(in, managers);//�����¼��֤
			switch (answer) {
				case 1:
					m.managerFunction(in, arr, m);//������ģ��
					break;
				default:
					System.out.println("��������������������");//�����������
					break;
				}
			break;
		case 0:
			System.out.println("��ѡ���˳���¼");
			isEnter=false;
			break;
		default:
			System.out.println("����������");
			break;
		}
		return isEnter;
	}
	
	/*
	 * ����
	 * 1.��֤�빦��
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
	        System.out.println("��������ͼ��֤�룬ע���Сд��");
	        Scanner c=new Scanner(System.in);
	        String d=c.next();
	        char[] e={a.charAt(array[0]),a.charAt(array[1]),a.charAt(array[2]),a.charAt(array[3])};
	        String f=new String(e);//ǿ��ת����ͬ���ͣ�����Ƚ�
	        boolean g=d.equals(f);
	        if(g==true)
	        {
	           System.out.println("��֤��������ȷ");
	           answer=1;
	         }else {
				System.out.println("�������");
				answer=0;
			} 
	        return answer;
	}
	
	/*
	 * ����
	 * 2.ѧ����¼��֤
	 */
		public int studentEnter(String user,Scanner in,int password,Student []arr1,Methodstu m) throws Exception{
			int answer1=0;
			System.out.println("������ѧ���˺�");
			user=in.next();
			System.out.println("����������");
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
			int answer3=m.IdentityCode();//��֤��
			if (answer2==1&&answer3==1) {
				answer1=1;
			}
			return answer1;
		}
	  
	
	/*����
	 * 3.ѧ���˺Ź���ģ��
	 */
		public void studentFunction(int answer2,Scanner in,Student[]arr,boolean isAgin,Methodstu m) {
			switch (answer2) {
			  case 1:
				m.select(in, arr, isAgin);
				break;
			default:
				System.out.println("��������Ϣ����");
				break;
			}
		}
		/*
		 * ���������˺ŵ�¼ģ��
		 */
		public int managerEnter(Scanner in,Manager[]managers) {
			System.out.println("���������Ա�˺�");
			user=in.next();
			System.out.println("���������Ա����");
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
		 * ������ģ��
		 */
		public Student[] managerFunction(Scanner in,Student[]arr,Methodstu m) {
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
				choice=in.nextInt();//ȡ������
				while (choice>4||choice<0) {
					System.out.println("������ĸ�ʽ,���������Ŀ�ζŶ,������Ҫ��1~5֮��");
					System.out.println("���������룺");
					choice=in.nextInt();
				}
				int answer1=choice;
				switch (answer1) {
					case 1:
					boolean isAgin = false;
					m.select(in, arr, isAgin);//ѧ����ѯģ��
						isEnteragain=true;
							break;
					case 2:
						arr=m.add( in, isTrue,  arr);//����
						isEnteragain=true;
						break;
					case 3:
						arr=m.update( in, arr);//��ѯģ��
						isEnteragain=true;
						break;							
					case 4:
						arr=m.delete( in, arr);//ɾ��ģ��
						isEnteragain=true;
						break;
					case 0:
						System.out.println("�����˳�����Ա����Ŷ");
						isEnteragain=false;
						break;
					}		
			} while (isEnteragain);
			return arr;	
		}
	/*
	 * ����
	 * 3.��ѯ����ģ��(ѧ��/����Ա����)
	 */
	public void select(Scanner in,Student[]arr,boolean isAgin) {
		do {
			System.out.println("*******************************");
			System.out.println("��ѡ��鿴ѧ����Ϣ���������£�");
			System.out.println("1.�鿴����ѧ����Ϣ");
			System.out.println("2.�鿴����ѧ����Ϣ");
			System.out.println("3.�鿴�ܷ����а�");
			System.out.println("4.���ݵ�����Ŀ�鿴���а�");
			System.out.println("0.����");
			int answer3=in.nextInt();
			switch (answer3) {
				case 1:
					//�鿴����ѧ����Ϣ
					System.out.println("����\t�Ա�\t����\t ��ѧ\tӢ��\t�ܷ�");	
					for (int j = 0; j < arr.length; j++) {
						System.out.println(arr[j].toString());
					}
					isAgin=true;
					break;
				case 2:
					//�鿴����ѧ����Ϣ
					System.out.println("������Ҫ��ѯ��ѧ������");
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
							System.out.println("����Ҫ��ѯ��ѧ����Ϣ���£�");
							System.out.println("����\t�Ա�\t����\t ��ѧ\tӢ��\t�ܷ�");
							System.out.println(arr[index].toString());
						}else {
							System.out.println("��Ǹ����ѯ��ѧ��������Ϣ������");
						}
						isAgin=true;
					break;
				case 3:
					//�鿴�ܷ����а�
					for (int i1 = 0; i1 < arr.length-1; i1++) {
						for (int j = 0; j < arr.length-1-i1; j++) {
							if (arr[j].getSum()<arr[j+1].getSum()) {
								Student student=arr[j+1];
								arr[j+1]=arr[j];
								arr[j]=student;
							}
						}
					}
					System.out.println("����\t�Ա�\t����\t ��ѧ\tӢ��\t�ܷ�\t��ַ");
					for (int k = 0; k< arr.length; k++) {
						System.out.println(arr[k].toString());
					}
					isAgin=true;
					break;
				case 4:
					//���ݵ�����Ŀ�鿴���а�
					System.out.println("��������Ҫ��ѯ�Ŀ�Ŀ(��ѧ/Ӣ��)");
					String major=in.next();
					switch (major) {
						case "��ѧ":
							for (int k = 0; k < arr.length-1; k++) {
								for (int j = 0; j < arr.length-1-k; j++) {
									if (arr[j].getMath()<arr[j+1].getMath()) {
										Student student=arr[j+1];
										arr[j+1]=arr[j];
										arr[j]=student;
									}
								}
							}
							System.out.println("����\t�Ա�\t����\t ��ѧ\tӢ��\t�ܷ�");
							for (int q = 0; q < arr.length; q++) {
								System.out.println(arr[q].toString());
							}
							isAgin=true;
							break;
						case "Ӣ��":
							for (int i1 = 0; i1 < arr.length-1; i1++) {
								for (int j = 0; j < arr.length-1-i1; j++) {
									if (arr[j].getEnglish()<arr[j+1].getEnglish()) {
										Student student=arr[j+1];
										arr[j+1]=arr[j];
										arr[j]=student;
									}
								}
							}
							System.out.println("����\t�Ա�\t����\t ��ѧ\tӢ��\t�ܷ�");
							for (int j = 0; j < arr.length; j++) {
								System.out.println(arr[j].toString());
							}
							isAgin=true;
							break;
						default:
							System.out.println("����������");
							isAgin=true;
							break;
						}	
					break;
				case 0:
					System.out.println("�����˳���ѯģ��");
					isAgin=false;
					break;
				default:
					System.out.println("����������");
					break;
				}
			
		} while (isAgin);
	}
	
	/*
	 * ����Ա���ģ��
	 */
	public Student[] add(Scanner in,boolean isTrue,Student[]arr){
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
		sex=in.next();
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
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=new Student(name, age, sex, address, math, English, sum);
		System.out.println("���ӳɹ�");
		return arr;
	}
	/*
	 * ����
	 * ����Աɾ��ģ��
	 */
	public Student[] delete(Scanner in,Student[]arr) {
		int elements=arr.length;
		System.out.println("������ɾ��ѧ������Ϣ");
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
		arr=arrNew;//ɾ����Ķ������鸳ֵ��ԭ���Ķ�������
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}
		return arr;
		}else {
			System.out.println("��Ҫɾ����ѧ�������ڣ�ɾ��ʧ��");
		}
		return arr;
	}
	
	/*
	 * ����
	 * ����Ա�޸�ģ��
	 */
	public Student[] update (Scanner in,Student[]arr){
		System.out.println("��������Ҫ�޸ĵ�ѧ�����֣�");
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
			System.out.println("��������Ҫ�޸ĵ�ѧ������");
			int age1=in.nextInt();
			System.out.println("��������Ҫ�޸ĵ�ѧ����ַ");
			String address1=in.next();
			arr[index1].setAge(age1);
			arr[index1].setAddress(address1);
			System.out.println("�޸ĳɹ�");
			return arr;
		}else {
			System.out.println("��Ҫ�޸ĵ�ѧ��������");
		}
		return arr;
	}
	
	/*
	 * ����ע��ģ��
	 */
	public List register(Scanner in,Manager[]managers,Student[]arr1) {
		List list=new ArrayList();
		System.out.println("��ӭ��ע��ѧ������ϵͳ�˺�");
		System.out.println("1. ע�����Ա�˺�");
		System.out.println("2. ע��ѧ���˺� ");
		System.out.println("0. ����");
		System.out.println("��ѡ��");
		int register=in.nextInt();
		int isExit=1;
		switch (register) {
		case 1:
			System.out.println("���������Ա�˺�");
			user=in.next();
			System.out.println("����������");
			password=in.nextInt();
			//��֤�Ƿ����
			for (int i = 0; i < managers.length; i++) {
				if (managers[i].getAdmin().equals(user)&&managers[i].getPwd()==password) {
					isExit=0;
					break;
				}
			}
			switch (isExit) {
				case 1:
					managers=Arrays.copyOf(managers, managers.length+1);//����
					managers[arr1.length-1]=new Manager(user, password);
					System.out.println("��ӹ���Ա�ɹ�");
					list.add(managers);
					break;
				default:
					System.out.println("�˺��Ѵ���");
					break;
				}
			break;
		case 2:
			System.out.println("������ѧ���˺�");
			user=in.next();
			System.out.println("����������");
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
					arr1=Arrays.copyOf(arr1, arr1.length+1);//����
					arr1[arr1.length-1]=new Student(user, password);
					System.out.println("���ѧ���ɹ�");
					list.add(arr1);
					break;
				default:
					System.out.println("�˺��Ѵ���");
					break;
				}
			break;
		case 0:
			System.out.println("��ѡ���˳�ע��");
			break;
		default:
			System.out.println("���������󣬱�����0~2");
			break;
		}
		return list;
	}
	
}
