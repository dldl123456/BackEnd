/*
 * 多对多：一个课程里面有很多学生，一个学生也可以报很多课程 
 */

package dao;

import java.util.List;

import po.News;

public interface NewsDao {
	//根据父节点id查子节点数据
	public List<News> getChildrenByPid(int pid);
}
