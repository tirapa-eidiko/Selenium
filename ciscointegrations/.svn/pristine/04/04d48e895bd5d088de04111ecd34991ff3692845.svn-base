package com.eidiko.util;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	public void loginToCiscoSpark() throws Exception {
		logString = "Start";
		try {
			// Loading Depot page
			logString = "Loading Depot page";
			logs.info(logString);
			driver.get(gED.getData(1, 1));

			// Click on Login link
			logString = "Login link is clicked";
			logs.info(logString);
			allClick(gED.getData(2, 1)).click();

			// Entered Email Id to login
			logString = "Entered Email Id to login";
			logs.info(logString);
			driver.findElement(By.xpath(gED.getData(3, 1))).sendKeys(gED.getData(3, 2));

			// Click Next Verify Email Id
			logString = "Click Next Verify Email Id";
			logs.info(logString);
			driver.findElement(By.xpath(gED.getData(4, 1))).click();

			// Entered password to login
			logString = "Entered password to login";
			logs.info(logString);
			allClick(gED.getData(5, 1)).sendKeys(gED.getData(5, 2));

			// Click Sign In Button
			logString = "Click Sign In Button";
			logs.info(logString);
			driver.findElement(By.xpath(gED.getData(6, 1))).click();

			// Load Page with Application List
			logString = "Load Page with Application List";
			logs.info(logString);
			allClick(gED.getData(7, 1)).click();
			
		} catch (Exception e) {
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void authenticate() throws Exception{
		logString = "Start";
		try{
			while (true) {
				try {
					Thread.sleep(5000);
					logString = "Click Connect button";
					logs.info(logString);
					driver.findElement(By.xpath(gED.getData(10, 1))).click();
					break;
				} catch (Exception e) {
					// Click Disconnect button
					driver.findElement(By.xpath(gED.getData(27, 1))).click();
	
					// Click Ok button
					allClick(gED.getData(28, 1)).click();
				}
			}
	
			// Click Accept button
			logString = "Click Accept button";
			logs.info(logString);
			allClick(gED.getData(11, 1)).click();
			
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void iframeFocus() throws Exception {
		try{
			// Set focus to iframe
			logString = "Set focus to iframe";
			logs.info(logString);
			allClick(gED.getData(13, 1));
			driver.switchTo().frame(gED.getData(13, 2));
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void clickAdd() throws Exception{
		try{
			// Click Add button
			logString = "Click Add button";
			logs.info(logString);
			allClick(gED.getData(15, 1)).click();
	
			// Set focus to default window
			driver.switchTo().defaultContent();
			
			
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void selectSparkRoom() throws Exception{
		try{
			
			logString = "Scroll up to Cisco Room Dropdown";
			logs.info(logString);
			scrollUp(driver.findElement(By.xpath(gED.getData(18, 1))));

			logString = "Enter Description";
			logs.info(logString);
			driver.findElement(By.xpath(gED.getData(18, 1))).sendKeys(gED.getData(18, 2));
			Thread.sleep(2000);
			
			allClick(gED.getData(19, 1)).click();
			allClick(gED.getData(20, 1)).sendKeys(gED.getData(20, 2));
			Thread.sleep(2000);
			driver.findElement(By.xpath(gED.getData(21, 1))).click();
	

			
			logString = "Cisco Spark room selected";
			logs.info(logString);
			/*while (true) {
				try {
					driver.findElement(By.xpath(gED.getData(20, 1))).click();
					break;
				} catch (Exception e) {
					driver.findElement(By.xpath(gED.getData(19, 1))).click();
				}
			}*/

			logString = "Select Spark room";
			logs.info(logString);
			driver.findElement(By.xpath(gED.getData(22, 1))).click();
			allClick(gED.getData(23, 1)).click();
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void deleteInstance() throws Exception{
		try{
			// Click X button
			logString = "Click X button";
			logs.info(logString);
			allClick(gED.getData(25, 1)).click();
	
			// Click Remove button
			logString = "Click Remove button";
			logs.info(logString);
			allClick(gED.getData(26, 1)).click();		
			
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}
	
	public void disconnectApp() throws Exception{
		try{
			// Set focus to default window
			driver.switchTo().defaultContent();
	
			// Click Disconnect button
			logString = "Click Disconnect button";
			logs.info(logString);
			allClick(gED.getData(27, 1)).click();
	
			// Click Ok button
			logString = "Click OK button";
			logs.info(logString);
			allClick(gED.getData(28, 1)).click();
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void scrollUp(WebElement we) throws Exception{
		try{
			logString = "Scroll to element";
			logs.info(logString);
			// Scroll to element
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", we);
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void selectFromDropDown(String xpath) throws Exception{

		Thread.sleep(2000);
		try{
			logString = "Select from Dropdown";
			logs.info(logString);
			Select DropBP = new Select(allClick(xpath));
			int x = DropBP.getOptions().size();
			int y = new Random().nextInt(x);
			if (y == 0)
				y = 1;
			DropBP.selectByIndex(y);
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public void selectNotifications(String xpath) throws Exception{
		try{
			logString = "Select notification";
			logs.info(logString);
			String[] arr = xpath.split("\\n");
			int n = arr.length;
			int randomNum = new Random().nextInt(n);
			int se = 0;
			for (int i = 0; i <= randomNum; i++) {
				se = new Random().nextInt(n);
				if (arr[se].equals("1")) {
					--i;
					continue;
				}
				driver.findElement(By.xpath(arr[se])).click();
				arr[se] = "1";
			}
		}catch(Exception e){
			throw new Exception("Error at : "+logString+" -- Exception : "+e.getMessage());
		}
	}

	public WebElement allClick(String xpath) {
		WebElement we = wdw.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(xpath)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return we;
	}
}
