package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode299 {
	public String getHint(String secret, String guess) {
		if (secret.length() != guess.length())
			return null;
		int bulls = 0;
		int cows = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < secret.length(); i++) {
			char sc = secret.charAt(i);
			char gc = guess.charAt(i);
			if (sc == gc)
				bulls++;
			if (map.containsKey(sc)) {
				map.put(sc, map.get(sc) + 1);
			} else {
				map.put(sc, 1);
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			char gc = guess.charAt(i);
			if (map.containsKey(gc)) {
				int sum = map.get(gc) - 1;
				if (sum >= 0) {
					map.put(gc, sum);
					cows++;
				} else {
					map.remove(gc);
				}

			}
		}
		return bulls + "A" + (cows - bulls) + "B";
	}

	public String getHint2(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] secretC = new int[10], guessC = new int[10];
		char[] secretOri = secret.toCharArray(), guessOri = guess.toCharArray();
		for (int i = 0; i < secretOri.length; i++) {
			if (secretOri[i] == guessOri[i]) {
				bulls++;
			} else {
				secretC[secretOri[i] - '0']++;
				guessC[guessOri[i] - '0']++;
			}
		}
		for (int i = 0; i < secretC.length; i++) {
			cows += Math.min(secretC[i], guessC[i]);
		}
		StringBuilder sb = new StringBuilder();
		return sb.append(bulls).append("A").append(cows).append("B").toString();
	}
}
