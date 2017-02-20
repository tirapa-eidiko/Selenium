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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.excel.ReadExcelData;
import com.eidiko.util.Commons;
import com.eidiko.util.PostMessage;

public class Github implements Runnable {

	final static Logger logs = Logger.getLogger(Github.class);

	static ReadExcelData xls;
	WebDriver driver;
	WebDriverWait wdw;
	Commons commons;
	String screenshot;
	String logString;
	Properties prop;

	public Github(Properties prop) {
		this.prop = prop;
		xls = new ReadExcelData(prop.getProperty("githubfile"));
		this.screenshot = prop.getProperty("screenshots");
	}

	public void run() {
		startGithub();
	}

	public void startGithub() {

		try {
			// Loading firefox drivers
			try {
				//driver = new ChromeDriver();
				 driver = new FirefoxDriver();
				driver.manage().window().maximize();
				wdw = new WebDriverWait(driver, 60);
			} catch (Exception e) {
				logs.info(e.getMessage());
				driver.close();
			}

			commons = new Commons(driver, wdw);

			// Load Depot Page and Login
			commons.loginToCiscoSpark();

			// Go to Github app page
			gotoSpecificAppPage();

			commons.authenticate();

			// Set focus to iframe
			commons.iframeFocus();

			// Click Add button
			//commons.clickAdd();
			
			

			// Authorize Github
			authorizeGithub();
			

			// Set focus to iframe
			commons.iframeFocus();

			// Scroll up
			commons.scrollUp(wdw.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(xls.getData(7, 1)))));

			// Select repositories
			commons.selectFromDropDown(xls.getData(7, 1));
			logs.info("Select repositories");

			// Select notifications
			commons.selectNotifications(xls.getData(8, 1));

			// Select notifications
			commons.selectSparkRoom();

			// Delete Instances
			commons.deleteInstance();

			// Disconnect Button
			commons.disconnectApp();
			driver.close();
		} catch (Exception e) {
			logs.error(e.getMessage());
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			try {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"MM-dd-yyyy_HH-mm-ss");
				FileUtils.copyFile(scrFile, new File(screenshot + "/github"
						+ sdf.format(d) + ".png"));
				PostMessage.restCall(
						"Unable to add and remove GitHub integration", prop);
				driver.close();
			} catch (Exception e1) {
				logs.info("Error while taking screen shot : " + e.getMessage());
			}
		}
	}

	public void gotoSpecificAppPage() throws Exception {
		try {
			// Loading Github Page
			logString = "Loading Github Page";
			logs.info(logString);
			commons.allClick(xls.getData(1, 1)).click();
		} catch (Exception e) {
			throw new Exception("Error at : " + logString + " -- Exception : "
					+ e.getMessage());
		}
	}

	public void authorizeGithub() throws Exception {
		try {
			// Enter Github email id
			
			commons.allClick(xls.getData(10, 1)).click();
			logString = "Enter Github email id";
			logs.info(logString);
			commons.allClick(xls.getData(3, 1)).sendKeys(xls.getData(3, 2));

			// Enter Github password
			logString = "Enter Github password";
			logs.info(logString);
			commons.allClick(xls.getData(4, 1)).sendKeys(xls.getData(4, 2));

			// Click Login button
			logString = "Click Login button";
			logs.info(logString);
			commons.allClick(xls.getData(5, 1)).click();
		} catch (Exception e) {
			throw new Exception("Error at : " + logString + " -- Exception : "
					+ e.getMessage());
		}
	}
}
