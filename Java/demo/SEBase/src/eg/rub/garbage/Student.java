package eg.rub.garbage;

public class Student {
	String name;
    public Student(String name){
        this.name=name;
    }
    /**
     * finalize()在垃圾回收前调用，可以在该方法中编写一些垃圾回收前要做的事情的代码
     * 不建议程序员手工调用，该方法是有JVM在垃圾回收前自动调用
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()被调用了");
    }
}
