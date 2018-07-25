package video.eg.myIterator;

public class Test {
	public static void main(String[] args) {
		List<String> nameList = new ArrayList<>();
		
		nameList.add("уехЩ");
		nameList.add("11");
		nameList.add("12");
		
		Iterator<String> it = nameList.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		for(int i=0; i<nameList.size(); i++){
			System.out.println(nameList.get(i));
		}
	}
}
