package com.commerce.util;

public class CheckUtil {
	
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			if ("".equals(obj.toString().trim())) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
