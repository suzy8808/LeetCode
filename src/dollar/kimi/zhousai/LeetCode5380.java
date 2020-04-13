package dollar.kimi.zhousai;

import java.util.ArrayList;
import java.util.List;

public class LeetCode5380 {
	public List<String> stringMatching(String[] words) {
		List<String> ans = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (j == i)
					continue;
				if (words[j].contains(words[i])) {
					ans.add(words[i]);
					break;
				}
			}
		}
		return ans;
	}
}
