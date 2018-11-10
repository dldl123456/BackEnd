/*
 *  商品条件
 *  价格范围
 *  单独写一个类做条件搜索
 */

package po;

public class GoodsCondition {
	private float maxPrice;
	private float minPrice;
	
	public float getMaxPrice() {
		return maxPrice;
	}
	
	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	public float getMinPrice() {
		return minPrice;
	}
	
	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}
	
	@Override
	public String toString() {
		return "GoodsCondition [maxPrice=" + maxPrice + ", minPrice=" + minPrice + "]";
	}
}
