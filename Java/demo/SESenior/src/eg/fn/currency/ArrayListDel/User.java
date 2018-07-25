package eg.fn.currency.ArrayListDel;

public class User {
	
	private String name = null;
	private int id = 0;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name) {
		super();
		this.name = name;
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}

	

}
