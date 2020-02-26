package dollar.kimi.algorithm;

public class KPM {
	// ABCDABD
	public int[] getNextArray(String ds) {
		if (ds == null || ds.length() == 0)
			throw new IllegalArgumentException();
		int[] next = new int[ds.length() + 1];
		int i = 1;
		int j = 0;
		for (; i < ds.length(); i++) {
			if (j > 0 && ds.charAt(i) != ds.charAt(j))
				j = next[j];
			if (ds.charAt(i) == ds.charAt(j))
				j++;
			next[i] = j;
		}
		return next;
	}

	public int indexOf(String ss, String ds) {
		if (ss == null || ss.length() == 0 || ds == null || ds.length() == 0)
			throw new IllegalArgumentException();
		int[] next = getNextArray(ds);
		int sLen = ss.length();
		int dLen = ds.length();
		int i = 1;
		int j = 0;
		for (; i < sLen; i++) {
			while (j > 0 && ss.charAt(i) != ds.charAt(j))
				j = next[j];
			if (ss.charAt(i) == ds.charAt(j))
				j++;
			if (j == dLen)
				return i - j + 1;
		}
		return -1;
	}

}
