package dollar.kimi.algorithm;

import java.util.List;

import dollar.kimi.algorithm.iface.NestedInteger;

public class NestedIntegerImpl implements NestedInteger {

	Integer value;
	List<NestedInteger> list;

	public NestedIntegerImpl(Integer value, List<NestedInteger> list) {
		super();
		this.value = value;
		this.list = list;
	}

	@Override
	public boolean isInteger() {
		if (list == null)
			return true;
		return false;
	}

	@Override
	public Integer getInteger() {
		return value;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}

}
