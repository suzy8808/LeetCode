package dollar.kimi.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode200 {
	// 广度优先遍历
	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		int rs = grid.length;
		int cs = grid[0].length;
		int count = 0;
		for (int i = 0; i < rs; i++) {
			for (int j = 0; j < cs; j++) {
				if (grid[i][j] == '1') {
					grid[i][j] = '0';
					count++;
					Queue<int[]> queue = new LinkedList<int[]>();
					queue.add(new int[] { i, j });
					while (!queue.isEmpty()) {
						int[] point = queue.remove();
						int x = point[0];
						int y = point[1];
						if (x > 0 && grid[x - 1][y] == '1') {
							grid[x - 1][y] = '0';
							queue.add(new int[] { x - 1, y });
						}

						if (y > 0 && grid[x][y - 1] == '1') {
							grid[x][y - 1] = '0';
							queue.add(new int[] { x, y - 1 });
						}

						if (x < rs - 1 && grid[x + 1][y] == '1') {
							grid[x + 1][y] = '0';
							queue.add(new int[] { x + 1, y });
						}

						if (y < cs - 1 && grid[x][y + 1] == '1') {
							grid[x][y + 1] = '0';
							queue.add(new int[] { x, y + 1 });
						}
					}
				}
			}
		}
		return count;
	}

	// 深度优先遍历
	public int numIslands2(char[][] grid) {
		if (grid.length == 0)
			return 0;
		int rs = grid.length;
		int cs = grid[0].length;
		int count = 0;
		for (int i = 0; i < rs; i++) {
			for (int j = 0; j < cs; j++) {
				if (grid[i][j] == '1') {
					grid[i][j] = '0';
					count++;
					Stack<int[]> stack = new Stack<int[]>();
					stack.add(new int[] { i, j });
					while (!stack.isEmpty()) {
						int[] point = stack.pop();
						int x = point[0];
						int y = point[1];
						if (x > 0 && grid[x - 1][y] == '1') {
							grid[x - 1][y] = '0';
							stack.add(new int[] { x - 1, y });
						}

						if (y > 0 && grid[x][y - 1] == '1') {
							grid[x][y - 1] = '0';
							stack.add(new int[] { x, y - 1 });
						}

						if (x < rs - 1 && grid[x + 1][y] == '1') {
							grid[x + 1][y] = '0';
							stack.add(new int[] { x + 1, y });
						}

						if (y < cs - 1 && grid[x][y + 1] == '1') {
							grid[x][y + 1] = '0';
							stack.add(new int[] { x, y + 1 });
						}
					}
				}
			}
		}
		return count;
	}

}
