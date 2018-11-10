/*
 * 自连接，树状 
 */

package po;

import java.util.Set;

public class News {
	private Integer id;
    private String name;
    
    private Set<News> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<News> getChildren() {
		return children;
	}

	public void setChildren(Set<News> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", name=" + name + ", children=" + children + "]";
	}
    
}
