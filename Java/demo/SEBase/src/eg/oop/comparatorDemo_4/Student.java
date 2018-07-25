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
     * 制定比较规则:
     * compareTo(Object o):比较当前对象与指定对象o之间的关系。
     * 如果当前对象大于指定对象o返回值是正整数
     * 如果当前对象等于指定对象o返回值是零
     * 如果当前对象小于指定对象o返回值是负整数
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
