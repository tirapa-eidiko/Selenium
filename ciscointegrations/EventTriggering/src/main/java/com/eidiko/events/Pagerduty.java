package com.eidiko.events;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.excel.ReadExcelData;
import com.eidiko.util.Commons;

public class Pagerduty implements Runnable{
	final static Logger logs = Logger.getLogger(Pagerduty.class);
	Properties prop;
	WebDriver driver;
	WebDriverWait wdw;
	ReadExcelData xls;
	String screentshots;
	Commons commons;
	
	public Pagerduty(Properties prop, ReadExcelData xls) {
		this.prop = prop;
		this.xls = xls;
		this.screentshots = prop.getProperty("screenshots");
	}

	public void run() {
		startPagerduty();
	}
	
	private void startPagerduty() {
		try {
			driver = new ChromeDriver();
			// driver = new FirefoxDriver();
			driver.manage().window().maximize();
			wdw = new WebDriverWait(driver, 60);
		} catch (Exception e) {
			logs.info(e.getMessage());
			driver.close();
		}
		commons = new Commons(driver, wdw);
		
		driver.get(xls.getData(1, 1));
		commons.allClick(xls.getData(3, 1)).sendKeys(xls.getData(3, 2));
		commons.allClick(xls.getData(4, 1)).sendKeys(xls.getData(4, 2).trim());
		commons.allClick(xls.getData(5, 1)).click();
		commons.allClick(xls.getData(6, 1)).click();
		
		commons.allClick(xls.getData(8, 1)).click();
		commons.allClick(xls.getData(9, 1)).click();
		commons.allClick(xls.getData(10, 1)).click();
		commons.allClick(xls.getData(11, 1)).click();
		
		commons.allClick(xls.getData(13, 1)).click();
		commons.allClick(xls.getData(14, 1)).click();
		
		driver.close();
	}
}
