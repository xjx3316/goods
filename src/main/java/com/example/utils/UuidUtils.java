package com.example.utils;

import java.util.UUID;

/**
 * uuid 生成
 * @author yj
 *
 */
public class UuidUtils {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

}
