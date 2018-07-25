/*
 *  ��ȭ��Ϸ 
 *  ��дһ����ȭ��Ϸ����������Ϸ��Ҫ�����û����ǳƣ�
 *  ѡ����֣����������ȭ����Ȼ�������Ϸ��
 *  ��Ϸ���Զ�ֵ���ʽ����Ϸ��ʤ��������1��ƽ�ֺ����˲��ӷֲ����֣�
 *  ��Ϸ������֪��Ϸ�еĳɼ�������Ϸ�����棬
 *  �û�����ͨ�����а�鿴ǰ10�ķ�������Ҫ���򣩣�
 *  ͨ���˳����Խ�����Ϸ��
 *  
 */

package MorraGame;

import java.util.Scanner;

public class MorraGame {
	public static void main(String[] args) {
		// �������
		boolean isTurn = false;  //�ж��Ƿ���������
		String user = "";  //�û�
		String computer = "";  //�����
		String answer = "";  //�������������y/n
		int[] score = {2,6,4,9,0};
		int index=4;
		int win = 0;  //�������ʤ���ĳ���
		int num = 0;  //�û�ѡ�����Ϸ��
		int computerNum = 0;  //ѡ�����
		int punchesUser = 0;  //�û��ĳ�ȭ����
		int punchesComputer = 0;  //������ĳ�ȭ����
		Scanner in = new Scanner(System.in);  //��ȡ����
		
		do{
			// ������
			System.out.println("**********��ȭ��Ϸ**********");
			System.out.println("1.����Ϸ");
			System.out.println("2.Ӣ�����а�");
			System.out.println("0.����");
			System.out.println("***************************");
			System.out.println("====>������ѡ��(0-2)");
			
			//�ж��û�ѡ����������Ƿ���ȷ
			num = in.nextInt();  //��ȡ�û�ѡ�����Ϸ��
			while(num<0 || num>2){
				System.out.print("�������벻��ȷ�����������룺");
				num = in.nextInt();
			}
			
			//ѡ����Ϸ����
			switch(num){
				//����Ϸ 
				case 1:
					System.out.println("����Ϸ ");
					System.out.print("�����������ǳƣ�");
					user = in.next();  //��ȡ�û����ǳ�
					System.out.println("�����ǳ��ǣ�" + user + "\n");
					
					//��ʼ��Ϸ
					System.out.print("��ѡ�����Ķ��֣�1.��Ȩ    2.�ܲ�   3.��������");
					computerNum = in.nextInt();  //��ȡ����Ҫѡ��ļ������ɫ
					while(computerNum<=0 || computerNum>=4){
						System.out.print("�������벻��ȷ�����������룺");
						computerNum = in.nextInt();
					}
					
					//�жϽ�ɫ���������ɫ����
					switch(computerNum){
			            case 1:
			            	computer="��Ȩ";
			                break;
			            case 2:
			            	computer="�ܲ�";
			                break;
			            case 3:
			            	computer="����";
			                break;
			            default:
			            	break;
		            }
					System.out.println("��ѡ��Ľ�ɫ�ǣ�" + computer + "\n");
					
					//��ȭ
					System.out.println(user + "  VS  " + computer);
					System.out.println("���ȭ��1.����    2.ʯͷ   3.��  0:�˳���");
					
					//�����û���ȭ
					punchesUser = in.nextInt();
					while(punchesUser<1 || punchesUser>3){
						if(punchesUser == 0){
							System.out.println("���������");
							break;
						}
						System.out.print("�������벻��ȷ�����������룺");
						punchesUser = in.nextInt();
					}
					
					//�ж�
					while(punchesUser!=0 && punchesUser<4){
						punchesComputer = (int)(Math.random()*3+1); //����������ȭ
						//�û���ȭ
						switch (punchesUser){
				        	case 1:
				        		System.out.println("�����:������");
				        		break;
				        	case 2:
				        		System.out.println("�����:ʯͷ��");
				        		break;
				        	case 3:
				        		System.out.println("�����:����");
				        		break;
						}
						
						//�������ȭ
						switch (punchesComputer){
							case 1:
						        System.out.println("���Գ���:������");
						        break;
							case 2:
						        System.out.println("���Գ���:ʯͷ��");
						        break;
							case 3:
						        System.out.println("���Գ���:����");
						        break;
						}
						
						//�ж�
						/**
						 * ԭ��
						 *     {�����[C](punchesComputer)}  {�û�[U](punchesUser)}      {ʤ  ��}     {�����-�û�[C-U]}     {�û�-�����[U-C]}
						 *      1 ==> (����)                  1 ==> (����)                 ƽ                  0                     0
						 *      1 ==> (����)                  2 ==> (ʯͷ)               �û�Ӯ              -1                     1
						 *      1 ==> (����)                  3 ==> (��)                �����Ӯ            -2                     2
						 *      2 ==> (ʯͷ)                  1 ==> ��������                          �����Ӯ              1                    -1
						 *      2 ==> (ʯͷ)                  2 ==> (ʯͷ)                 ƽ                   0                     0
						 *      2 ==> (ʯͷ)                  3 ==> (��)                 �û�Ӯ              -1                     1
						 *      3 ==> (��)                    1 ==> (����)               �û�Ӯ                2                    -2
						 *      3 ==> (��)                    2 ==> (ʯͷ)              �����Ӯ               1                    -1
						 *      3 ==> (��)                    3 ==> (��)                   ƽ                   0                     0
						 *      
						 *      �ó����ۣ��������Ӯʱ��C-U=-2(U-C=2) �� C-U=1 �� punchesComputer-punchesUser==1 || punchesUser-punchesComputer==2
						 *      		 ���û�Ӯʱ��   C-U=-1(U-C=1) �� C-U=2 �� punchesComputer-punchesUser==2 || punchesUser-punchesComputer==1
						 *      		 ��ƽ��ʱ��       C-U=0
						 */
						if(punchesUser == punchesComputer){
						     System.out.println("ƽ��");
						}else if(punchesComputer-punchesUser==1 || punchesUser-punchesComputer==2){
							System.out.println("����Ӯ�ˣ�");
						}else if(punchesComputer-punchesUser==2 || punchesUser-punchesComputer==1){
						     System.out.println("��Ӯ�ˣ�");
						     win++;
						}
						
						//���³�ȭ
						System.out.println("���ȭ��1.����    2.ʯͷ   3.��  0:�˳���");
						punchesUser = in.nextInt();
					}
					
					//ͳ��Ӯ�Ĵ���
					System.out.println("Ӯ��:" + win + "�Σ�");
					
					break;
				//Ӣ�����а�
				case 2:
					System.out.println("Ӣ�����а� ");
					score[index]=win;
					//N�����Ƚϵ�����ΪN-1
					for(int i=0; i<score.length-1; i++){
						//ÿһ�ֱȽϵĴ���ΪN-1-i��
						for(int j=0; j<score.length-1-i; j++){
							//�Ƚ����ڵ�������
							if(score[j]<score[j+1]){
								//������������ͨ����ʱ����
								int temp = score[j];
								score[j] = score[j+1];
								score[j+1] = temp;
							}
						}
					}
					//���ź�����������
					for(int j=0; j<score.length; j++){
						System.out.println("�÷֣�\t" + score[j]);
					}
					
					break;
				//�������
				default:
					//�������
					System.out.println("�������");
					break;
			}  //switch����
			
			//switch����֮��ֱ�ӵ�����ѭ��
			System.out.println("�Ƿ񷵻�������?(y/n)");
			answer = in.next();

			if (answer.equals("y")){  //��==���Ƚ��������������ֵ���������������ڴ��е��׵�ַ����equals()���Ƚ��ַ������������������Ƿ���ͬ��
				isTurn=true;
			}else {
				isTurn=false;
			}
		}while(isTurn);
		
		//�رռ���
		in.close();
		
		//�������
		System.out.println("��Ϸ�����ˣ���ؼҰ�");
	}
}
