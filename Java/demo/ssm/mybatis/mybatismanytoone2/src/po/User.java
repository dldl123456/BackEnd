/*
 *  一对多，多的一端：维护关系
 */

package po;

public class User {
	private Integer uid;
	private String uname;
	
	private Group group;  //关联关系
	
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", group=" + group + "]";
	}

}
