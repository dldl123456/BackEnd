/*
 *  ʿ����ս�ƻ�(��̬��ģ�壬��д������)
 *  ʹ�ó�����
 */

package video.note.soldierDemo;

public class SoldierDemo {
	//������
	public static void main(String[] args) {
		Officer officer = new Officer("��");  //����һ������
		officer.callToAttack();  //�����е�ʿ������
		System.out.println("**************");
		officer.callToAttack(officer.getSoldiers()[0]);  //�����������һ���˽��й���
		System.out.println("**************");
		officer.callToAttack(officer);
	}
}

//ʿ�������࣬�����࣬ģ�壩
//һ�������������һ�������ǳ��󷽷�����������ǳ�����
abstract class Soldier{
	//�������
	private String name;
	//���췽����ʼ������
	public Soldier(String name){
		this.name = name;
	}
	//get������ȡ(����)������
	public String getName(){
		return name;
	}
	
	//start
	public void start(){
		System.out.println("׼������");
	}
	
	//attack----�������󷽷�
	public abstract void attack();
	
	//end
	public void end(){
		System.out.println("�������");
	}
	
	//һ���������ж���
	public void action(){
		start();  //��ʼ
		attack();  //�������ӳٵ�����ʵ�֣�������Ҫ�������󷽷���
		end();  //����
	}
}

//���ࣨ½����
//һ����ֻ�ܼ̳�һ������
class LandSolider extends Soldier{
	//���췽��
	public LandSolider(String name){
		super(name);  //���ø����һ�������Ĺ��췽��
	}
	
	//��д���౻�����ĳ��󷽷� attack
	//ʵ�ֳ������еĳ��󷽷�
	public void attack(){
		System.out.println(getName() + "ʹ�ò�ǹ���");
	}
}

//���ࣨ������
class OceanSolider extends Soldier{
	public OceanSolider(String name){
		super(name);
	}
	
	//����
	public void attack(){
		System.out.println(getName() + "ʹ���������");
	}
}

//���ࣨ���٣�
//���ٳ�������ʿ��
class Officer extends Soldier{
	private Soldier[] soldiers = new Soldier[2];  //���ٳ���2��ʿ��
	public Officer(String name){
		super(name);
		//��������ñ������������������
		soldiers[0] = new LandSolider("����");
		soldiers[1] = new OceanSolider("����");
	}
	
	//ʿ�������������棬��Ҫ����
	public Soldier[] getSoldiers(){
		return soldiers;
	}

//�������أ���������ͬ��������ͬ��������
	//�������Լ����еķ�����ָ�ӷ���
	//�������е�����ʿ��һ�𷢶������������Լ�
	public void callToAttack(){
		for(int i=0; i<soldiers.length; i++){
			soldiers[i].action();  //ÿ��ʿ��������������ж�����
		}
		//�Լ�Ҳ���빥��
		this.action();
	}
	
	//��һ��ʿ��ȥ����
	public void callToAttack(Soldier soldier){
		soldier.action();
	}
	
	//����
	public void attack(){
		System.out.println(getName() + "ʹ����ǹ���");
	}
}