package eg.oop.abstractFactory;

//宝马523系列  
public class FactoryBMW523 implements AbstractFactory {    
	//发动机B
	public Engine createEngine() {      
		return new EngineB();    
	}
	//空调B
	public Aircondition createAircondition() {    
		return new AirconditionB();    
	}
}   
