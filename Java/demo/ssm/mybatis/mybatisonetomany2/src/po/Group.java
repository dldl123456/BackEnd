/*
 *  一对多，一的一端
 *  一对多：在1的一端维护关联关系
 *  	即通过group对象把用户的信息查询出来
 */

package po;

import java.util.Set;

public class Group {
	private Integer gid;
	private String gname;
	
	private Set<User> users;  //关联关系

	public Group() {}

	public Group(Integer gid, String gname, Set<User> users) {
		this.gid = gid;
		this.gname = gname;
		this.users = users;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Grop [gid=" + gid + ", gname=" + gname + ", user=" + users + "]";
	}
	
}
