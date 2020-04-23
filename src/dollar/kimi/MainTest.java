package dollar.kimi;

import dollar.kimi.leetcode.LeetCode152;

public class MainTest {
	// ['MinStack','push','push','push','top','pop','getMin','pop','getMin','pop','push','top','getMin','push','top','getMin','pop','getMin']
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode152 leet = new LeetCode152();
		leet.maxProduct(new int[] { 2, 3, -2, 4 });
	}

}
