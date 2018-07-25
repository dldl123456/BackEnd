package eg.arr.objectArray_2;

public class ObjectArray {
	private String name;
	private int age;
	
	public ObjectArray(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		//创建1个Demo1对象数组student,包含了3个3空间
		ObjectArray[]student=new ObjectArray[3];
		//实例化对象数组
		student[0]=new ObjectArray("张飞",20);
		student[1]=new ObjectArray("吴广",10);
		student[2]=new ObjectArray("赵云",50);
		//循环遍历取得
		//student[i]得到的事对象数组
		for (int i = 0; i < student.length; i++) {
			System.out.println("名字:"+student[i].getName()+"年龄:"+student[i].getAge());
		}
	}
}
