/*
 *  自定义异常类
 */

package video.note.exceptionDemo_1;

public class ExceptionDemo_3 {
	public static void main(String[] args) {
		Bar0 b0 = new Bar0();
		try{
			b0.enter(15);
		}catch(AgeLessThanEighteenException e){
			System.out.println("错误信息：" + e.getMessage());
		}
		System.out.println("end~");
	}
}

//自定义了一个异常类(小于18岁)
//一个受查异常
@SuppressWarnings("serial")
class AgeLessThanEighteenException extends Exception{  //继承异常父类
	//声明属性
	private String message;  //描述异常信息
	
	//创建一个带一个参数的构造方法
	public AgeLessThanEighteenException(String message){
		this.message = message;
	}
	
	//重写获取描述异常信息的方法
	public String getMessage(){
		return message;
	}
}

//子类
class Bar0{
	public void enter(int age) throws AgeLessThanEighteenException{
		if(age<18){
			throw new AgeLessThanEighteenException("年龄不合格");
		}else{
			System.out.println("欢迎光临");
		}
	}
}
