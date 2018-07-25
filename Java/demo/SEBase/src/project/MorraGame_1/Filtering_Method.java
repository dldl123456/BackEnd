package project.MorraGame_1;

import java.util.List;

public class Filtering_Method {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getlist(List first,int number,int winner,int computer,User user) {
		//将集合先赋值
		
		switch (number) {
		case 1:
			if (computer==1||computer==2) {
				System.out.println("电脑出剪刀,你出剪刀,你们平局");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else if (computer==2) {
				System.out.println("电脑出石头,你出剪刀,电脑赢，你输了！");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else{
				System.out.println("电脑出布,你出剪刀,电脑输了，你赢了！");
				winner=winner+1;
				user.setWinner(winner);
				first.add(user.getWinner());
			}
			break;
		case 2:
			if (computer==1) {
				System.out.println("电脑出剪刀,你出石头,你赢了");
				winner=winner+1;
				user.setWinner(winner);
				first.add(user.getWinner());
				
			} else if (computer==2) {
				System.out.println("电脑出石头,你出石头，平局！");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else{
				System.out.println("电脑出布,你出石头,你输了！");
				user.setWinner(winner);
				first.add(user.getWinner());
			}
			break;
		case 3:
			if (computer==1) {
				System.out.println("电脑出剪刀,你出布,你输了");
				user.setWinner(winner);
				first.add(user.getWinner());
			} else if (computer==2) {
				System.out.println("电脑出石头,你出布，你赢！");
				winner=winner+1;
				user.setWinner(winner);
				first.add(user.getWinner());
				
			} else{
				System.out.println("电脑出布,你出布,平局！");
				user.setWinner(winner);
				first.add(user.getWinner());
			}
			break;
		}
		return  first;
	}
}
