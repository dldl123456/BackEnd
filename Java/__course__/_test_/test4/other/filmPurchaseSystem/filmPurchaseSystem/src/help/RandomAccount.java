package help;

import java.util.List;

import dao.impl.UserDaoImpl;
import entity.User;

/**
 * 生成随机9位数字账号
 * @author Administrator
 *
 */
public class RandomAccount {
	public static int randomAccount() {
		int account;
		int index=-1;
		try {
			List<User> users=new UserDaoImpl().queryUsers();
			account = (int)((Math.random()*9+1)*100000000);
			for(User user:users) {
				if(user.getUserAccount()==account) {
					index=user.getUserId();
					break;
				}
			}
			if(index==-1) {
				return account;
			}else {
				randomAccount();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	} 
}
