package dollar.kimi.leetcode;

public class LeetCode983 {
	public int mincostTickets(int[] days, int[] costs) {
		int i = 0;
		int cost = 0;
		while (i < days.length) {
			float cost1 = costs[0];
			int count2 = 0;
			int j = i;
			while (j < days.length && days[j++] < days[i] + 7)
				count2++;
			float cost2 = (float) (costs[1] * 1.0 / count2);
			int count3 = 0;
			j = i;
			while (j < days.length && days[j++] < days[i] + 30)
				count3++;
			float cost3 = (float) (costs[2] * 1.0 / count3);
			if (cost1 < cost2 && cost1 < cost3) {
				i++;
				cost += costs[0];
			} else if (cost2 < cost1 && cost2 < cost3) {
				i += count2;
				cost += costs[1];
			} else {
				i += count3;
				cost += costs[2];
			}
		}
		return cost;
	}
}
