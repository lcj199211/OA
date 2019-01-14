package com.casd;

import java.util.Random;

public final class Utils {
	private static Random random = new Random();

	public static String getRandString(int len, String from) {

		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int index = random.nextInt(from.length());
			temp.append(from.charAt(index));
		}
		return temp.toString();
	}

}
