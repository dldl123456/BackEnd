package video.note.teacherDemo_fz;

public class TeacherDemo {
	//������
	public static void main(String[] args) {		
		Teacher t = new Teacher();  //ʵ����Teacher����
		
		//name
		t.setName("����");  //ͨ��set������name��ֵ
		System.out.println(t.getName());  //�����get����
		
		//age
		t.setAge(55);  //ͨ��set������age��ֵ
		System.out.println(t.getAge());  //�����age����
	}
}

class Teacher{
	//����˽������
	private String name;
	private int age;
	
	//��name����get��set����
	public void setName(String tname){
		name = tname;
	}
	public String getName(){
		return name;
	}
	
	//��age����get��set����
	public void setAge(int tage){
		if(tage<25){
			System.out.println("����̫С");
			age = 25;
		}else{
			age = tage;
		}
	}
	public int getAge(){
		return age;
	}
}
