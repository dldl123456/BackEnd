package eg.oop.abstractFactory;

public class Customer {
	@SuppressWarnings("unused")
	public static void main(String[] args){    
        //��������320ϵ�����
		System.out.println("��������320ϵ�����");
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();    
        factoryBMW320.createEngine();  
        factoryBMW320.createAircondition();  
            
        //��������523ϵ�����
        System.out.println("��������523ϵ�����");
        FactoryBMW523 factoryBMW523 = new FactoryBMW523();    
        factoryBMW320.createEngine();  
        factoryBMW320.createAircondition();  
    }  
}
