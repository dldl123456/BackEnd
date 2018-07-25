package student;

import java.util.Arrays;

public class BasicArray {
    //����
    private long arr[];
    //�������Ч����
    private int elements;
    //�������󳤶�
    private int max;
    //��ʼ��
    public BasicArray(int max){
        this.max = max;
        arr = new long[max];
    }

    /**
     * ��������
     * @param value
     */
    public void insert(long value){
        if (elements > max) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[elements] = value;
        elements ++ ;
    }

    /**
     * ��ʾȫ������
     */
    public void display(){
        System.out.print("[");
        for (int i = 0; i < elements; i++) {
            System.out.print(" "+ arr[i]);
        }
        System.out.println(" ]");
    }

    /**
     * ����ֵ��������
     * @param value
     * @return
     */
    public int search(long value){
        int i;
        for (i = 0; i < elements; i++) {
            //��ʾ�ҵ����˳�ѭ��
            if (arr[i] == value) {
                break;
            }
        }
        if (i == elements) {
            return -1;
        }else {
            return i;
        }
    }

    /**
     * ��������������ֵ
     * @param index
     * @return
     */
    public long get(int index){
        if (index > elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * ����index�ϵ�ֵ
     * @param index
     * @param value
     */
    public void change(int index, long value){
        if (index > elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[index] = value;
    }

    /**
     * ɾ��index�ϵ�����
     * @param index
     */
    public void delete(int index){
        if (index > elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }else {
            for (int i = index; i < elements; i++) {
                arr[i] = arr[i + 1];
            }
           elements --;
        }
    }

    public static void main(String[] args) {
        BasicArray array = new BasicArray(30);//��������ʵ����
        array.insert(22);
        array.insert(12);
        array.insert(34);
        array.insert(44);
        array.insert(86);
        array.insert(57);
        //��ʾ
        array.display();
        System.out.println("======================================");
        //����
        System.out.println(array.search(12));
        System.out.println("======================================");
        //�޸�
        array.change(2, 50);
        array.display();
        System.out.println("======================================");
        //ɾ��
        array.delete(3);
        array.display();
    }
}
