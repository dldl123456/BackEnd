package eg.rub.garbage;

public class TestGc {
	public static void main(String[] args) {
        Student stu = new Student("����");
        System.out.println(stu);
        stu=null;
        //����������������������
        System.gc();
    }
}
