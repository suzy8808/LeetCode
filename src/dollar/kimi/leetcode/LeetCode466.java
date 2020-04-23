package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode466 {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if (n1 == 0)
			return 0;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int l1 = s1.length();
		int l2 = s2.length();
		int counts1 = 0;
		int counts2 = 0;
		int p = 0;// s2µÄÎ»ÖÃ
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		while (counts1 < n1) {
			for (int i = 0; i < l1; i++) {
				if (c1[i] == c2[p]) {
					p++;
					if (p == l2) {
						p = 0;
						counts2++;
					}
				}
			}
			counts1++;
			if (!map.containsKey(p)) {
				map.put(p, new int[] { counts1, counts2 });
			} else {
				int[] last = map.get(p);
				int circle1 = counts1 - last[0];
				int circle2 = counts2 - last[1];
				counts2 += circle2 * ((n1 - counts1) / circle1);
				counts1 = counts1 + ((n1 - counts1) / circle1) * circle1;
			}
		}
		return counts2 / n2;
	}
}
