package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dollar.kimi.algorithm.NestedInteger;

public class LeetCode341 implements Iterator<Integer> {
	List<Integer> list;
	int count;

	public LeetCode341(List<NestedInteger> nestedList) {
		list = new ArrayList<Integer>();
		for (NestedInteger item : nestedList) {
			getList(item);
		}
		count = -1;
	}

	private void getList(NestedInteger item) {
		if (item.isInteger())
			list.add(item.getInteger());
		else {
			for (NestedInteger it : item.getList()) {
				getList(it);
			}
		}
	}

	@Override
	public Integer next() {
		count++;
		return list.get(count);

	}

	@Override
	public boolean hasNext() {
		return count != list.size() - 1;
	}

}
