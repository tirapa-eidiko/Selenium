package com.eidiko.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.excel.ReadExcelData;

public class Commons {
	static ReadExcelData gED;
	public WebDriver driver;
	public WebDriverWait wdw;
	final static Logger logs = Logger.getLogger(Commons.class);
	String logString;

	public static void setFile(ReadExcelData getExcelData) {
		Commons.gED = getExcelData;
	}

	public Commons(WebDriver driver, WebDriverWait wdw) {
		this.driver = driver;
		this.wdw = wdw;
	}
	public WebElement allClick(String xpath) {
		WebElement we = wdw.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(xpath)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return we;
	}
}
