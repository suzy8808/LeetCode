package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode500 {
	public String[] findWords(String[] words) {
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		Set<Character> set3 = new HashSet<Character>();
		List<String> list = new ArrayList<>();
		char[] line1 = new char[] { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P' };
		char[] line2 = new char[] { 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L' };
		char[] line3 = new char[] { 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
		for (char line : line1)
			set1.add(line);
		for (char line : line2)
			set2.add(line);
		for (char line : line3)
			set3.add(line);
		for (String word : words) {
			int flag = 0;
			int i = 0;
			for (; i < word.length(); i++) {
				char c = Character.toUpperCase(word.charAt(i));
				if (set1.contains(c)) {
					if (flag != 0 && flag != 1)
						break;
					flag = 1;
				}
				if (set2.contains(c)) {
					if (flag != 0 && flag != 2)
						break;
					flag = 2;
				}
				if (set3.contains(c)) {
					if (flag != 0 && flag != 3)
						break;
					flag = 3;
				}
			}
			if (i == word.length())
				list.add(word);
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

}
