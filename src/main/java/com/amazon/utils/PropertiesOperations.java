package com.amazon.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 * 
 * June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 */
public class PropertiesOperations {

	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) {
		// 1. load data from properties file
		String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		/**
		 * Receives the {@link com.splitvision.govermaxx.enums.ConfigProperties},converts to lowercase , return the corresponding value
		 * for the key from the HashMap
		 * @author Vasanthakumar
		 * June 10, 2022
		 * @param key To be fetched from property file
		 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
		 */
		
		
		
		
		String value = prop.get(key).toString();

		if (StringUtils.isEmpty(value)) {
			try {
				throw new Exception("Value is not specified for key: " + key + " in properties file.");
			} catch (Exception e) {
			}
		}

		return value;
	}

}
