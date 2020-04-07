package dollar.kimi;

import dollar.kimi.algorithm.Solution;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Solution solution = new Solution();
		solution.rotate(matrix);
	}

}
