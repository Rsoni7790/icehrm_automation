package icehrm_automation;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHandling {
	
	Properties properties;
	public PropertyHandling()
	{
		try {String filePath=System.getProperty("user.dir")+"/config.properties";
		      FileInputStream inputstream=new FileInputStream(filePath);
		      properties=new Properties();
		      properties.load(inputstream);
		    }
		catch(Exception e)
		{
		throw new RuntimeException(e);	
		}
	}
	public String getPropertys(String key)
	{
	String value=properties.getProperty(key);
	System.out.println(value);
	return value;
		}

}
