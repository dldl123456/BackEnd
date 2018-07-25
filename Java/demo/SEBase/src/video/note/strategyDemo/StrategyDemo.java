/*
 *  ����ģʽ
 */

package video.note.strategyDemo;

public class StrategyDemo {
	public static void main(String[] args) {
		int[] array = {1,5,9,45,77,32,21};
		
		ISort bubbleSort = new BubbleSort();
		ISort selectSort = new SelectSort();
		
		Context context1 = new Context(bubbleSort);
		context1.sort(array);
		context1.printArray(array);
		
		System.out.println("\n");
		
		Context context2 = new Context(selectSort);
		context2.sort(array);
		context2.printArray(array);
	}
}

//���Եĳ�����
class Context{
	private ISort iSort = null;
	
	//���췽��
	//��̬
	public Context(ISort iSort){
		this.iSort = iSort;
	}
	
	public void sort(int[] array){
		//����������յ��Ĳ������������æ����
		iSort.sort(array);
	}
	
	//��ӡ�����е�����
	public void  printArray(int[] array){
		for(int i=0; i<array.length; i++){
			if(i<array.length-1){
				System.out.print(array[i] + ",");
			}else{
				System.out.print(array[i]);
			}
		}
	}
}

//������������㷨�ӿ�
interface ISort{
	//��������������ķ���
	public void sort(int[] array);
}

//������������ӿ�
//��װ��ð������
class BubbleSort implements ISort{
	//��д��ʵ�֣��ӿ������������򷽷�
	public void sort(int[] array){
		System.out.println("ð������");
		for(int i=0; i<array.length-1; i++){
			for(int j=0; j<array.length-1-i; j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}

//������������ӿ�
//��װ��ѡ������
class SelectSort implements ISort{
	//��д��ʵ�֣��ӿ������������򷽷�
	public void sort(int[] array){
		System.out.println("ѡ������");
		int min = 0;
		for(int i=0; i<array.length; i++){
			min = i;
			for(int j=i+1; j<array.length; j++){
				if(array[min]>array[j]){
					min = j;
				}
			}
			if(i != min){
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	}
}