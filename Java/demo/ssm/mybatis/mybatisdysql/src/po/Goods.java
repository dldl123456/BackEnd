package po;

public class Goods {
	private Integer id;
	private String goodsName;
	private float price;
	private Integer num;
	
	public Goods() {}

	public Goods(Integer id, String goodsName, float price, Integer num) {
		this.id = id;
		this.goodsName = goodsName;
		this.price = price;
		this.num = num;
	}

	public Goods(String goodsName, float price, Integer num) {
		this.goodsName = goodsName;
		this.price = price;
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsname=" + goodsName + ", price=" + price + ", num=" + num + "]";
	}
}
