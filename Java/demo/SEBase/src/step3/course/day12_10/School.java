package step3.course.day12_10;

public class School {
	private Printer prin;
	
	//���췽���аѴ�ӡ��������
	public School(Printer prin){  
		this.prin = prin;
	}
	
	//��ӡ�ķ���
	public void print(){
		//�ô�ӡ�����ô�ӡ�ķ���
		prin.print();  //����(��������|ָ���������)
	}
}
