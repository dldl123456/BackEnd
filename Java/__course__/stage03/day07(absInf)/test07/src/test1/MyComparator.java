package test1;

import java.util.Comparator;

//ʹ�������ڲ��ഴ���Ƚ���
public class MyComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
    	if (o1.length() > o2.length()){
            return 1;  //����ǰ������ڴ��Ƚ϶���
        }
        else if (o1.length() < o2.length()){
            return -1; //����ǰ����С�ڴ��Ƚ϶��� 
        }
        else{
            return 0;  //����ǰ������ڴ��Ƚ϶���
        }
    }
}
