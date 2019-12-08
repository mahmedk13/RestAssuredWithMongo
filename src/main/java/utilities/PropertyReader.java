package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	
	private static PropertyReader propInstance;
	
	
	private PropertyReader() {
		
	}
	
	public static synchronized PropertyReader getInstance() {
		
		if(propInstance==null) {
			
			propInstance = new PropertyReader();
		}	
		return propInstance;	
	}
	
	
	/**
	 * Usage: To fetch property value from properties files
	 * @param propertyName
	 * @return propertyValue
	 */
	public String getProperty( String propertyName) {
		
		Properties prop = new Properties();
		
		try {
			
			FileInputStream fis = new FileInputStream(new File("./propertyfiles/testdata.properties"));
			
			prop.load(fis);
			
			if(prop.getProperty(propertyName) != null) {
				
				return prop.getProperty(propertyName);
			}
			
			
		}catch (Exception e) {
			
			System.out.println("Property not found");
		}
		
		return null;
	}

}

