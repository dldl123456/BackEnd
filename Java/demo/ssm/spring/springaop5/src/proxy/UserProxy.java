/*
 * AOP 
 */

package proxy;

/*
 * 切面（一个方法就是一个切片[程序片]）
 * aspect(切面)
 */
public class UserProxy {
	
	public void check(){
		System.out.println("检查权限");
	}

}
