package video.note.arraydemo;

import java.util.*;

public class Arraydemo_4 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
        //��������
        String [] arr;
        int arr1[];
          
        //��ʼ������
        int arr2[]=new int[]{1,2,3,4,5};
        String[] array1={"��","����","����","����","�ŷ�"};
        String[] array2=new String[]{"�Ʋ�","������","�����","С��","����","����"};
          
        String[] array=new String[5];
      
          
        //�鿴����ĳ���
        int length=array1.length;
        System.out.println("length��  "+array1.length);
          
        //�������
//      System.out.println(array1);     //�����[Ljava.lang.String;@32f22097
        System.out.println("arr2:  "+Arrays.toString(arr2));
          
        //��������
        for (int i = 0; i < array1.length; i++) {
//          System.out.println(array1[i]);
        }
        //int����ת��string����
        int[]  array3={1,2,3,4,5,6,7,8,9,0};
        String arrStrings=Arrays.toString(array3);
//      System.out.println(arrStrings);
          
        //��array�д���arraylist
        ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList(array1));
        System.out.println(arrayList);
          
        //�������Ƿ����ĳһ��ֵ
        String a="��";
        if (Arrays.asList(array1).contains(a)) {
            System.out.println("��������");
        }
          
        //������ת��set����
        Set<String> set=new HashSet<String>(Arrays.asList(array2));
        System.out.println(set);
          
        //������ת��list����
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < array2.length; i++) {
            list.add(array2[i]);
        }
        String[] arrStrings2={"1","2","3"};
        List<String > list2=java.util.Arrays.asList(arrStrings2);
        System.out.println(list2);
          
          
        //Arrays.fill()�������
        int[] arr3=new int[5];
        Arrays.fill(arr3, 10);  //������ȫ�����10
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
          
        //��������
        int[] arr4 = {3, 7, 2, 1, 9};
        Arrays.sort(arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(arr4[i]);
        }
          
        int[] arr5 = {3, 7, 2, 1, 9,3,45,7,8,8,3,2,65,34,5};
        Arrays.sort(arr5, 1, 4);  //�ӵڼ������ڼ���֮��Ľ�������
        for (int i = 0; i < arr5.length; i++) {
            System.out.println(arr5[i]);
        }
          
          
        //��������
        int[] arr6 = {3, 7, 2, 1};
        int[] arr7=Arrays.copyOf(arr6, 10);  //ָ��������ĳ���
          
        int[] arr8=Arrays.copyOfRange(arr6, 1, 3); //ֻ���ƴ�����[1]������[3]֮���Ԫ�أ�����������[3]��Ԫ�أ�
        for (int i = 0; i < arr8.length; i++) {
            System.out.println(arr8[i]);
        }
          
        //�Ƚ���������
        int[] arr9 = {1, 2, 3, 4,5,6,7,8,9,0};
        boolean arr10=Arrays.equals(arr6, arr9);
        System.out.println(arr10);
      
        //ȥ�ظ�
        //����set������
        int[] arr11 = {1, 2, 3, 4,5,6,7,8,9,0,3,2,4,5,6,7,4,32,2,1,1,4,6,3};
        Set<Integer> set2=new HashSet<Integer>();
        for (int i = 0; i < arr11.length; i++) {
            set2.add(arr11[i]);
        }
            System.out.println(set2);
        int[] arr12 = new int[set2.size()];
        int j=0;
        for (Integer i:set2) {
            arr12[j++]=i;
        }
        System.out.println(Arrays.toString(arr12));
    }
}
