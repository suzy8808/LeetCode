package dollar.kimi;

import dollar.kimi.leetcode.LeetCode1209;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode1209 leet = new LeetCode1209();
		System.out.println(leet.removeDuplicates("deeedbbcccbdaa", 3));

	}

}
