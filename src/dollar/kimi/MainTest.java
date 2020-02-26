package dollar.kimi;

import dollar.kimi.algorithm.KPM;

public class MainTest {
	public static void main(String[] args) {
		KPM kpm = new KPM();
//		int[] next = kpm.getNextArray("ABCDABD");
//		for (int n : next)
//			System.out.println(n);

		System.out.println(kpm.indexOf("ABDHXJSABDJ ABCDABD", "ABCDABD"));
	}

}
