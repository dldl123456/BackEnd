/*
 *  一的一端
 *  多对一：在多的一端维护关联关系
 */

package po;

public class Group {
	private Integer gid;
	private String gname;
	
	public Group() {}

	public Group(Integer gid, String gname) {
		this.gid = gid;
		this.gname = gname;
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

	@Override
	public String toString() {
		return "Group [gid=" + gid + ", gname=" + gname + "]";
	}

}
