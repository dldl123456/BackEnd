package eg.oop.abstractFactory;

//����523ϵ��  
public class FactoryBMW523 implements AbstractFactory {    
	//������B
	public Engine createEngine() {      
		return new EngineB();    
	}
	//�յ�B
	public Aircondition createAircondition() {    
		return new AirconditionB();    
	}
}   
