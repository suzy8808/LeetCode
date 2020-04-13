package dollar.kimi.zhousai;

import java.util.Arrays;

public class LeetCode5382 {
	public String entityParser(String text) {
		char[] sc = text.toCharArray();
		int len = sc.length;
		out: for (int i = 0; i < len; i++) {
			char c = sc[i];
			if (c == '&') {
				int start = i;
				StringBuilder sb = new StringBuilder();
				while (c != ';') {
					sb.append(c);
					i++;
					if (i >= text.length())
						break out;
					c = sc[i];
				}
				String sub = sb.toString();
				if (sub.equals("&quot")) {
					sc[start] = '\"';
					leftMove(sc, len, start, 5);
					len -= 5;
				} else if (sub.equals("&apos")) {
					sc[start] = '\'';
					leftMove(sc, len, start, 5);
					len -= 5;
				} else if (sub.equals("&amp")) {
					sc[start] = '&';
					leftMove(sc, len, start, 4);
					len -= 4;
				} else if (sub.equals("&gt")) {
					sc[start] = '>';
					leftMove(sc, len, start, 3);
					len -= 3;
				} else if (sub.equals("&lt")) {
					sc[start] = '<';
					leftMove(sc, len, start, 3);
					len -= 3;
				} else if (sub.equals("&frasl")) {
					sc[start] = '/';
					leftMove(sc, len, start, 6);
					len -= 6;
				} else {
					continue;
				}
				i = start;
			}
		}
		sc = Arrays.copyOf(sc, len);
		return String.valueOf(sc);

	}

	void leftMove(char[] sc, int len, int start, int step) {
		for (int i = start + 1; i < len - step; i++) {
			sc[i] = sc[i + step];
		}
	}

	public String entityParser2(String text) {
		text = text.replace("&quot;", "\"");
		text = text.replace("&apos;", "\'");
		text = text.replace("&amp;", "&");
		text = text.replace("&gt;", ">");
		text = text.replace("&lt;", "<");
		text = text.replace("&frasl;", "/");
		return text;
	}
}
