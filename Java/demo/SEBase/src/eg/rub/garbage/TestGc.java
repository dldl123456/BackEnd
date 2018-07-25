package eg.rub.garbage;

public class TestGc {
	public static void main(String[] args) {
        Student stu = new Student("张三");
        System.out.println(stu);
        stu=null;
        //建议垃圾回收器回收垃圾
        System.gc();
    }
}
