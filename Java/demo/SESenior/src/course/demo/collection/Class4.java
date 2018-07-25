package course.demo.collection;

import java.util.HashSet;

public class Class4{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		
		//要求名字相同，就认为是同一个对象
		//重写equals和hashcode方法
		user1.setName("w");
		user2.setName("w");
		user3.setName("w");
		
		// 不允许重复、无序
		HashSet hashSet = new HashSet();
		hashSet.add("a");
		hashSet.add("b");
		hashSet.add("c");
		
		/*hashSet.add(user1);
		hashSet.add(user2);
		hashSet.add(user3);*/
		
		//System.out.println(hashSet.size());
		
		for(int i=0; i<100; i++){
			hashSet.add(i);
		}
		
		for(Object obj : hashSet){
			System.out.println(obj);
		}
		
	}
}