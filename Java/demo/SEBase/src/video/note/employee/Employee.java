/*
 *  ���������ϰ������һ����Ա��
 */

package video.note.employee;

public class Employee {
	public String name;
	public int age;
	
	//���ظ�����Ϣ
	public String toString(){
		return "�ҵ����ֽУ�" + name + "���꣺" + age + "��";
	}
	
	/*
	 * src:���Ѱ�����
	 * dst:����
	 * indexOf("����");
	 */
	//��ָ�����ַ����в�����Ӧ���ַ������ֵĴ���
	public int countContent(String src, String dst){
		int count = 0;  //������
		int index = 0;  //�����ҵ����ѵ��±�
		index = src.indexOf(dst);
		//indexOf�ҵ������״γ��ֵ��±꣬�Ҳ�������-1
		while(index!=-1){
			count++;  //������+1
			index += dst.length();  //ָ�����ĸ��±�������
			index = src.indexOf(dst, index);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.name = "����";
		emp.age = 14;
		System.out.println(emp.toString());
		
		String src = "���Ѱ�����";
		String dst = "����";
		int count = emp.countContent(src, dst);
		System.out.println(dst + "���ֵĴ���Ϊ" + count + "��");
	}
}
