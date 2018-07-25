package test2;

public class Employee extends Person {
	//定义子类私有属性
	private String position;  //职位
	
	//子类构造函数获取父类构造函数的方法
	public Employee(String name, int age, char sex, String position) {
		super(name, age, sex);  //super是父类对象
		this.setPosition(position);  //获取position
	}

	//用get,set方法给Employee类私有属性开放接口
	//position
	public String getPosition() {  //获取position
		return position;
	}
	public void setPosition(String position) {  //定义position
		this.position = position;
	}
	
	//重写方法，判断对象是否相等
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
    
   //输出对象的信息
    public void getDetail(){
        System.out.println("name:" + this.getName() + " age:" + this.getAge() + " sex:" + this.getSex() + "  position:" + this.getPosition());
    }
}
