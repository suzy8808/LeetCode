package dollar.kimi;

import dollar.kimi.leetcode.LeetCode189;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode189 leet = new LeetCode189();
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		leet.rotate2(nums, 3);
		for (int num : nums)
			System.out.println(num);

	}

}
