package com.zhizuobiao.other;

public class Order {

	public Order() {
		// 创建商品
		Item item = new Item();
		item.setId(11);
		item.setName("手机");
		item.setPrice(4999);

		this.setItem(item);
	}

	private int id;
	private String desc;
	private Item item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", desc=" + desc + ", item=" + item + "]";
	}

}
