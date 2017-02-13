package com.eidiko;

import java.util.Properties;

import com.eidiko.excel.ReadExcelData;
import com.eidiko.integrations.Bitbucket;
import com.eidiko.util.Commons;

public class TriggerApps {
	public Properties prop;
	
	public TriggerApps(Properties prop){
		this.prop = prop;
	}
	public void startAutomation(){
		ReadExcelData getExcelData = new ReadExcelData(prop.getProperty("commonfile"));
		Commons.setFile(getExcelData);
		Bitbucket bitBucket = new Bitbucket(prop);
		Thread t1 =new Thread(bitBucket);
		t1.setName("Bitbucket");
		t1.start();
	}
}