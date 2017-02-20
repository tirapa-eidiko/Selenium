package com.eidiko.integrations;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eidiko.common.CommonMethods;
import com.eidiko.common.RestCalls;

@SuppressWarnings("resource")
public class Salesforce implements Runnable {

	WebDriver driver;
	WebDriverWait wdw;
	XSSFSheet sheet;
	CommonMethods cm;
	String sheetPath;

	public Salesforce(String sheetPath) {
		this.sheetPath = sheetPath;
	}

	public void run() {
		try {
			salesforce();
		} catch (Exception e) {
			RestCalls rs = new RestCalls();
			rs.restCall(e.getMessage());
		}

	}

	public void salesforce() throws Exception {

		// Loading firefox browser and Excel Sheet
		try {
			//driver = new FirefoxDriver();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			wdw = new WebDriverWait(driver, 60);
			sheet = getExcelSheet(sheetPath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			driver.close();
		}

		cm = new CommonMethods(driver, wdw, sheet);

		// Login to depot page and open app specific page
		try {
			cm.loginToAppSpecificPage();
		} catch (Exception e) {
			driver.close();
			throw new Exception("salesforce Exception : " + e.getMessage());
		}

		// Authenticate App with Cisco
		try {
			cm.clickConnect();
		} catch (Exception e) {
			driver.close();
			throw new Exception("salesforce Exception : " + e.getMessage());
		}

		// Integration details
		try {
			cm.dropDown();
			cm.integrationDetails();
		} catch (Exception e) {
			driver.close();
			throw new Exception("salesforce Exception : " + e.getMessage());
		}
		System.out.println("Integration Details");

		// Integration details
		try {
			cm.addIntegration();
		} catch (Exception e) {
			driver.close();
			throw new Exception("salesforce  Exception : " + e.getMessage());
		}
		System.out.println("Add Integration");

		// Integration details
		try {
			cm.deleteIntegration();
		} catch (Exception e) {
			driver.close();
			throw new Exception("salesforce  Exception : " + e.getMessage());
		}
		System.out.println("Delete Integration");

		driver.close();
	}

	public void authenticateIntegration() throws Exception {
		try {
			driver.switchTo().defaultContent();
			cm.allClick(sheet.getRow(13).getCell(1).toString()).sendKeys(
					sheet.getRow(13).getCell(2).toString());
			cm.allClick(sheet.getRow(15).getCell(1).toString()).sendKeys(
					sheet.getRow(15).getCell(2).toString());
			System.out.println(sheet.getRow(16).getCell(1).toString());
			cm.allClick(sheet.getRow(16).getCell(1).toString()).click();
		} catch (Exception e) {
			throw new Exception("OAuth Authuntication Failure");
		}
	}

	public XSSFSheet getExcelSheet(String excelSheet) throws Exception {
		return new XSSFWorkbook(new FileInputStream(excelSheet)).getSheetAt(0);
	}
}
