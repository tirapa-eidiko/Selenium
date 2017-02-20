package com.eidiko.integrations;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.excel.ReadExcelData;
import com.eidiko.util.Commons;
import com.eidiko.util.PostMessage;

public class Zendesk implements Runnable {

	final static Logger logs = Logger.getLogger(Zendesk.class);

	static ReadExcelData xls;
	WebDriver driver;
	WebDriverWait wdw;
	Commons commons;
	String screenshot;
	String logString;
	Properties prop;

	public Zendesk(Properties prop) {
		this.prop = prop;
		xls = new ReadExcelData(prop.getProperty("zendeskfile"));
		this.screenshot = prop.getProperty("screenshots"); 
	}

	public void run() {
		startZendesk();
	}

	public void startZendesk(){

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

			// Go to Zendesk app page
			gotoSpecificAppPage();

			// Authenticate by CiscoSpark
			commons.authenticate();
			
			
			// Set focus to iframe
			commons.iframeFocus();
			
			sendDomain();
			
			// Set focus to iframe
			commons.iframeFocus();

			
			// Select notifications
			commons.selectNotifications(xls.getData(6, 1));

			// Select Spark Room
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
				FileUtils.copyFile(scrFile, new File(screenshot+"/zendesk"+ sdf.format(d) + ".png"));
				PostMessage.restCall("Unable to add and remove Zendesk integration", prop);
				driver.close();
			} catch (Exception e1) {
				logs.info("Error while taking screen shot : " + e.getMessage());
			}
		}
	}

	public void gotoSpecificAppPage() throws Exception{
		try{
			// Loading Zendesk Page
			logString = "Loading Zendesk Page";
			logs.info(logString);
			commons.allClick(xls.getData(1, 1)).click();
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}
	
	public void sendDomain() throws Exception{
		try{
			// Enter Zendesk Domain
			logString = "Enter Zendesk Domian";
			logs.info(logString);
			commons.allClick(xls.getData(3, 1)).sendKeys(xls.getData(3, 2));
			
			// Loading Zendesk Page
			logString = "Click Authorization button";
			logs.info(logString);
			commons.allClick(xls.getData(4, 1)).click();
			
			Set<String> windowId = driver.getWindowHandles();
			while(windowId.size()>1){
				Thread.sleep(2000);
				windowId = driver.getWindowHandles();
			}
			System.out.println(windowId.size());
			Iterator<String> itr = windowId.iterator();
			
			String parentWin = itr.next();
			String childWin = itr.next();
			driver.switchTo().window(childWin);
			
			commons.allClick(xls.getData(8, 1));
			driver.switchTo().frame(xls.getData(8, 1));
			
			commons.allClick(xls.getData(9, 1)).sendKeys(xls.getData(9, 2));
			commons.allClick(xls.getData(10, 1)).sendKeys(xls.getData(10, 2));
			commons.allClick(xls.getData(11, 1)).click();
			driver.switchTo().window(parentWin);
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}
	
}
