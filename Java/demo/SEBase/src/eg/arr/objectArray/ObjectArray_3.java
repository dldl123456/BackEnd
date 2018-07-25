package eg.arr.objectArray;
 
//对一个对象数组排序
public class ObjectArray_3 {
   public static void main(String[] args){
      Integer[] intArray ={new Integer(2),new Integer(4),new Integer(1)};
      Double[] doubleArray ={new Double(3.4),new Double(1.3),new Double(-2.1)};
      Character[] charArray = {new Character('a'),new Character('j'),new Character('r')};
      String[] stringArray = {"tom","john","fred"};
  
      sort(intArray);   
      sort(doubleArray);
      sort(charArray);
      sort(stringArray);
       
      System.out.print("sort 1:");
      printlist(intArray);
      System.out.print("sort 2:");
      printlist(doubleArray);
      System.out.print("sort 3:");
      printlist(charArray);
      System.out.print("sort 4:");
      printlist(stringArray);
   }
    
   //sort an  array of comparable objects
   //因为上面都实现了comparable接口，因此可以直接使用compareto方法
   //选择排序
   @SuppressWarnings({ "rawtypes", "unchecked" })
   public static void sort(Comparable[] list){
       Comparable currentmin;
       int currentminindex;
       for(int i=0;i<list.length-1;i++)
       {
           currentmin=list[i];
           currentminindex=i;
           for(int j=i+1;j<list.length;j++)
           {
               if(currentmin.compareTo(list[j])>0)
               {
                   currentmin=list[j];
                   currentminindex=j;
               }
           }
            
           if(currentminindex!=i)
               list[currentminindex]=list[i];
               list[i]=currentmin;
       }
   }
    
   public static void printlist(Object[] list){
       for(int i=0;i<list.length;i++)
           System.out.print(list[i]+" ");
       System.out.println();
   }  
}