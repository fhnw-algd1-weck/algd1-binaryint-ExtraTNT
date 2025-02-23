package ch.fhnw.algd1.converters.binary;

public class BinConverter {
	public static String toString(int x) {
		var str = Integer.toBinaryString(x & 0xFF); // it's now unsigned

		var zeros = new String(new char[8 - str.length()]).replace('\0', '0');
		
		return zeros + str;
	}

	public static int fromString(String text) {
		int value = 1;
		int result = 0;
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[chars.length - 1 - i] == '0') {
				value *= 2;
				continue;
			}
			if(i+1 == chars.length) {
				value = -value;
				result += value;
				continue;
			}
			result += value;
			value *= 2;
		}
		
		return result;
	}
}