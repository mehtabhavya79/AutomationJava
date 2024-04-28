package com.twitter.utillity;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	public static Properties properties;

	public static void loadProperties() throws IOException {
		String filePath = "G:\\Testing\\Automation\\Twitter\\src\\main\\resources\\testData.properties";

		File file = new File(filePath);
		FileReader filereader = new FileReader(file);
		properties = new Properties();
		properties.load(filereader);

	}
}
