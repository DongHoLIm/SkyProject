package com.kh.finalProject.common;

import java.util.UUID;

public class CommonUtils {
	public static String getRandomString() {
		
		// 32비트의 문자열을 랜덤하게 생성해준다.
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
