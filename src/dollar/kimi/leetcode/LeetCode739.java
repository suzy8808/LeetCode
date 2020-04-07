package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode739 {
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] ans = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
				int sp = stack.pop();
				ans[sp] = i - sp;
			}
			stack.add(i);
		}
		return ans;
	}

	public int[] dailyTemperatures2(int[] T) {
		int length = T.length;
		int[] result = new int[length];

		// �����������
		for (int i = length - 2; i >= 0; i--) {
			// j+= result[j]�������Ѿ��еĽ��������Ծ
			for (int j = i + 1; j < length; j += result[j]) {
				if (T[j] > T[i]) {
					result[i] = j - i;
					break;
				} else if (result[j] == 0) { // ����0��ʾ���治���и����ֵ���ǵ�Ȼ��ǰֵ��Ӧ��ҲΪ0
					result[i] = 0;
					break;
				}
			}
		}

		return result;
	}

}
