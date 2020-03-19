package dollar.kimi;

import dollar.kimi.leetcode.LeetCode299;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode299 leet = new LeetCode299();
		System.out.println(leet.getHint2("1123", "0111"));
	}

}
