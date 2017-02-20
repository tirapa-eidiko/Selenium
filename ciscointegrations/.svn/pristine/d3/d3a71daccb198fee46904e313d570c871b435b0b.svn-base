package com.eidiko;

import java.util.Properties;

import com.eidiko.excel.ReadExcelData;
import com.eidiko.integrations.*;
import com.eidiko.util.Commons;

public class TriggerApps {
	public Properties prop;

	public TriggerApps(Properties prop) {
		this.prop = prop;
	}

	public void startAutomation() {
		ReadExcelData getExcelData = new ReadExcelData(
				prop.getProperty("commonfile"));
		Commons.setFile(getExcelData);

		if (prop.getProperty("runbitbucket").equals("true")) {
			Bitbucket bitBucket = new Bitbucket(prop);
			Thread t1 = new Thread(bitBucket);
			t1.setName("Bitbucket");
			t1.start();
		}
		if (prop.getProperty("runjira").equals("true")) {
			Jira jira = new Jira(prop);
			Thread t2 = new Thread(jira);
			t2.setName("Jira");
			t2.start();
		}
		if (prop.getProperty("runjenkins").equals("true")) {
			Jenkins jenkins = new Jenkins(prop);
			Thread t3 = new Thread(jenkins);
			t3.setName("Jenkins");
			t3.start();
		}
		if (prop.getProperty("runbox").equals("true")) {
			Box box = new Box(prop);
			Thread t4 = new Thread(box);
			t4.setName("Box");
			t4.start();
		}
		if (prop.getProperty("runsalesforce").equals("true")) {
			Salesforce salesforce = new Salesforce(prop);
			Thread t5 = new Thread(salesforce);
			t5.setName("Salesforce");
			t5.start();
		}
		if (prop.getProperty("runservicenow").equals("true")) {
			ServiceNow serviceNow = new ServiceNow(prop);
			Thread t6 = new Thread(serviceNow);
			t6.setName("ServiceNow");
			t6.start();
		}
		if (prop.getProperty("runnewrelic").equals("true")) {
			NewRelic newRelic = new NewRelic(prop);
			Thread t7 = new Thread(newRelic);
			t7.setName("NewRelic");
			t7.start();
		}
		if (prop.getProperty("runcodeship").equals("true")) {
			Codeship codeship = new Codeship(prop);
			Thread t8 = new Thread(codeship);
			t8.setName("Codeship");
			t8.start();
		}
		if (prop.getProperty("runpagerduty").equals("true")) {
			PagerDuty pagerDuty = new PagerDuty(prop);
			Thread t9 = new Thread(pagerDuty);
			t9.setName("PagerDuty");
			t9.start();
		}
		if (prop.getProperty("runzendesk").equals("true")) {
			Zendesk zendesk = new Zendesk(prop);
			Thread t10 = new Thread(zendesk);
			t10.setName("Zendesk");
			t10.start();
		}
		if (prop.getProperty("runasana").equals("true")) {
			Asana asana = new Asana(prop);
			Thread t11 = new Thread(asana);
			t11.setName("Asana");
			t11.start();
		}
		if (prop.getProperty("runonedrive").equals("true")) {
			OneDrive oneDrive = new OneDrive(prop);
			Thread t12 = new Thread(oneDrive);
			t12.setName("OneDrive");
			t12.start();
		}
		if (prop.getProperty("rungithub").equals("true")) {
			Docusign docusign = new Docusign(prop);
			Thread t13 = new Thread(docusign);
			t13.setName("GitHub");
			t13.start();
		}
		if (prop.getProperty("runwunderlist").equals("true")) {
			Papertrail papertrail = new Papertrail(prop);
			Thread t14 = new Thread(papertrail);
			t14.setName("Wunderlist");
			t14.start();
		}
		if (prop.getProperty("runtrello").equals("true")) {
			Trello trello = new Trello(prop);
			Thread t15 = new Thread(trello);
			t15.setName("Trello");
			t15.start();
		}
		if (prop.getProperty("rundocusign").equals("true")) {
			Docusign docusign = new Docusign(prop);
			Thread t16 = new Thread(docusign);
			t16.setName("Docusign");
			t16.start();
		}
		if (prop.getProperty("runpapertrail").equals("true")) {
			Papertrail papertrail = new Papertrail(prop);
			Thread t17 = new Thread(papertrail);
			t17.setName("Papertrail");
			t17.start();
		}
		if (prop.getProperty("runstripefile").equals("true")) {
			Stripe stripe = new Stripe(prop);
			Thread t18 = new Thread(stripe);
			t18.setName("Stripe");
			t18.start();
		}
		if (prop.getProperty("runuservoice").equals("true")) {
			Uservoice uservoice = new Uservoice(prop);
			Thread t19 = new Thread(uservoice);
			t19.setName("Uservoice");
			t19.start();
		}
		if (prop.getProperty("runxmatters").equals("true")) {
			Xmatters xmatters = new Xmatters(prop);
			Thread t20 = new Thread(xmatters);
			t20.setName("Xmatters");
			t20.start();
		}
		if (prop.getProperty("runsmartsheet").equals("true")) {
			Smartsheet smartsheet = new Smartsheet(prop);
			Thread t21 = new Thread(smartsheet);
			t21.setName("Smartsheet");
			t21.start();
		}

	}
}