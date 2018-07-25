package eg.oop.comparatorDemo_4;

@SuppressWarnings("rawtypes")
public class Student implements Comparable{
    private String name;
    private int age;
    private int score;
    public Student(String name, int age, int score) {
        super();
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public Student() {
        super();
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
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
    }
    /**
     * �ƶ��ȽϹ���:
     * compareTo(Object o):�Ƚϵ�ǰ������ָ������o֮��Ĺ�ϵ��
     * �����ǰ�������ָ������o����ֵ��������
     * �����ǰ�������ָ������o����ֵ����
     * �����ǰ����С��ָ������o����ֵ�Ǹ�����
     */
    @Override
    public int compareTo(Object o) {
        Student stu = (Student)o;
//        if(age>stu.getAge()){
//            return 1;
//        }else if(age==stu.getAge()){
//            return 0;
//        }else{
//            return -1;
//        }
        return (age-stu.getAge());
    }
    
    
}
