package eg.arr.objectArray_3;

public class Student {
	// 成员变量
		private String name;
		private int age;

		// 构造方法
		public Student() {
			super();
		}

		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		// 成员方法
		// getXxx()/setXxx()
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

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}
		
		//返回Student对象数组(默认学生)
		/*public Student[] getStudent() {
		    Student[] stu = new Student[3];
			Student stu1 = new Student("张三", 18);
			Student stu2 = new Student("李四", 45);
			Student stu3 = new Student("王五", 33);
			stu[0] = stu1;
			stu[1] = stu2;
			stu[2] = stu3;
			return stu;	
		}*/
}
