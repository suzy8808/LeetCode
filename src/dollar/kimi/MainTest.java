package dollar.kimi;

import dollar.kimi.leetcode.LeetCode210;

import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {
	// ['MinStack','push','push','push','top','pop','getMin','pop','getMin','pop','push','top','getMin','push','top','getMin','pop','getMin']
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		LeetCode210 leet=new LeetCode210();
		leet.findOrder(2,new int[][]{{0,1},{1,0}});
	}

}
