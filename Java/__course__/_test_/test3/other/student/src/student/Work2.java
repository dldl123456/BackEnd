package student;

import java.util.Arrays;
import java.util.Scanner;

public class Work2 {
	public static void main(String[] args) {
		Student[]arr=Student.getStudent();//ȡ��ѧ����Ϣ�Ķ���
		Student[]arr1=Student.str();//ȡ��ѧ���˺�����
		int elements=arr.length;
		Student[]arr2=new Student[elements];
		Manager[]managers=Manager.getMarrays();//ȡ�ù���Ա����
		String user;
		int password;
		String name;//����
		int age;//����
		String sex;//�Ա�
		String address;//��ַ
		int math;//��ѧ����
		int English;//Ӣ�����
		int sum;//�ܷ�
		
		System.out.println("***********��ӭ����ѧ������ϵͳ************");
		System.out.println("1. ��¼");
		System.out.println("2. ע��");
		System.out.println("3. �˳�");
		System.out.println("*****************************************");
		System.out.println("��ѡ��");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		switch (choice) {
			case 1:
				System.out.println("****************");
				System.out.println("1 ѧ����¼");
				System.out.println("2 ����Ա��¼");
				System.out.println("0 ����");
				System.out.println("****************");
				System.out.println("��ѡ��");
				choice=in.nextInt();
				switch (choice) {
				case 1:
					
					break;
				case 2:
					System.out.println("���������Ա�˺�");
					user=in.next();
					System.out.println("���������Ա����");
					password=in.nextInt();
					int answer=0;
					for (int i = 0; i < managers.length; i++) {
						if (managers[i].getAdmin().equals(user)&&managers[i].getPwd()==password) {
							answer=1;
						}
						switch (answer) {
						case 1:
							System.out.println("************���˵�����***************");
							System.out.println("1.�鿴ѧ����Ϣ");
							System.out.println("2.���ѧԱ��Ϣ");
							System.out.println("3.�޸�ѧԱ��Ϣ( ��ܰ��ʾ���޸�����͵�ַŶ)");
							System.out.println("4.ɾ��ѧԱ��Ϣ");
							System.out.println("5.����");
							System.out.println("************************************");
							System.out.println("��ѡ��");
							int answer1=in.nextInt();
							switch (answer1) {
								case 1:
									System.out.println("*******************************");
									System.out.println("��ѡ��鿴ѧ����Ϣ���������£�");
									System.out.println("1.�鿴����ѧ����Ϣ");
									System.out.println("2.�鿴����ѧ����Ϣ");
									System.out.println("3.�鿴�ܷ����а�");
									System.out.println("4.���ݵ�����Ŀ�鿴���а�");
									int answer2=in.nextInt();
									switch (answer2) {
										case 1:
											System.out.println("����\t�Ա�\t����\t ��ѧ\tӢ��\t�ܷ�");	
											for (int j = 0; j < arr.length; j++) {
												System.out.println(arr[j].toString());
											}
											break;
										case 2:
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
											System.out.println("����\t�Ա�\t����\t ��ѧ\tӢ��\t�ܷ�");
											for (int k = 0; k< arr.length; k++) {
												System.out.println(arr[k].toString());
											}
											break;
										case 4:
											System.out.println("��������Ҫ��ѯ�Ŀ�Ŀ");
											String major=in.next();
											switch (major) {
											case "��ѧ":
												for (int k = 0; k < arr.length-1; k++) {
													for (int j = 0; j < arr.length-1-i; j++) {
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
												break;
											default:
												System.out.println("����������");
												break;
											}	
											break;
										default:
											System.out.println("����������");
											break;
										}
										break;
								case 2:
									System.out.println("������ѧ������");	
									name=in.next();
									System.out.println("����������");
									age=in.nextInt();
									System.out.println("�������Ա�");
									sex=in.next();
									System.out.println("�������ַ");
									address=in.next();
									System.out.println("��������ѧ����");
									math=in.nextInt();
									System.out.println("������Ӣ�����");
									English=in.nextInt();
									sum=math+English;//�ܷ�
									arr=Arrays.copyOf(arr, arr.length+1);
									arr[arr.length-1]=new Student(name, age, sex, address, math, English, sum);
									System.out.println("���ӳɹ�");
									break;
								case 3:
									System.out.println("��������Ҫ�޸ĵ�ѧ�����֣�");
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
										System.out.println("��������Ҫ�޸ĵ�ѧ������");
										int age1=in.nextInt();
										System.out.println("��������Ҫ�޸ĵ�ѧ����ַ");
										String address1=in.next();
										arr[index1].setAge(age1);
										arr[index1].setAddress(address1);
										System.out.println("�޸ĳɹ�");
									}else {
										System.out.println("��Ҫ�޸ĵ�ѧ��������");
									}
									break;							
								case 4:
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
										System.out.println("��Ҫɾ����ѧ�������ڣ�ɾ��ʧ��");
									}
									break;
								default:
									System.out.println("����������");
									break;
								}		
							break;

						default:
							System.out.println("��������������������");
							break;
						}
					}
					break;
				case 3:
					
					break;
				default:
					System.out.println("����������");
					break;
				}
				break;
			case 2:
				System.out.println("��ӭ��ע��ѧ������ϵͳ�˺�");
				System.out.println("1. ע�����Ա�˺�");
				System.out.println("2. ע��ѧ���˺� ");
				System.out.println("0. ����");
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
							System.out.println(managers[1]);
							managers[arr1.length-1]=new Manager(user, password);
							System.out.println("��ӹ���Ա�ɹ�");
							System.out.println(	managers[arr1.length-1].getAdmin());
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
					password=in.nextInt();
					for (int i = 0; i < arr1.length; i++) {
						if (arr1[i].getUser().equals(user)&&arr1[i].getPwd()==password) {
							isExit=0;
							break;
						}
					}
					switch (isExit) {
						case 1:
							arr1=Arrays.copyOf(arr1, arr1.length+1);//����
							System.out.println(arr1[1]);
							arr1[arr1.length-1]=new Student(user, password);
							System.out.println("���ѧ���ɹ�");
							System.out.println(arr1.length);
							break;
						default:
							System.out.println("�˺��Ѵ���");
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
				System.out.println("�����������");
				return;
			default:
				System.out.println("����������");
				break;
			}
	}
}
