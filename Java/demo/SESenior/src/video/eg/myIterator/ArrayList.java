package video.eg.myIterator;

public class ArrayList<T> implements List<T> {
	private Object[] obj = null;  //声明一个Object类型的数组
	//泛型不能声明泛型数组
	private int index;  //数组的下标
	private int size;  //记录数组中的元素个数
	
	public ArrayList(){
		obj = new Object[10];
		index = 0;
		size = 0;
	}
	
	@Override
	public void add(T obj) {
		//把数据存放在数组中
		this.obj[index++] = obj;
		//元素个数加一
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T)this.obj[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this);
	}

}
