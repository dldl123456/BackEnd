package video.eg.myIterator;

//容器接口，定义这个容器所具备的功能
public interface List<T> {
	//给具体的容器添加元素
	public void add(T obj);
	
	//获取指定位置上的元素
	public T get(int index);
	
	//获得容器中的元素个数
	public int size();
	
	//得到具体的迭代器对象
	public Iterator<T> iterator();
}
