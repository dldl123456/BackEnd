/*
 *  �����1��ʼ������n����֮�ͣ������ֵ�պó���100ʱ�����������n��ֵ
 */

package video.note.evaluation;

public class Evaluation {
	public static void main(String[] args) {
		int n = 0;  //Ҫ�󱻼ӵ���
		int sum = 0;  //�ۼ����
		
		do{
			n++;
			sum += n;
		} while (sum<=100);
		
		System.out.println("��1��ʼ������" + n + "����֮�ͣ������ֵ�պó���100ʱ��������ʱ���ۼӺ�Ϊ��" + sum);
	}
}
