/*
 *  �򵥹���ģʽ��Υ�����չ���
 */

package video.note.factoryDemo;

public class FactoryDemo {
	//��������������
	public static void main(String[] args) {
		//�ýӿڵ����ñ���������
		//��˼�ǣ�ֻҪʵ������ӿڵ�ˮ�����Ҷ����Խ���
		IFruit fruit = Factory.getFruit("ƻ��");
		
		//�жϸó����Ƿ��и�ˮ��
		if(fruit != null){
			System.out.println(fruit.get());  //��̬����̬��
		}else{
			System.out.println("������");
		}
	}
}

//ժˮ���ӿ�
interface IFruit{
	//������󷽷�
	public String get();
}

//һ��������
class Factory{
	//���ؽӿڵ�ʵ����
	//���ķ��������ǽӿ�(IFruit)�����ñ���������return�Ľӿڵ�ʵ���඼����
	public static IFruit getFruit(String name){
		if(name.equals("ƻ��")){
			return new Apple();
		}else if(name.equals("����")){
			return new Orange();
		}else{
			return null;
		}
	}
}

//Ҫʹ�ýӿڵ�ˮ���ࣨƻ����
class Apple implements IFruit{
	//��д�ӿ���ķ���
	public String get(){
		return "��ժƻ��";
	}
}

//Ҫʹ�ýӿڵ�ˮ���ࣨ���ӣ�
class Orange implements IFruit{
	//��д�ӿ���ķ���
	public String get(){
		return "��ժ����";
	}
}