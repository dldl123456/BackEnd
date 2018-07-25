package eg.oop.comparatorDemo_2;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
	public static void main(String[] args) {
		String[] strs = { "abc", "yb", "xiaoqianga", "laifu", "wangcai", "oye" };
        Arrays.sort (strs, new Comparator<String> ()
        {
            @Override
            public int compare ( String o1, String o2 )
            {
                if (o1.length () > o2.length ())
                {
                    return 1;
                }
                else if (o1.length () < o2.length ())
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        });
        System.out.println (Arrays.toString(strs));
	}
}
