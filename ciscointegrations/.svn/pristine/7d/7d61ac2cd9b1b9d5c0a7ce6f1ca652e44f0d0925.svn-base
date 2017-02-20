package com.eidiko.common;

import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethods {
	
	private WebDriver driver;
	private WebDriverWait wdw;
	private XSSFSheet sheet;
	
	public CommonMethods(WebDriver driver, WebDriverWait wdw, XSSFSheet sheet){
		this.driver = driver;
		this.wdw = wdw;
		this.sheet = sheet;
	}
	
	public void loginToAppSpecificPage() throws Exception{
		try {
			driver.get(sheet.getRow(1).getCell(1).toString());
	
			driver.findElement(By.xpath(sheet.getRow(2).getCell(1).toString())).click();
			System.out.println("Login link is clicked");
	
			driver.findElement(By.xpath(sheet.getRow(3).getCell(1).toString())).sendKeys(sheet.getRow(3).getCell(2).toString());
			System.out.println("Entered Email Id to login");
	
			driver.findElement(By.xpath(sheet.getRow(4).getCell(1).toString())).click();
			System.out.println("Verify Email Id to login");
	
			allClick(sheet.getRow(5).getCell(1).toString()).sendKeys(sheet.getRow(5).getCell(2).toString());
			System.out.println("Entered password to login");
	
			driver.findElement(By.xpath(sheet.getRow(6).getCell(1).toString())).click();
			System.out.println("Sign In Button Click");
	
			System.out.println("Login to Cisco Spark Depot Success");
			allClick(sheet.getRow(7).getCell(1).toString()).click();
			System.out.println("Load Page with Application List");
			
			allClick(sheet.getRow(8).getCell(1).toString()).click();
			System.out.println("Load Application page");
		} catch (Exception e) {
			driver.close();
			throw new Exception("Depot page not loading");
		}
	}
	
	public void clickConnect() throws Exception{
		try{
			//click connect button
			allClick(sheet.getRow(9).getCell(1).toString()).click();
			allClick(sheet.getRow(10).getCell(1).toString()).click();
		}catch(Exception e){
			throw new Exception("Error while clicking Connect Button");
		}
	}
	
	public void clickAddButton() throws Exception{
		try{
			//click Add button
			allClick(sheet.getRow(11).getCell(1).toString());
			driver.switchTo().frame(sheet.getRow(11).getCell(2).toString());
			allClick(sheet.getRow(12).getCell(1).toString()).click();
		}catch(Exception e){
			throw new Exception("Error while Loading Iframe and Add button");
		}
	}
	
	public void dropDown()throws Exception{
		
		allClick(sheet.getRow(11).getCell(1).toString());
		driver.switchTo().frame("guestFrame");
		
		Select DropBP = new Select(allClick(sheet.getRow(17).getCell(1).toString()));
		int x = DropBP.getOptions().size();
		int y = new Random().nextInt(x);
		if(y==0)
			y=1;
		s();
		DropBP.selectByIndex(y);
		
	}
	
	
	
	
	public void integrationDetails()throws Exception{
		try{
			
			WebElement we = allClick(sheet.getRow(17).getCell(1).toString());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", we);
			
			
			
			String s = sheet.getRow(18).getCell(1).toString();
			String[] arr = s.split("\\n");
			int n = arr.length;
			int randomNum = new Random().nextInt(n);
			int se = 0;
			for (int i = 0; i <= randomNum; i++) {
				se = new Random().nextInt(n);
				if (arr[se].equals("1")) {
					--i;
					continue;
				}
				s();
				driver.findElement(By.xpath(arr[se])).click();
				s();
				arr[se] = "1";
			}
			
			
			we = allClick(sheet.getRow(19).getCell(1).toString());
			jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", we);
			
			
			driver.findElement(By.xpath(sheet.getRow(19).getCell(1).toString())).sendKeys(sheet.getRow(19).getCell(2).toString());
			
			while(true){
				try{
					driver.findElement(By.xpath(sheet.getRow(21).getCell(1).toString())).click();
					break;
				}catch(Exception e){
					driver.findElement(By.xpath(sheet.getRow(20).getCell(1).toString())).click();
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception("Error while selecting integration details");
		}
	}
	
	public void integrationDetailsManual() throws Exception{
		try{
			
			WebElement we = allClick(sheet.getRow(17).getCell(1).toString());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", we);
			
			
			
			String s = sheet.getRow(18).getCell(1).toString();
			String[] arr = s.split("\\n");
			int n = arr.length;
			int randomNum = new Random().nextInt(n);
			int se = 0;
			for (int i = 0; i <= randomNum; i++) {
				se = new Random().nextInt(n);
				if (arr[se].equals("1")) {
					--i;
					continue;
				}
				s();
				driver.findElement(By.xpath(arr[se])).click();
				s();
				arr[se] = "1";
			}
			
			
			we = allClick(sheet.getRow(19).getCell(1).toString());
			jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", we);
			
			
			driver.findElement(By.xpath(sheet.getRow(19).getCell(1).toString())).sendKeys(sheet.getRow(19).getCell(2).toString());
			
			while(true){
				try{
					driver.findElement(By.xpath(sheet.getRow(21).getCell(1).toString())).click();
					break;
				}catch(Exception e){
					driver.findElement(By.xpath(sheet.getRow(20).getCell(1).toString())).click();
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception("Error while selecting integration details");
		}
		
	}
	
	public void addIntegration()throws Exception{
		try{
			driver.findElement(By.xpath(sheet.getRow(22).getCell(1).toString())).click();
			allClick(sheet.getRow(23).getCell(1).toString()).click();
		}catch(Exception e){
			throw new Exception("Error while Adding Instance");
		}
	}
	
	public void deleteIntegration()throws Exception{
		try{
			allClick(sheet.getRow(24).getCell(1).toString()).click();
			allClick(sheet.getRow(25).getCell(1).toString()).click();
			driver.navigate().refresh();
			allClick(sheet.getRow(26).getCell(1).toString()).click();
			allClick(sheet.getRow(27).getCell(1).toString()).click();
		}catch(Exception e){
			throw new Exception("Error while Deleting Instance");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void s() throws Exception {
		Thread.sleep(2000);
	}

	public WebElement allClick(String xpath) {
		WebElement we = wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return we;
	}

}
