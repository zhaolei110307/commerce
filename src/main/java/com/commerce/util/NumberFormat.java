package com.commerce.util;

public class NumberFormat {

	public static double StringToDoubleValue(String num) {
		if (CheckUtil.isNull(num)) {
			return 0D;
		}
		return Double.valueOf(num);
	}
	
	public static Double StringToDouble(String num) {
		if (CheckUtil.isNull(num)) {
			return null;
		}
		return Double.valueOf(num);
	}
	
	public static int StringToIntValue(String num) {
		if (CheckUtil.isNull(num)) {
			return 0;
		}
		return Integer.valueOf(num);
	}
	
	
	public static Integer StringToInteger(String num) {
		if (CheckUtil.isNull(num)) {
			return null;
		}
		return Integer.valueOf(num);
	}
	
}
