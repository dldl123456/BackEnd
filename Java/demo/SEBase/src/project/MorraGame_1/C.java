package project.MorraGame_1;
import java.util.Scanner;
 public class C {
	 /**
	  * �����ϵ��˻���ȭ
	  * @param args
	  */
    @SuppressWarnings("resource")
	public static void main(String[] args) {
         Scanner input=new Scanner(System.in);
         System.out.println("--------��ӭ�����ȭ��Ϸ---------\n\n");
         System.out.println("  ��ȭ����1.����  2.ʯͷ  3.��\n");
         System.out.println("******************************\n");
         System.out.println("*******  ��ȭ          ��ʼ      ********\n");
         System.out.println("******************************\n\n");
         System.out.println("��Ϸ��ʼǰ���Լ���һ������������ǳư�\n");
         System.out.println("����������ǳƣ�");
         String username=input.next();//���û������ǳ�
        String name="1";//��nameһ����ʼֵ,name��computer������
         do{
             System.out.println("��ѡ���ս��ɫ��1.����  2.�ܲ�  3.���ף���");
             boolean zhenjia=input.hasNextInt();//�ж������Ƿ�����ֵ
             while(!zhenjia){//����������֣�����
                 String zhen=input.next();
                System.out.println("��������ǣ�"+zhen+"  �������������");
                System.out.println("������ѡ���ɫ��1.����  2.�ܲ�  3.���ף���");
                 zhenjia=input.hasNextInt();//�ж������Ƿ�����ֵ��������� ������ѭ��
             }
             int num=input.nextInt();//ȡ��������
             while(num>3||num<0){//�ж������ֵ�Ƿ���1-3��������ǽ���ѭ��
                 System.out.println("�������������");
                 System.out.println("������ѡ���ɫ��1.����  2.�ܲ�  3.���ף���");
                 num=input.nextInt();//������ֵ�������1-3����ѭ����������Ǽ���ѭ��
             }
             switch(num){
             case 1:
                 name="����";
                 break;
             case 2:
                 name="�ܲ�";
                 break;
             case 3:
                 name="����";
                 break;
             }
         }while(name.equals("1"));//��name����1ʱ ������ѭ��
         System.out.println("��ѡ����  "+name+"��ս");
         String go;
         do{
             System.out.println(username+"\tVS\t"+name);
             //��ȭ����
             int i=1;//i�ǲ�ȭ������
             int userScore=0;//�û��÷�
             int compScore=0;//computer�÷�
             String come;//��come��ֵy������ѭ����������д��
             do{
                 System.out.println("���ǵ�"+i+"��");
                 System.out.println("���ȭ��1.���� 2.ʯͷ  3.��");
                 boolean zhenjia=input.hasNextInt();//�ж������Ƿ�����ֵ
                 while(!zhenjia){//����������֣�����
                     String zhen=input.next();//�������ֵ����˴���һ��������������
                     System.out.println("��������ǣ�"+zhen+"  �������������");
                     System.out.println("�����³�ȭ��1.���� 2.ʯͷ  3.��");
                     zhenjia=input.hasNextInt();//�ж������Ƿ�����ֵ��������� ������ѭ��
                 }
                int num=input.nextInt();//ȡ���������ֵ
                while(num>3||num<0){//�ж������ֵ�Ƿ���1-3��������ǽ���ѭ��
                     System.out.println("�������������");
                     System.out.println("�����³�ȭ��1.���� 2.ʯͷ  3.��");
                     num=input.nextInt();//������ֵ�������1-3����ѭ����������Ǽ���ѭ��
                }
                 String user="";//�����û��ĳ�ȭ
                switch(num){
                case 1:
                    System.out.println("���ȭ������");
                    user="����";
                     break;
                case 2:
                    System.out.println("���ȭ��ʯͷ");
                    user="ʯͷ";
                   break;
                case 3:
                     System.out.println("���ȭ����");
                    user="��";
                    break;
                 }
                 String comp="";//����computer�Ĳ�ȭ
                int numc=(((int)(Math.random()*10))%3+1);//�������1-3
                 switch(numc){
                 case 1:
                     System.out.println(name+"��ȭ������");
                     comp="����";
                    break;
                case 2:
                    System.out.println(name+"��ȭ��ʯͷ");
                     comp="ʯͷ";
                    break;
                case 3:
                     System.out.println(name+"��ȭ����");
                     comp="��";
                     break;
                 }
                 if(user.equals(comp)){//�ж�˫����ȭ�Ƿ���ͬ
                     System.out.println("˫����ȭ��"+user+"  ������ƽ��");
                }else{
                    if(user.equals("����")){//���û�������ʱ
                       if(comp.equals("ʯͷ")){//��computer��ʯͷʱ
                             System.out.println(name+"Ӯ�ˣ�");
                            compScore++;
                       }else{//��computer����ʱ
                            System.out.println("��Ӯ�ˣ�");
                             userScore++;
                         }
                     }else if(user.equals("ʯͷ")){
                         if(comp.equals("��")){
                             System.out.println(name+"Ӯ�ˣ�");
                             compScore++;
                         }else{
                            System.out.println("��Ӯ�ˣ�");
                             userScore++;
                         }
                     }else{
                         if(comp.equals("����")){
                             System.out.println(name+"Ӯ�ˣ�");
                            compScore++;
                         }else{
                            System.out.println("��Ӯ�ˣ�");
                             userScore++;
                         }
                     }
               }
                i++;//��ȭ��������1
                 System.out.println("������"+i+"��  y\n����  n");
               come=input.next();//��come��ֵy������ѭ��
            }while("y".equals(come));//�ж�come��ֵ�Ƿ���y,����� ������ѭ������������ѭ��
             System.out.println("��Ϸ������"+(i-1)+"��");
            System.out.println("����\t�÷�");
           System.out.println(username+"\t"+userScore);
             System.out.println(name+"\t"+compScore);
             if(userScore==compScore){//���÷�һ��������������޸ĺ���ӵĴ���
               System.out.println("���"+name+"���˸�ƽ��");
                 System.out.println("����ô���̣��������п��");
                System.out.println(" ����y/������n");
            }else if(userScore>compScore){

                 System.out.println("���"+name+"����仨��ˮ");
                 System.out.println("\t��tm˧����");
                 System.out.println("�ٴ�"+name+"һ�־Ͱ��������ͷ�� \n  ����y/������n");
             }else{
                System.out.println("�㱻"+name+"�����ͷ��");
                 System.out.println("����y/����n");
             }
             go=input.next();
         }while("y".equals(go));
         System.out.println("GAME OVER!");
     }//mian
 }
