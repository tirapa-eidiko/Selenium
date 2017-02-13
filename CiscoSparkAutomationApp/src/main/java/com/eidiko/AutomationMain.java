package com.eidiko;

import java.util.Properties;

import com.eidiko.util.Logging;
import com.eidiko.util.PropertiesFile;


public class AutomationMain {
	public static void main(String[] args) {
		PropertiesFile propertiesFile = new PropertiesFile();
		Properties prop = propertiesFile.setProperties(args[0]);
		TriggerApps startHere = new TriggerApps(prop);
		Logging.logConfiguration(prop.getProperty("log"));
		startHere.startAutomation();
	}
}
