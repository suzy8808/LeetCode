package dollar.kimi;

import dollar.kimi.leetcode.LeetCode151;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
//		LeetCode394 leet = new LeetCode394();
//
//		System.out.println(leet.decodeString("3[a2[b2[c]]]"));// abccbcc
////abcc
		LeetCode151 leet = new LeetCode151();
		System.out.println(leet.reverseWords(" a good   example"));
	}

}
