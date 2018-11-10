package po;

import java.util.Set;

public class Student {
	private Integer sid;
	private String sname;
	
	private Set<Course> course;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	//多对多只能有一边输出集合，否则死循环（输出学生会输出课程，然后输出课程会输出学生）
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", course=" + course + "]";
	}
	
}
