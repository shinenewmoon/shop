package com.atguigu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class imgPathUtils {

	public static String getimgPath(String property,String path) {
		Properties properties = new Properties();
		InputStream inputStream = imgPathUtils.class.getClassLoader().getResourceAsStream(property);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String img_path = properties.getProperty(path);
		return img_path;
	}
	
}
