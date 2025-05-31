package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Environments;

public class PropertiesUtil {

	public static String readProperty(Environments evn, String propertyName) {

		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir") + "//config//" + evn + ".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(file);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String value = properties.getProperty(propertyName.toUpperCase());
		return value;

	}

	public static String readProperty(String propertyName) {
		// Read the environment from system property (-Denv=prod/stage)
		String envName = System.getProperty("env", "stage").toUpperCase(); // default to stage
		Environments env = Environments.valueOf(envName);

		String filePath = System.getProperty("user.dir") + "//config//" + env.name().toLowerCase() + ".properties";
		Properties properties = new Properties();

		try (FileReader fileReader = new FileReader(filePath)) {
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			System.err.println("Property file not found for env: " + env);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error reading property file for env: " + env);
			e.printStackTrace();
		}

		return properties.getProperty(propertyName.toLowerCase());
	}

}
