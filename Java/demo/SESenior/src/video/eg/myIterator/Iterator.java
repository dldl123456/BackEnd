package video.eg.myIterator;

//迭代器角色接口
public interface Iterator<T> {
	//判断是否有下一个元素
	public boolean hasNext();
	
	//获取下一个元素的内容
	public T next();
}
