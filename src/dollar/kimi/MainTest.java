package dollar.kimi;

import dollar.kimi.leetcode.LeetCode105;
import dollar.kimi.leetcode.LeetCode5;
import dollar.kimi.leetcode.LeetCode76;

public class MainTest {
	// ['MinStack','push','push','push','top','pop','getMin','pop','getMin','pop','push','top','getMin','push','top','getMin','pop','getMin']
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode76 leet=new LeetCode76();
		System.out.println(leet.minWindow("a","a"));
	}

}
