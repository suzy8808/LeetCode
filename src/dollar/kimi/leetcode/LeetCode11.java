package dollar.kimi.leetcode;

public class LeetCode11 {
	public int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int maxVolume = 0;
		while (left < right) {
			int lH = height[left];
			int rH = height[right];
			int volume = Math.min(lH, rH) * (right - left);
			if (volume > maxVolume)
				maxVolume = volume;
			if (lH > rH) {
				right--;
			} else {
				left++;
			}
		}
		return maxVolume;
	}
}
