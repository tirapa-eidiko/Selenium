package com.eidiko;

import java.util.Properties;

import com.eidiko.events.Pagerduty;
import com.eidiko.excel.ReadExcelData;

public class TriggerApps {
	public Properties prop;
	ReadExcelData xls;
	String screenshot;
	
	public TriggerApps(Properties prop){
		this.prop = prop;
	}
	public void startAutomation(){
		xls = new ReadExcelData(prop.getProperty("xcelfile"));
		
		Pagerduty pagerduty = new Pagerduty(prop, xls);
		Thread t1 = new Thread(pagerduty);
		t1.setName("PagerDuty");
		t1.start();
	}
}