package project.StudentMS_3;

public class School {

    /**
     * 代表这所学校所能容纳的最多学生
     */
    int capacity = 100;
    /**
     * 代表当前的在校学生
     */
    int currentCount = 0;
    /**
     * 存储学校当前的所有在校学生
     */
    Student[] students = new Student[capacity];

    /**
     * 向管理系统添加学生
     * 
     * @param s
     */
    boolean addStudent(Student s) {
        if (currentCount == capacity) {
            return false;
        } else {
            students[currentCount] = s;// 把传过来的学生存数组中
            currentCount++;
            return true;
        }
    }

    /**
     * 按照性别删除学生信息
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
     * 按照姓名删
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
     * 删除指定学生
     */
    private void delStudent(Student s, int index) {
        for (int i = index; i < currentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        students[currentCount - 1] = null;// 把删除前的最后一个非空元素赋值为null
        currentCount--;// 在校人数
    }

    /**
     * 打印所有相关信息
     */
    void print() {
        // 当前学生的数量
        // 输出每个学生的姓名，各科成绩
        printCount();
        for (int i = 0; i < currentCount; i++) {
            printStudent(students[i]);
        }
    }

    /**
     * 打印学生数量
     */
    void printCount() {
        System.out.println("当前学生数量" + currentCount);
        System.out.println("********************");
    }

    /**
     * 打印每个学生的信息
     */
    void printStudent(Student s) {
        s.speak();
        System.out.println("----------------");
    }
}
