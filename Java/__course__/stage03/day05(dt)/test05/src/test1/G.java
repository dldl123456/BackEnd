package test1;

public class G {
	//�û��е������еķ���
	void makeCry(CanCry c){
        c.cry();
    }
	
	//��������������ڣ�
	public static void main(String[] args) {
		Cat cat = new Cat();  //ʵ����Cat�࣬����cat����
        Dog dog = new Dog();  //ʵ����Dog�࣬����dog����
        G g = new G();  //ʵ����G�࣬����g����
        
        //����makeCryʵ���ö�����
        g.makeCry(cat);
        g.makeCry(dog);
	}
}
