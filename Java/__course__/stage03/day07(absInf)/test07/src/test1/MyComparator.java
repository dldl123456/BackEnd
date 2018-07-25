package test1;

import java.util.Comparator;

//使用匿名内部类创建比较器
public class MyComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
    	if (o1.length() > o2.length()){
            return 1;  //代表当前对象大于待比较对象
        }
        else if (o1.length() < o2.length()){
            return -1; //代表当前对象小于待比较对象 
        }
        else{
            return 0;  //代表当前对象等于待比较对象
        }
    }
}
