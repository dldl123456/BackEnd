package eg.oop.abstractFactory;

//Ϊ����320ϵ���������    
public class FactoryBMW320 implements AbstractFactory{ 
	//������A
	public Engine createEngine() {      
		return new EngineA();    
	}    
	//�յ�A
	public Aircondition createAircondition() {    
		return new AirconditionA();    
	}    
}    
