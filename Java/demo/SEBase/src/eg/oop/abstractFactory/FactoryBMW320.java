package eg.oop.abstractFactory;

//为宝马320系列生产配件    
public class FactoryBMW320 implements AbstractFactory{ 
	//发动机A
	public Engine createEngine() {      
		return new EngineA();    
	}    
	//空调A
	public Aircondition createAircondition() {    
		return new AirconditionA();    
	}    
}    
