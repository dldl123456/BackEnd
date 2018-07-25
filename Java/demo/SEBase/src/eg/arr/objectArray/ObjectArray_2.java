package eg.arr.objectArray;

public class ObjectArray_2 {
	int age;
    String name;

    ObjectArray_2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "," + age + "]";
    }

    public static void main(String[] args) {
    	ObjectArray_2[] t = new ObjectArray_2[3];
        t[0] = new ObjectArray_2(18, "zs");
        t[1] = new ObjectArray_2(19, "ls");
        t[2] = new ObjectArray_2(20, "ww");
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
    }
}
