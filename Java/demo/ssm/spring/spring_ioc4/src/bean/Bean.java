package bean;

public class Bean {
	private Integer id;
	private String name;
	private Bean1 bean1;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bean1 getBean1() {
		return bean1;
	}

	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}

	@Override
	public String toString() {
		return "Bean [id=" + id + ", name=" + name + ", bean1=" + bean1 + "]";
	}

}
