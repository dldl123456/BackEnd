/*
 *  面向对象练习，创建一个雇员类
 */

package video.note.employee;

public class Employee {
	public String name;
	public int age;
	
	//返回个人信息
	public String toString(){
		return "我的名字叫：" + name + "今年：" + age + "岁";
	}
	
	/*
	 * src:朋友啊朋友
	 * dst:朋友
	 * indexOf("朋友");
	 */
	//在指定的字符串中查找相应的字符串出现的次数
	public int countContent(String src, String dst){
		int count = 0;  //计数器
		int index = 0;  //保存找到朋友的下标
		index = src.indexOf(dst);
		//indexOf找到返回首次出现的下标，找不到返回-1
		while(index!=-1){
			count++;  //计数器+1
			index += dst.length();  //指定从哪个下标往后找
			index = src.indexOf(dst, index);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.name = "张三";
		emp.age = 14;
		System.out.println(emp.toString());
		
		String src = "朋友啊朋友";
		String dst = "朋友";
		int count = emp.countContent(src, dst);
		System.out.println(dst + "出现的次数为" + count + "次");
	}
}
