package test2;

public class School {
	private Printer p = null;  //��װ��ӡ��
	
	//��װ��ӡ��
	//�ø�������ñ�����Ϊ�������ô����ǿ��Խ����κ�������Ķ���
	public void setPrinter(Printer p){
		this.p = p;
	}
	
	//��ӡ�ķ���
	public void print(String content){
		//������������װ�Ĳ�ɫ��ӡ������ӡ
		p.print(content);
	}
}
