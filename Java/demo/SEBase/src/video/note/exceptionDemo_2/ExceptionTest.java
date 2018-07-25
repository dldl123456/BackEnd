/*
 *  医生给工作者看病
 */

package video.note.exceptionDemo_2;

import java.util.Random;

public class ExceptionTest {
	//测试类
	public static void main(String[] args) {
		Worker worker = new Worker();
		Doctor doctor = new Doctor();
		
		//捕获异常
		try{
			worker.work();
		}catch(SickException e){
			doctor.cure(worker);
			if(worker.getStatus().equals("健康")){
				System.out.println("恭喜你恢复了");
			}else{
				System.out.println("我尽力了");
			}
		}finally{
			System.out.println("欢迎下次来本院就诊");
		}
	}
}

//工作类
class Worker{
	private String status;  //状态

	//get/set方法
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//一个工作方法
	public void work() throws SickException {
		//实例化一个产生随机数的类
		Random random = new Random();
		int rad = random.nextInt(3) + 1;  //随机数，，，int n = (int)(Math.random()*3+1);
		if(rad==1){  //当随机数等于1时
			//抛出一个自定义异常对象
			throw new SickException("我有病");
		}else{
			System.out.println("身体健康，不用治疗");
		}
	}
}

//自定义异常类
@SuppressWarnings("serial")
class SickException extends Exception{
	private String message;
	public SickException(String message){
		this.message = message;
	}
	
	//重写getMessage方法
	public String getMessage(){
		return message;
	}
}

//医生
class Doctor{
	//治病，给worker实例出的worker对象治病
	public void cure(Worker worker){
		Random random = new Random();
		int rad = random.nextInt(2) + 1;  //变量保存随机数
		
		if(rad==1){
			worker.setStatus("健康");
		}else{
			worker.setStatus("死亡");
		}
	}
}