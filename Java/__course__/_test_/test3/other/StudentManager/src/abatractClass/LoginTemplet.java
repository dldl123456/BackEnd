package abatractClass;
import common.AssistClass;
//��¼ϵ�з�����ģ��ģʽ
import common.ProvingNum;
import test.Page;
/**
 * �����࣬�����������Ա�̳У�ʵ�ֵ�¼ϵ�в���
 * @author Administrator
 *
 */
public abstract class LoginTemplet {
	int PwCount =0;//������¼��������Ĵ���
	public static int indexAccount=-1;//��������˺Ŵ���ʱ���±�
	public static int indexPassword =-1;//��������������ʱ���±�
	/**
	 * ��¼����,���õ�
	 * ģ��ģʽ��������ʵ�������
	 */
	public void Login(){
		System.out.println("��ӭ�����¼ҳ�棺");
		int count =0;
		b:while(count<3) {
			count++;
			System.out.println("�����������˺ţ�");
			ergodicName();//�ɸ���ʵ��
			if(indexAccount!=-1){
				System.out.println("���������룺");
				ergodicPw();//�������õ������±꣬��ɵ�¼,���󷽷�
				break;
			}else {
				if(count<3) {
					System.out.println("�Բ�����������˺��������������룡����");
					continue b;
				}else {
					System.out.println("�Բ����������Ѿ����������˺��������ϵͳ���Զ�������ҳ�棡����");
					Page.homePage();
				}
			}
		}
		System.out.println("��½�ɹ�����ѡ����һ��������");
		AssistClass.nowTime();//���ø�����ķ�������ʱ��
		loginTime();//��½����
		Page.loginSuccess();
	}
	/**
	 * ���ӵ�¼��������ʾ��¼״̬
	 */
	public abstract void loginTime();
	/**
	 * ��������������������������ֵ���бȽ�
	 */
	public abstract int ergodicName();
	/**
	 * ȷ���������������������ʵ��
	 */
	public void affirmPwCount() {
		PwCount++;
		if(PwCount<=2) {
			System.out.println("�Բ��������������������������룺");
			System.out.println("���������룺");
		}
		if(PwCount>2&&PwCount<5) {
			System.out.println("���Ѿ����"+PwCount+"�����룬Ϊ�˰�ȫ���������������λ��֤�루�����ִ�Сд����");
			ProvingNum.operateProv();
		}
		if(PwCount==5) {
			System.out.println("���Ѿ����"+PwCount+"�����룬������һ�λ��ᣬ����������˺��������Զ��˳�ϵͳ������");
			ProvingNum.operateProv();
		}
		if(PwCount==6) {
			System.out.println("����������Ѿ����"+PwCount+"������\n�����յ��˺��������ﵽ���ޣ���ǰ�˻���������״̬������ϵ����Ա����������Ļ������������ԣ�����");
			System.exit(0);
		}
	}

	/**
	 * �������õ������±꣬��ɵ�¼
	 */
	public abstract void ergodicPw();
}
