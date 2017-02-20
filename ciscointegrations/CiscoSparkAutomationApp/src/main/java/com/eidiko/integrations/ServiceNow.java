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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.excel.ReadExcelData;
import com.eidiko.util.Commons;
import com.eidiko.util.PostMessage;

public class ServiceNow implements Runnable {

	final static Logger logs = Logger.getLogger(ServiceNow.class);

	static ReadExcelData xls;
	WebDriver driver;
	WebDriverWait wdw;
	Commons commons;
	String screenshot;
	String logString;
	Properties prop;

	public ServiceNow(Properties prop) {
		this.prop = prop;
		xls = new ReadExcelData(prop.getProperty("servicenowfile"));
		this.screenshot = prop.getProperty("screenshots"); 
	}

	public void run() {
		startServiceNow();
	}

	public void startServiceNow(){

		try {
			// Loading firefox drivers
			try {
				driver = new ChromeDriver();
				//driver = new FirefoxDriver();
				driver.manage().window().maximize();
				wdw = new WebDriverWait(driver, 60);
			} catch (Exception e) {
				logs.info(e.getMessage());
				driver.close();
			}

			commons = new Commons(driver, wdw);

			// Load Depot Page and Login
			commons.loginToCiscoSpark();

			// Go to ServiceNow app page
			gotoSpecificAppPage();

			// Authenticate by CiscoSpark
			commons.authenticate();

			// Set focus to iframe
			commons.iframeFocus();
			
			// Scroll up
			commons.scrollUp(wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xls.getData(3, 1)))));

			// Select Objects
			commons.selectFromDropDown(xls.getData(3, 1));
			logs.info("Select Version");
			
			// Select Tables
			commons.selectFromDropDown(xls.getData(5, 1));
			logs.info("Select Notifications");

			// Select notifications
			selectSparkRoom();

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
				FileUtils.copyFile(scrFile, new File(screenshot+"/serviceNow"+ sdf.format(d) + ".png"));
				PostMessage.restCall("Unable to add and remove ServiceNow integration", prop);
				driver.close();
			} catch (Exception e1) {
				logs.info("Error while taking screen shot : " + e.getMessage());
			}
		}
	}

	public void gotoSpecificAppPage() throws Exception{
		try{
			// Loading ServiceNow Page
			logString = "Loading ServiceNow Page";
			logs.info(logString);
			commons.allClick(xls.getData(1, 1)).click();
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}
	
	public void selectSparkRoom() throws Exception{
		try{
			logString = "Scroll up to Cisco Room Dropdown";
			logs.info(logString);
			commons.scrollUp(driver.findElement(By.xpath(xls.getData(7, 1))));

			logString = "Enter Description";
			logs.info(logString);
			driver.findElement(By.xpath(xls.getData(10, 1))).sendKeys(xls.getData(10, 2));
			Thread.sleep(2000);
			
			commons.allClick(xls.getData(7, 1)).click();
			commons.allClick(xls.getData(8, 1)).sendKeys(xls.getData(8, 2));
			Thread.sleep(2000);
			driver.findElement(By.xpath(xls.getData(9, 1))).click();
	

			
			logString = "Cisco Spark room selected";
			logs.info(logString);
			
			driver.findElement(By.xpath(xls.getData(11, 1))).click();
			commons.allClick(xls.getData(12, 1)).click();
			
			Thread.sleep(5000);
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}
}
