package dollar.kimi.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

	Integer value;
	List<NestedInteger> list;

	public NestedInteger() {
		super();
		value = 0;
		list = new ArrayList<NestedInteger>();
	}

	public NestedInteger(Integer value, List<NestedInteger> list) {
		super();
		this.value = value;
		this.list = list;
	}

	public boolean isInteger() {
		if (list == null)
			return true;
		return false;
	}

	public Integer getInteger() {
		return value;
	}

	public List<NestedInteger> getList() {
		return list;
	}

	public void setInteger(int value) {
		this.value = value;

	}

	public void add(NestedInteger ni) {
		list.add(ni);

	}

}
