/*
 *  ʹ���ڲ��࿪��һ��������ݵ�����
 */

package video.note.entryDemo;

import java.util.Arrays;

public class EntryDemo {
	public static void main(String[] args) {
		MyContainer container = new MyContainer();
		container.put("jas", "aa");
		container.put("j2s", "er");
		container.put("fsa", "bf");
		container.put("bgf", "ds");
		container.put("kuy", "sa");
		
		MyContainer.Entry[] entrys = container.entryArrays();
		
		for(int i=0; i<entrys.length; i++){
			MyContainer.Entry entry = entrys[i];
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
	}
}

//������
class MyContainer{
	//���entry��������飬Ĭ�ϴ�СΪ5
	private Entry[] entrys = new Entry[5];
	
	private int count = 0;  //�±�
	
	//�����ṩһ���ӿ��������д�ŷ�װ�õ�����(Entry)
	public void put(String key, String value){
		Entry entry = new Entry();
		entry.setKey(key);
		entry.setValue(value);
		
		entrys[count++] = entry;  //���entry����������
		
		//���������
		if(count>=entrys.length){
			int newCapacity = entrys.length * 2;  //���ݺ��������Ĵ�С
			//��������(entrys)�����ݿ�����������(newCapacity)��
			//����������ֻ���entrys
			entrys = Arrays.copyOf(entrys, newCapacity);
		}
	}
	
	//�������������ݵ����ݷ���
	public Entry[] entryArrays(){
		return Arrays.copyOfRange(entrys, 0, count);
	}
	
	//��̬�ڲ���
	//�Ѽ�ֵ�Է�װ��Entry������
	public static class Entry{
		private String key;
		private String value;
		
		//key
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		//value
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}
