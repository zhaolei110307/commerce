package com.commerce.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
	
	public static Double doubleValue(String num) {
		if (num == null || "".equals(num.trim())) {
			return null;
		}else {
			return new BigDecimal(num).doubleValue();
		}
	}
}
