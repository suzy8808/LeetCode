package dollar.kimi.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LastShowAlpha {
	public String deleteLastAlpha(String s) {
		if (s == null || s.length() == 0)
			return s;
		Integer min = Integer.MAX_VALUE;
		List<Character> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character st = s.charAt(i);
			if (map.containsKey(st)) {
				map.put(st, map.get(st) + 1);
			} else {
				map.put(st, 1);
			}
		}

		for (Character key : map.keySet()) {
			int value = map.get(key);
			if (value < min) {
				list.clear();
				min = value;
				list.add(key);
			} else if (value == min) {
				list.add(key);
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			Character st = s.charAt(i);
			if (!list.contains(st)) {
				sb.append(st);
			}
		}
		return sb.toString();
	}

	public String deleteLastAlpha2(String s) {
		if (s == null || s.length() == 0)
			return s;
		Integer min = Integer.MAX_VALUE;
		List<Character> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character st = s.charAt(i);
			if (map.containsKey(st)) {
				map.put(st, map.get(st) + 1);
			} else {
				map.put(st, 1);
			}
		}

		for (Character key : map.keySet()) {
			int value = map.get(key);
			if (value < min) {
				list.clear();
				min = value;
				list.add(key);
			} else if (value == min) {
				list.add(key);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			Character st = s.charAt(i);
			if (list.contains(st)) {
				s = s.replaceAll(String.valueOf(st), "");
			}
		}
		return s;
	}

	public String deleteLastAlpha3(String s) {
		if (s == null || s.length() == 0)
			return s;
		String sTemp = s;
		Integer stLen = sTemp.length();
		List<String> list = new ArrayList<String>();
		Integer min = Integer.MAX_VALUE;
		while (stLen > 0) {
			String st = String.valueOf(sTemp.charAt(0));
			sTemp = sTemp.replaceAll(st, "");
			int num = stLen - sTemp.length();
			if (min > num) {
				list.clear();
				list.add(st);
				min = num;
			} else if (min == num) {
				list.add(st);
			}
			stLen = sTemp.length();
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			String st = String.valueOf(s.charAt(i));
			if (!list.contains(st)) {
				sb.append(st);
			}
		}
		return sb.toString();
	}

}
