package fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertiesFiles(String key) throws Throwable {
	
		FileInputStream fis = new FileInputStream("./TestData/common.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String property = pobj.getProperty(key);
		
		return property;
	}

}
