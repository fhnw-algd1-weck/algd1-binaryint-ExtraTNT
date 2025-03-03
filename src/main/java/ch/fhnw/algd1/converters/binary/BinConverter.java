package ch.fhnw.algd1.converters.binary;

public class BinConverter {
public static String toString(int x) {
    StringBuilder value = new StringBuilder();
    if (x < 0) x += 256;

    int i = 1 << 7;
    while (i >= 1) {
        //value.append((x & i) / i);
        value.append((x & i) != 0 ? '1' : '0');
        i >>>= 1;
    }
    return value.toString();
}
public static int fromString(String text) {
    int value = 1;
    int result = 0;
    char[] chars = text.toCharArray();
    for (int i = 0; i < chars.length - 1; i++) {
        if (chars[chars.length - 1 - i] == '1') result += value;
        value <<= 1;
    }
    if (chars[0] == '1') result -= value;
    return result;
}
}