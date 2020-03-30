package properties;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class PropertiesHelperTest {
	private static final Logger logger=Logger.getLogger(PropertiesHelperTest.class);
	private final Properties configProp=new Properties();
	private final Properties apiEndpoints= new Properties();
	
	private PropertiesHelperTest()
	{
		logger.debug("Read all properties from file");
		
		try { 
			//pass the path of properties files to a function and load it.
			   
			   FileInputStream configPropFile = getFileInputStream(
				System.getProperty("user.dir")+"/resources/config/Congif.properties");	
			
				if (configPropFile!=null) {	configProp.load(configPropFile);
				}
				logger.debug("Config file has been loaded");
				
				FileInputStream apiEndpoint = getFileInputStream(
				System.getProperty("user.dir")+"/resources/api/EndPoints.properties");	
				if (apiEndpoint!=null) {	apiEndpoints.load(apiEndpoint);
						}
						logger.debug("api Endpoint have been loaded");
		}
		catch(Exception e)
		{
			logger.error("Properties Helper IO Exception"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static class LazyHolder{
		private static final PropertiesHelperTest INSTANCE = new PropertiesHelperTest();
	
	}
	
	public static PropertiesHelperTest getInstance()
	{
		return LazyHolder.INSTANCE;
	}
	
	public String getConfigProperty(String key)
	{
		return configProp.getProperty(key);
	}
	
	public String getEndpointProperty(String key)
	{
		return apiEndpoints.getProperty(key);
	}
	public FileInputStream getFileInputStream(String filepath) {
		FileInputStream fileInputStream=null;
		
		try {
			fileInputStream = new FileInputStream(filepath);		
		}
		catch(Exception e)
		{
			logger.error("getFileInputStream() expception msg" +e.getMessage());
		}
		return fileInputStream;
	}
}
