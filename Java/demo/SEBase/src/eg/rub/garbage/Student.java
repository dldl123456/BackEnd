package eg.rub.garbage;

public class Student {
	String name;
    public Student(String name){
        this.name=name;
    }
    /**
     * finalize()����������ǰ���ã������ڸ÷����б�дһЩ��������ǰҪ��������Ĵ���
     * ���������Ա�ֹ����ã��÷�������JVM����������ǰ�Զ�����
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()��������");
    }
}
