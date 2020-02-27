package dollar.kimi;

import java.util.Stack;

import dollar.kimi.leetcode.LeetCode155;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode155 leet = new LeetCode155();
		leet.push(2147483646);
		leet.push(2147483646);
		leet.push(2147483647);
		leet.top();
		leet.pop();
		System.out.println(leet.getMin());
		leet.pop();
		System.out.println(leet.getMin());
		leet.pop();
		leet.push(2147483647);
		leet.top();
		System.out.println(leet.getMin());
		leet.push(-2147483648);
		leet.top();
		System.out.println(leet.getMin());
		leet.pop();
		System.out.println(leet.getMin());

		Stack<Integer> stack = new Stack<>();

	}

}
