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
public class Trello implements Runnable {

	WebDriver driver;
	WebDriverWait wdw;
	XSSFSheet sheet;
	CommonMethods cm;
	String sheetPath;

	public Trello(String sheetPath) {
		this.sheetPath = sheetPath;
	}

	public void run() {
		try {
			trello();
		} catch (Exception e) {
			RestCalls rs = new RestCalls();
			rs.restCall(e.getMessage());
		}

	}

	public void trello() throws Exception {

		// Loading firefox browser and Excel Sheet
		try {
			// driver = new FirefoxDriver();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			wdw = new WebDriverWait(driver, 60);
			sheet = getExcelSheet(sheetPath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			driver.close();
			// System.exit(0);
		}

		cm = new CommonMethods(driver, wdw, sheet);

		// Login to depot page and open app specific page
		try {
			cm.loginToAppSpecificPage();
		} catch (Exception e) {
			driver.close();
			throw new Exception("Trello Exception : " + e.getMessage());
		}

		// Authenticate App with Cisco
		try {
			cm.clickConnect();
		} catch (Exception e) {
			driver.close();
			throw new Exception("Trello Exception : " + e.getMessage());
		}

		// Click Add button
		try {
			cm.clickAddButton();
		} catch (Exception e) {
			driver.close();
			throw new Exception("Trello Exception : " + e.getMessage());
		}
		System.out.println("Trello Click Add Button");

		// Click Login button
		try {
			// click Login button
			// cm.allClick(sheet.getRow(31).getCell(1).toString());
			// driver.switchTo().frame(sheet.getRow(31).getCell(2).toString());
			driver.switchTo().defaultContent();
			cm.allClick(sheet.getRow(29).getCell(1).toString()).click();
		} catch (Exception e) {
			throw new Exception("Trello Exception :" + e.getMessage());
		}
		System.out.println("Trello Click Login Button");

		// Enter the Username
		try {
			// Enter the Username
			// cm.allClick(sheet.getRow(30).getCell(1).toString());
			// driver.switchTo().frame(sheet.getRow(31).getCell(2).toString());
			System.out.println(sheet.getRow(13).getCell(1).toString());
			cm.allClick(sheet.getRow(13).getCell(1).toString()).sendKeys(
					sheet.getRow(13).getCell(2).toString());
			;
		} catch (Exception e) {
			throw new Exception("Trello Exception :" + e.getMessage());
		}
		System.out.println("Username is entered for Trello");

		// Enter the password
		try {
			// Enter the Passowrd
			// cm.allClick(sheet.getRow(14).getCell(1).toString());
			// driver.switchTo().frame(sheet.getRow(31).getCell(2).toString());
			System.out.println(sheet.getRow(13).getCell(1).toString());
			cm.allClick(sheet.getRow(15).getCell(1).toString()).sendKeys(
					sheet.getRow(15).getCell(2).toString());
			;
		} catch (Exception e) {
			throw new Exception("Trello Exception :" + e.getMessage());
		}
		System.out.println("Password is Entered for Trello");

		// login button is clicked

		try {
			// login button is clicked
			// cm.allClick(sheet.getRow(17).getCell(1).toString());
			// driver.switchTo().frame(sheet.getRow(17).getCell(2).toString());
			driver.switchTo().defaultContent();
			cm.allClick(sheet.getRow(30).getCell(1).toString()).click();
		} catch (Exception e) {
			throw new Exception("Trello Exception :" + e.getMessage());
		}
		System.out.println("login button is clicked");

		// Allow button is clicked

		try {
			// login button is clicked
			// cm.allClick(sheet.getRow(30).getCell(1).toString());
			// driver.switchTo().frame(sheet.getRow(17).getCell(2).toString());
			driver.switchTo().defaultContent();
			cm.allClick(sheet.getRow(31).getCell(1).toString()).click();
		} catch (Exception e) {
			throw new Exception("Trello Exception :" + e.getMessage());
		}
		System.out.println("Allow Button is clicked");

		// Trello Authentication
		/*
		 * try{ authenticateIntegration(); }catch(Exception e){ driver.close();
		 * throw new Exception("Trello Exception : "+e.getMessage()); }
		 * System.out.println("Trello Authentication");
		 */

		// Integration details
		try {
			cm.dropDown();
			cm.integrationDetails();
		} catch (Exception e) {
			driver.close();
			throw new Exception("Trello Exception : " + e.getMessage());
		}
		System.out.println("Integration Details");

		// Integration details
		try {
			cm.addIntegration();
		} catch (Exception e) {
			driver.close();
			throw new Exception("BitBucket Exception : " + e.getMessage());
		}
		System.out.println("Add Integration");

		// Integration details
		try {
			cm.deleteIntegration();
		} catch (Exception e) {
			driver.close();
			throw new Exception("Trello Exception : " + e.getMessage());
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
			cm.allClick(sheet.getRow(16).getCell(1).toString()).click();
		} catch (Exception e) {
			throw new Exception("OAuth Authuntication Failure");
		}
	}

	public XSSFSheet getExcelSheet(String excelSheet) throws Exception {
		return new XSSFWorkbook(new FileInputStream(excelSheet)).getSheetAt(0);
	}
}
