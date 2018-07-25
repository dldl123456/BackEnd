package demo.ease.BigDecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal(Long.MAX_VALUE);
	    for (int i=0; i<5; i++){
	        bd = bd.multiply(bd);
	    }
	    System.out.println(bd);
	}
}
