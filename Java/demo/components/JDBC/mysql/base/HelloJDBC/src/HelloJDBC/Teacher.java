package HelloJDBC;

public class Teacher {
	int teaId = 0;
	String teaName = null;
	int teaSalary = 0;
	char teaGender = 0;
	int teaAge = 0;
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public int getTeaSalary() {
		return teaSalary;
	}
	public void setTeaSalary(int teaSalary) {
		this.teaSalary = teaSalary;
	}
	public char getTeaGender() {
		return teaGender;
	}
	public void setTeaGender(char teaGender) {
		this.teaGender = teaGender;
	}
	public int getTeaAge() {
		return teaAge;
	}
	public void setTeaAge(int teaAge) {
		this.teaAge = teaAge;
	}
	@Override
	public String toString() {
		return "Teacher [teaId=" + teaId + ", teaName=" + teaName + ", teaSalary=" + teaSalary + ", teaGender="
				+ teaGender + ", teaAge=" + teaAge + "]";
	}
}
