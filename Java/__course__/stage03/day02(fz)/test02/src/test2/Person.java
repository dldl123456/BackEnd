/*
 *  ����������¹��ܴ���:
 *  (1) ����һ��(Person)��,�������ԣ�����,����,�Ա�д����صķ���,�ܹ������ʱ���ʼ�����ߺ����޸�����ֵ��
 *  (2) ����һ��Employee��̳���Person�࣬�����µ����ԣ�ְλ��д����صķ�����
 *  �ܹ������ʱ���ʼ�����ߺ����޸�����ֵ����дequals������
 *  ���򣺵�������������������䣬�Ա�ְλ�����ʱ����true�����򷵻�false��
 *  (3) дһ�������������ز��ԣ�Ҫ����Դ�ӡ�������Ϣ���ܹ��Ƚ϶����Ƿ�"���"����
 *  
 *  Ч����
 *  	��λְԱ��Ϣ���£�
 *  	name:Jim age:28 sex:�� position:�������ʦ
 *  	name:Tom age:28 sex:�� position:�������ʦ
 *  	�ж���λְԱ�Ƿ����"
 *  	false
 */

package test2;

public class Person {
	//����Person��˽������
	private String name;  //����
	private int age;  //����
	private char sex;  //�Ա�
	
	//��get,set������Person��˽�����Կ��Žӿ�
	//name
	public String getName() {  //��ȡname
		return name;
	}
	public void setName(String name) {  //����name
		this.name = name;
	}
	//age
	public int getAge() {  //��ȡage
		return age;
	}
	public void setAge(int age) {  //����age
		if(age>0){
			this.age = age;
		}
	}
	//sex
	public char getSex() {  //��ȡsex
		return sex;
	}
	public void setSex(char sex) {  //����sex
		this.sex = sex;
	}

	//���캯����ʼ������
	public Person(String name, int age, char sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
}
