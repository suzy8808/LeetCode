package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode205 {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			Character sc = s.charAt(i);
			Character tc = t.charAt(i);
			if (map.containsKey(sc)) {
				if (!map.get(sc).equals(tc)) {
					return false;
				}
			} else {
				if (map.containsValue(tc)) {
					return false;
				}
				map.put(sc, tc);
			}
		}
		return true;
	}
}
