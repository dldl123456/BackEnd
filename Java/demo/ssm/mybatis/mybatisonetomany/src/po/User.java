/*
 *  一对多，多的一端
 */

package po;

public class User {
	private Integer uid;
	private String uname;
	
	public User() {}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + "]";
	}
	
}
