package com.eidiko.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.eidiko.integrations.Bitbucket;
import com.eidiko.integrations.Box;
import com.eidiko.integrations.Dropbox;
import com.eidiko.integrations.GitHub;
import com.eidiko.integrations.Mailchimp;
import com.eidiko.integrations.OneDrive;
import com.eidiko.integrations.Salesforce;
import com.eidiko.integrations.ServiceNow;
import com.eidiko.integrations.Trello;
import com.eidiko.integrations.Wunderlist;
import com.eidiko.integrations.Zendesk;


public class MainClass {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("ciscointegration.properties");
		prop.load(input);
		//System.setProperty("webdriver.gecko.driver",prop.getProperty("geckodriver"));
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver"));
		
		Bitbucket bitBucket = new Bitbucket(prop.getProperty("bitbucketfile"));
		Thread t1 =new Thread(bitBucket);  
		t1.start();
		
		OneDrive oneDrive = new OneDrive(prop.getProperty("onedrivefile"));
		Thread t2 =new Thread(oneDrive);  
		t2.start();
		
		Zendesk zenDesk = new Zendesk(prop.getProperty("zendeskfile"));
		Thread t3 =new Thread(zenDesk);  
		t3.start();
		
		Trello trello = new Trello(prop.getProperty("trellofile"));
		Thread t4 =new Thread(trello);  
		t4.start();
		
		Box box = new Box(prop.getProperty("boxfile"));
		Thread t5 =new Thread(box);  
		t5.start();
		
		Dropbox dropbox = new Dropbox(prop.getProperty("dropboxfile"));
		Thread t6 =new Thread(dropbox);  
		t6.start();
		
		GitHub gitHub = new GitHub(prop.getProperty("githubfile"));
		Thread t7 =new Thread(gitHub);  
		t7.start();
		
		Wunderlist wunderlist = new Wunderlist(prop.getProperty("wunderlistfile"));
		Thread t8 =new Thread(wunderlist);  
		t8.start();
		
		Mailchimp mailchimp = new Mailchimp(prop.getProperty("mailchimpfile"));
		Thread t9 =new Thread(mailchimp);  
		t9.start();
		
		ServiceNow serviceNow = new ServiceNow(prop.getProperty("servicenowfile"));
		Thread t10 =new Thread(serviceNow);  
		t10.start();
		
		Salesforce salesforce = new Salesforce(prop.getProperty("salesforcefile"));
		Thread t11 =new Thread(salesforce);  
		t11.start();
		
		
	}
}
