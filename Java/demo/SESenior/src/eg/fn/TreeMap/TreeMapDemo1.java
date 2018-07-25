package eg.fn.TreeMap;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo1 {
	public static void main(String[] args) {
		TreeMap<String, String> sPara = new TreeMap<String, String>();
	    sPara.put("abc", "abc");
	    sPara.put("cds", "cds");
	    sPara.put("ads","ads");
	    sPara.put("fff", "fff");
	    sPara.put("ccc", "ccc");
	    sPara.put("ddd", "ddd");
	    sPara.put("qqqqq", "qqqqq");
	    sPara.put("knns", "knns");
	    sPara.put("ioio", "ioio");
	    Set<String> keys = sPara.keySet();
	    for (String key : keys){
	        System.out.println(key);
	    }
	}
}
