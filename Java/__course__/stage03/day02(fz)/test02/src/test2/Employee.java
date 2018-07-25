package test2;

public class Employee extends Person {
	//��������˽������
	private String position;  //ְλ
	
	//���๹�캯����ȡ���๹�캯���ķ���
	public Employee(String name, int age, char sex, String position) {
		super(name, age, sex);  //super�Ǹ������
		this.setPosition(position);  //��ȡposition
	}

	//��get,set������Employee��˽�����Կ��Žӿ�
	//position
	public String getPosition() {  //��ȡposition
		return position;
	}
	public void setPosition(String position) {  //����position
		this.position = position;
	}
	
	//��д�������ж϶����Ƿ����
    public boolean equals(Employee empy){
        if(this.getName().equals(empy.getName())
        		&&this.getAge()==empy.getAge()
        		&&this.getSex()==empy.getSex()
        		&&this.getPosition().equals(empy.getPosition())){
            return true;
        }
        else{
            return false;
        }
    }
    
   //����������Ϣ
    public void getDetail(){
        System.out.println("name:" + this.getName() + " age:" + this.getAge() + " sex:" + this.getSex() + "  position:" + this.getPosition());
    }
}
