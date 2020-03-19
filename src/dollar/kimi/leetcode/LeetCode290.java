package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode290 {
	public boolean wordPattern(String pattern, String str) {
		char[] ps = pattern.toCharArray();
		String[] words = str.split(" ");
		if (ps.length != words.length)
			return false;
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < ps.length; i++) {
			set.add(words[i]);
			if (map.containsKey(ps[i])) {
				if (!map.get(ps[i]).equals(words[i]))
					return false;
			} else {
				map.put(ps[i], words[i]);
			}
		}
		return set.size() == map.size();
	}
}
