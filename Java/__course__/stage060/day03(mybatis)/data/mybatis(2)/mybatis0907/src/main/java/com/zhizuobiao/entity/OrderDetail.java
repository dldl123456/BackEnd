package com.zhizuobiao.entity;

//`id` int(11) NOT NULL AUTO_INCREMENT,
//`orders_id` int(11) DEFAULT NULL,
//`total_price` decimal(10,2) DEFAULT NULL,
//`items_num` int(11) DEFAULT NULL,
//`items_id` int(11) DEFAULT NULL,
public class OrderDetail {

	private int id;
	private float totalPrice;
	private int itemsNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getItemsNum() {
		return itemsNum;
	}

	public void setItemsNum(int itemsNum) {
		this.itemsNum = itemsNum;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", totalPrice=" + totalPrice + ", itemsNum=" + itemsNum + "]";
	}

}
