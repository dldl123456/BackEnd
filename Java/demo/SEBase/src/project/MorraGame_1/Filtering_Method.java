package project.MorraGame_1;

import java.util.List;

public class Filtering_Method {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getlist(List first,int number,int winner,int computer,User user) {
		//�������ȸ�ֵ
		
		switch (number) {
		case 1:
			if (computer==1||computer==2) {
				System.out.println("���Գ�����,�������,����ƽ��");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else if (computer==2) {
				System.out.println("���Գ�ʯͷ,�������,����Ӯ�������ˣ�");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else{
				System.out.println("���Գ���,�������,�������ˣ���Ӯ�ˣ�");
				winner=winner+1;
				user.setWinner(winner);
				first.add(user.getWinner());
			}
			break;
		case 2:
			if (computer==1) {
				System.out.println("���Գ�����,���ʯͷ,��Ӯ��");
				winner=winner+1;
				user.setWinner(winner);
				first.add(user.getWinner());
				
			} else if (computer==2) {
				System.out.println("���Գ�ʯͷ,���ʯͷ��ƽ�֣�");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else{
				System.out.println("���Գ���,���ʯͷ,�����ˣ�");
				user.setWinner(winner);
				first.add(user.getWinner());
			}
			break;
		case 3:
			if (computer==1) {
				System.out.println("���Գ�����,�����,������");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else if (computer==2) {
				System.out.println("���Գ�ʯͷ,���������Ӯ��");
				winner=winner+1;
				user.setWinner(winner);
				first.add(user.getWinner());
				
			} else{
				System.out.println("���Գ���,�����,ƽ�֣�");
				user.setWinner(winner);
				first.add(user.getWinner());
			}
			break;
		}
		return  first;
	}
}
