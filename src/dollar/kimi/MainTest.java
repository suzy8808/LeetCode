package dollar.kimi;

import dollar.kimi.leetcode.LeetCode856;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode856 leet = new LeetCode856();
		System.out.println(leet.scoreOfParentheses("((()()))"));
	}

}
