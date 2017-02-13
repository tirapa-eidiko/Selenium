package com.eidiko.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	static Properties prop;
	public Properties setProperties(String propertiesFilePath){
		try{
			prop = new Properties();
			InputStream input = new FileInputStream(propertiesFilePath);
			prop.load(input);
			System.setProperty("webdriver.gecko.driver",prop.getProperty("geckodriver"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return prop;
	}
}
