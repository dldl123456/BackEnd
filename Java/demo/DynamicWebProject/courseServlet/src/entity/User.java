package entity;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private String loves;
    
    public User() {}
    
	public User(String userName, String password, String sex, String loves) {
		super();
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.loves = loves;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLoves() {
		return loves;
	}
	public void setLoves(String loves) {
		this.loves = loves;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", sex=" + sex + ", loves=" + loves + "]";
	}
    
}
