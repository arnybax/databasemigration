package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	Properties properties = new Properties();
	
	public PropertiesReader(){
		BufferedInputStream stream = null;
		try {
			stream = new BufferedInputStream(getClass().getResourceAsStream("/application.properties"));
			properties.load(stream);
			stream.close();
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public String getUser(){
		return properties.getProperty("user");
	}

	public String getPwd(){
		return properties.getProperty("pwd");
	}

	public String getUrl(){
		return properties.getProperty("url");
	}
}
