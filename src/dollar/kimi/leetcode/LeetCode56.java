package dollar.kimi.leetcode;

import java.util.Arrays;

public class LeetCode56 {
	public int[][] merge(int[][] intervals) {
		// �Ȱ���������ʼλ������
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
		// ��������
		int[][] res = new int[intervals.length][2];
		int idx = -1;
		for (int[] interval : intervals) {
			// �����������ǿյģ����ߵ�ǰ�������ʼλ�� > �������������������ֹλ�ã�
			// �򲻺ϲ���ֱ�ӽ���ǰ������������顣
			if (idx == -1 || interval[0] > res[idx][1]) {
				res[++idx] = interval;
			} else {
				// ��֮����ǰ����ϲ������������������
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}
		return Arrays.copyOf(res, idx + 1);
	}

}
