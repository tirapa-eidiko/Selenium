package com.eidiko.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.eidiko.integrations.Zendesk;


public class Testing1 {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("ciscointegration.properties");
		prop.load(input);
		//System.setProperty("webdriver.gecko.driver",prop.getProperty("geckodriver"));
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver"));
		
		Zendesk serviceNow = new Zendesk(prop.getProperty("zendeskfile"));
		Thread t10 =new Thread(serviceNow);  
		t10.start();
		
	}
}
