package com.eidiko.integrations;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.excel.ReadExcelData;
import com.eidiko.util.Commons;
import com.eidiko.util.PostMessage;

public class Smartsheet implements Runnable {

	final static Logger logs = Logger.getLogger(Smartsheet.class);

	static ReadExcelData xls;
	WebDriver driver;
	WebDriverWait wdw;
	Commons commons;
	String screenshot;
	String logString;
	Properties prop;

	public Smartsheet(Properties prop) {
		this.prop = prop;
		xls = new ReadExcelData(prop.getProperty("smartsheetfile"));
		this.screenshot = prop.getProperty("screenshots"); 
	}

	public void run() {
		startSmartsheet();
	}

	public void startSmartsheet(){

		try {
			// Loading firefox drivers
			try {
				driver = new FirefoxDriver();
				wdw = new WebDriverWait(driver, 60);
			} catch (Exception e) {
				logs.info(e.getMessage());
				driver.close();
			}
commons = new Commons(driver, wdw);

			// Load Depot Page and Login
			commons.loginToCiscoSpark();

			// Go to Smartsheet app page
			gotoSpecificAppPage();

			// Authenticate by CiscoSpark
			commons.authenticate();

			// Set focus to iframe
			commons.iframeFocus();

			// Click Add button
			commons.clickAdd();

			// Authorize Smartsheet
			authorizeSmartsheet();

			// Select the smartsheet sheets
			Thread.sleep(2000);
			logString = "Select  sheets from Dropdown";
			logs.info(logString);
			System.out.println("dropdown the sheets...." + xls.getData(8, 1));
			// Set focus to iframe
			commons.iframeFocus();
			System.out.println("After iframe Focus");
			// Scroll up
			commons.scrollUp(wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xls.getData(8, 1)))));
			System.out.println("After Scroll");
			commons.selectFromDropDown(xls.getData(8, 1));

			// commons.allClick(xls.getData(8, 1)).sendKeys(xls.getData(8, 1));

			// Select notifications
			commons.selectNotifications(xls.getData(9, 1));

			// Select notifications
			commons.selectSparkRoom();

			// Delete Instances
			commons.deleteInstance();

			// Disconnect Button
			commons.disconnectApp();

			driver.close();
		} catch (Exception e) {
			logs.error(e.getMessage());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
				FileUtils.copyFile(scrFile, new File(screenshot + "/smartsheet" + sdf.format(d) + ".png"));
				PostMessage.restCall("Unable to add and remove Smartsheet integration", prop);
				driver.close();
			} catch (Exception e1) {
				logs.info("Error while taking screen shot : " + e.getMessage());
			}
		}
	}

	public void gotoSpecificAppPage() throws Exception {
		try {
			// Loading Smartsheet Page
			logString = "Loading Smartsheet Page";
			logs.info(logString);
			commons.allClick(xls.getData(1, 1)).click();
		} catch (Exception e) {
			throw new Exception("Error at : " + logString + " -- Exception : " + e.getMessage());
		}
	}

	public void authorizeSmartsheet() throws Exception {
		try {
			// Enter Smartsheet email id
			logString = "Enter smartsheet email id";
			logs.info(logString);
			commons.allClick(xls.getData(3, 1)).sendKeys(xls.getData(3, 2));

			// Enter Smartsheet Continue button
			logString = "Enter smartsheet Continue button";
			logs.info(logString);
			commons.allClick(xls.getData(4, 1)).click();

			// Enter Smartsheet password
			logString = "Enter smartsheet password";
			logs.info(logString);
			commons.allClick(xls.getData(5, 1)).sendKeys(xls.getData(5, 2));

			// Click Login button
			logString = "Click Login button";
			logs.info(logString);
			commons.allClick(xls.getData(6, 1)).click();

			// Click Allow button
			logString = "Click Allow button";
			logs.info(logString);
			commons.allClick(xls.getData(7, 1)).click();

		} catch (Exception e) {

			throw new Exception("Error at : " + logString + " -- Exception : " + e.getMessage());
		}
	}
}
