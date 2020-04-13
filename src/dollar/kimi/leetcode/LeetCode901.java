package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode901 {

	Stack<Integer> stack;
	int[] spanner;
	int len = 0;
	int[] stock;

	public LeetCode901() {
		stack = new Stack<Integer>();
		spanner = new int[10000];
		stock = new int[10000];
	}

	public int next(int price) {
		int nextNum = 1;
		while (!stack.isEmpty() && stock[stack.peek()] <= price) {
			nextNum += spanner[stack.pop()];
		}
		stock[len] = price;
		spanner[len] = nextNum;
		stack.push(len);
		len++;
		return nextNum;
	}
}
