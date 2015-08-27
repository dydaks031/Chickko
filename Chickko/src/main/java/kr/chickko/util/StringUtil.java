package kr.chickko.util;

/*
 * 0채우기
 */
public class StringUtil {
	public static String zeroFill(int data, int len){
		String format = "%0" + len + "d";
		return String.format(format, data);
	}
}
