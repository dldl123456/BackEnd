package test2;

//��������������ڣ�
//������
public class EmployeeTest {
	public static void main(String[] args){
        Employee employee1=new Employee("Jim",28,'��',"�������ʦ");  //ʵ����Employee�ഴ��employee1����
        Employee employee2=new Employee("Jim",28,'��',"�������ʦ");  //ʵ����Employee�ഴ��employee2����
        
        employee1.getDetail();  //employee1�������getDetail�������
        employee2.getDetail();  //employee2�������getDetail�������
        
        System.out.println("�ж���λְԱ�Ƿ���ȡ�:");  //��ʾ
        
        System.out.println(employee1.equals(employee2));  //����equals�����ж����������Ƿ����
    }
}
