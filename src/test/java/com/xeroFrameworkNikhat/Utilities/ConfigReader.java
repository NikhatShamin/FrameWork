package com.xeroFrameworkNikhat.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties pro;

	// This Method Reads data from Config .properties file
	public ConfigReader(String path) {

		File src = new File(path);

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {

			System.out.println("Not able to find Config Data " + e.getMessage());

		}

	}

	// This Method returns Data for the key parameter
	public String getDataFromConfig(String key) {
		return pro.getProperty(key);
	}

}
