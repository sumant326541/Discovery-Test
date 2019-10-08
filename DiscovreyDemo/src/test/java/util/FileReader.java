package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
	
	public String reader(String key)
	{
		Properties prop = new Properties();

try {
	
    prop.load(new FileInputStream("src\\test\\java\\config\\config.properties"));  
	} catch (IOException e) {
    e.printStackTrace();
	}
return prop.getProperty(key);
		    
	}
	

}
