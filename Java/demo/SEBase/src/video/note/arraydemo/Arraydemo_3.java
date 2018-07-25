package video.note.arraydemo;

public class Arraydemo_3 {
	public static void main(String[] args) {
        
        int[] arr11 = {10, 2, 3, 4,5,6,7,8,9,0,3,2,4,5,6,7,4,32,2,1,1,4,6,3};
         //计算最大值
        int max = arr11[0];
        for (int i = 1; i < arr11.length; i++) {
             if (arr11[i] > max) {
                 max = arr11[i];
            }
          }
          System.out.println("Max is " + max);
          //计算最小值
          int min = arr11[0];
          for (int i = 0; i < arr11.length; i++) {
            if (arr11[i]<min) {
                min = arr11[i];
            }
        }
          System.out.println("Min is " + min);
    }
}
