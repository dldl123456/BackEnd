/*
 *  ��asdascveasrgdfsdf����ȡ���ַ����У�ÿһ����ĸ���ֵĴ�����
 *  Ҫ�󣺴�ӡ����ǣ�a(2)b(1)... 
 */

package test3;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class AccountStringDemo {
	public static void main(String[] args) {
		String str = "asdascveasrgdfsdf";  //��ʼ�ַ���
		
		//ʵ����һ��map����
		HashMap<String, Integer> hmap = new HashMap<>();
		
		//�����ַ���
		for (int i=0; i<str.length(); i++) {
			//charAt�����ַ���ָ���������� char ֵ
			//valueOf(char c)��ʾ���� char �������ַ�����ʾ��ʽ
			//�ָ��ַ���������ֱ�����ַ���key��
			String key = String.valueOf(str.charAt(i));
			
			//�ж�map�������Ƿ����key���������������룬
			//��������򷵻ظü���ӳ���ֵ�����Ҽ�1
			if (!hmap.containsKey(key)) {
				hmap.put(key, 1);
			} else {
				int val = hmap.get(key);
				hmap.put(key, val + 1);
			}
		}

		//ʵ����һ��Entry����
		Set<Entry<String, Integer>> entrys = hmap.entrySet();

		//����Entry�����е����м�ֵ�ԣ�������ʽ���
		for (Entry<String, Integer> entry : entrys) {
			System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
		}
	}
}
