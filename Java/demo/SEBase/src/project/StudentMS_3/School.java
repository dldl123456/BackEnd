package project.StudentMS_3;

public class School {

    /**
     * ��������ѧУ�������ɵ����ѧ��
     */
    int capacity = 100;
    /**
     * ����ǰ����Уѧ��
     */
    int currentCount = 0;
    /**
     * �洢ѧУ��ǰ��������Уѧ��
     */
    Student[] students = new Student[capacity];

    /**
     * �����ϵͳ���ѧ��
     * 
     * @param s
     */
    boolean addStudent(Student s) {
        if (currentCount == capacity) {
            return false;
        } else {
            students[currentCount] = s;// �Ѵ�������ѧ����������
            currentCount++;
            return true;
        }
    }

    /**
     * �����Ա�ɾ��ѧ����Ϣ
     */
    void delStudentBySex(String sex) {

        for (int i = 0; i < currentCount; i++) {
            Student s = students[i];
            if (sex.equals(s.sex)) {
                delStudent(s, i);
            }
        }
    }

    /**
     * ��������ɾ
     * 
     * @param name
     */
    void delStudentByName(String name) {

        for (int i = 0; i < currentCount; i++) {
            Student s = students[i];
            if (name.equals(s.name)) {
                delStudent(s, i);
                i--;
            }
        }
    }

    /**
     * ɾ��ָ��ѧ��
     */
    private void delStudent(Student s, int index) {
        for (int i = index; i < currentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        students[currentCount - 1] = null;// ��ɾ��ǰ�����һ���ǿ�Ԫ�ظ�ֵΪnull
        currentCount--;// ��У����
    }

    /**
     * ��ӡ���������Ϣ
     */
    void print() {
        // ��ǰѧ��������
        // ���ÿ��ѧ�������������Ƴɼ�
        printCount();
        for (int i = 0; i < currentCount; i++) {
            printStudent(students[i]);
        }
    }

    /**
     * ��ӡѧ������
     */
    void printCount() {
        System.out.println("��ǰѧ������" + currentCount);
        System.out.println("********************");
    }

    /**
     * ��ӡÿ��ѧ������Ϣ
     */
    void printStudent(Student s) {
        s.speak();
        System.out.println("----------------");
    }
}
