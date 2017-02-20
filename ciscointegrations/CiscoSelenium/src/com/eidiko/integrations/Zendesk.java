package com.eidiko.integrations;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.common.CommonMethods;
import com.eidiko.common.RestCalls;

@SuppressWarnings({"resource","rawtypes"})
public class Zendesk  implements Runnable{
	WebDriver driver;
	WebDriverWait wdw;
	XSSFSheet sheet;
	CommonMethods cm;
	String sheetPath;
	
	public Zendesk(String sheetPath){
		this.sheetPath = sheetPath;
	}
	
	
	public void run(){
		try{
			zenDesk();
		}catch(Exception e){
			RestCalls rs = new RestCalls();
			rs.restCall(e.getMessage());
		}
		
	}
	
	
	public void zenDesk() throws Exception{
		//Loading firefox browser and Excel Sheet
		try{
			//driver = new FirefoxDriver();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			wdw = new WebDriverWait(driver, 60);
			sheet = getExcelSheet(sheetPath);
		}catch(Exception e){
			System.out.println(e.getMessage());
			driver.close();
		}

		cm = new CommonMethods(driver, wdw, sheet);
		
		
		//Login to depot page and open app specific page
		try{
			cm.loginToAppSpecificPage();
		}catch(Exception e){
			driver.close();
			throw new Exception("ZenDesk Exception : "+e.getMessage());
		}
		
		
		//Authenticate App with Cisco
		try{
			cm.clickConnect();
		}catch(Exception e){
			driver.close();
			throw new Exception("ZenDesk Exception : "+e.getMessage());
		}
		
		//Zendesk Domain Authorization
		try{
			domainAutherization();
		}catch(Exception e){
			throw new Exception("Zendesk Exception : Pop Error");
		}
		
		
		try{
			cm.integrationDetails();
		}catch(Exception e){
			throw new Exception("Zendesk Exception : Error While otification seletion");
		}
		
		
		//Integration details
		try{
			cm.addIntegration();
		}catch(Exception e){
			driver.close();
			throw new Exception("ZenDesk Exception : "+e.getMessage());
		}
		System.out.println("Add Integration");
		
		
		
		//Integration details
		try{
			cm.deleteIntegration();
		}catch(Exception e){
			driver.close();
			throw new Exception("ZenDesk Exception : "+e.getMessage());
		}
		System.out.println("Delete Integration");
		
		driver.close();
		
	}
	
	
	
	public void domainAutherization()throws Exception{
		cm.allClick(sheet.getRow(11).getCell(1).toString());
		driver.switchTo().frame(sheet.getRow(11).getCell(2).toString());
		
		cm.allClick(sheet.getRow(30).getCell(1).toString()).sendKeys(sheet.getRow(30).getCell(2).toString());
		driver.findElement(By.xpath(sheet.getRow(31).getCell(1).toString())).click();
		
		Set<String> windowId = driver.getWindowHandles();
		
		while(true){
			windowId = driver.getWindowHandles();
			if(windowId.size()==1)				
				continue;
			break;
		}
		Iterator itr = windowId.iterator();
		String parentWin = (String) itr.next();
		
		String childWindow = (String) itr.next();
		
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();

		Thread.sleep(10000);
		
		driver.switchTo().frame(0);
		
		
		cm.allClick(sheet.getRow(34).getCell(1).toString()).sendKeys(sheet.getRow(34).getCell(2).toString());
		
		cm.allClick(sheet.getRow(35).getCell(1).toString()).sendKeys(sheet.getRow(35).getCell(2).toString());
		
		cm.allClick(sheet.getRow(36).getCell(1).toString()).click();
		driver.switchTo().window(parentWin);
	}
	
	public XSSFSheet getExcelSheet(String excelSheet) throws Exception {
		return new XSSFWorkbook(new FileInputStream(excelSheet)).getSheetAt(0);
	}
}
