package step3.course.note.l171210;

public class CalculatorDivide extends Calculator {

	public double getResult(){
		if(getNum2() == 0){
			System.out.println("分母不能为0!");
			return 0.0;
		}
		return getNum1() / getNum2();
	}
	
}
