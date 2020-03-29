package dollar.kimi.leetcode;

import java.util.Arrays;

public class LeetCode475 {
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);

		int res = 0;

		for (int house : houses) {
			// ����������ǰ house �� heaters �е�λ��
			int index = binarySearch(heaters, house);

			if (index < 0) { // ˵��û�ҵ���index ���ڵ�ǰ�� house Ӧ���� heaters ��λ�õĸ���
				// �������ǰ�� house Ӧ���� heaters �����е�λ��
				index = -(index + 1);
				// ���㵱ǰ house ���������� heater �ľ���
				int leftDist = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
				// ���㵱ǰ house ���ұ������ heater �ľ���
				int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

				// ��ǰ house ��Ҫ�� heater �İ뾶ȡ leftDist �� rightDist ����Сֵ
				res = Math.max(res, Math.min(leftDist, rightDist));
			}
		}

		return res;
	}

	private int binarySearch(int[] heaters, int house) {
		int low = 0;
		int hight = heaters.length - 1;
		while (low <= hight) {
			int mid = (low + hight) >>> 1;

			if (heaters[mid] < house) {
				low = mid + 1;
			} else if (heaters[mid] > house) {
				hight = mid - 1;
			} else {
				return mid;
			}
		}
		return -(low + 1);
	}

	public int findRadius2(int[] houses, int[] heaters) {

		int max = 0;
		Arrays.sort(heaters);
		for (int i = 0; i < houses.length; i++) {
			int d = 0;
			int j = 0;
			while (j < heaters.length) {
				if (houses[i] == heaters[j]) {
					d = 0;
				} else if (houses[i] > heaters[j] && j == heaters.length - 1) {
					d = houses[i] - heaters[j];
				} else if (houses[i] > heaters[j] && houses[i] < heaters[j + 1]) {
					d = Math.min(heaters[j + 1] - houses[i], houses[i] - heaters[j]);
				} else if (houses[i] < heaters[j] && j == 0) {
					d = heaters[j] - houses[i];
				}
				j++;
			}
			if (max < d)
				max = d;
		}
		return max;

	}

}
