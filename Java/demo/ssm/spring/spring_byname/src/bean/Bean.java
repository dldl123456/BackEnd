package bean;

public class Bean {
	private Bean1 bean1;
    private Bean2 bean2;
    
	public Bean1 getBean1() {
		return bean1;
	}
	
	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}
	
	public Bean2 getBean2() {
		return bean2;
	}
	
	public void setBean2(Bean2 bean2) {
		this.bean2 = bean2;
	}
	
	@Override
	public String toString() {
		return "Bean [bean1=" + bean1 + ", bean2=" + bean2 + "]";
	}
}
