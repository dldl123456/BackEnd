package eg.arr.objectArray_3;

public class Student {
	// ��Ա����
		private String name;
		private int age;

		// ���췽��
		public Student() {
			super();
		}

		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		// ��Ա����
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
		
		//����Student��������(Ĭ��ѧ��)
		/*public Student[] getStudent() {
		    Student[] stu = new Student[3];
			Student stu1 = new Student("����", 18);
			Student stu2 = new Student("����", 45);
			Student stu3 = new Student("����", 33);
			stu[0] = stu1;
			stu[1] = stu2;
			stu[2] = stu3;
			return stu;	
		}*/
}
