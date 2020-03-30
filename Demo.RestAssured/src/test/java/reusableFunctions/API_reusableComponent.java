package reusableFunctions;

import org.testng.log4testng.Logger;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import properties.PropertiesHelperTest;
import static io.restassured.RestAssured.given;

public class API_reusableComponent {

	private static final Logger logger= Logger.getLogger(API_reusableComponent.class);
	public static Response response;
	public static Headers reqHeaders;
	public static PropertiesHelperTest loadprops=PropertiesHelperTest.getInstance();
	public static String apiEndpoint;
	
	public API_reusableComponent()
	{
		apiEndpoint = loadprops.getConfigProperty("api.baseURL"); 
		logger.debug("api end point" +apiEndpoint);
	}
	
	public boolean validateStatuscode(int expectedCode)
	{
		boolean flag=false;
		logger.debug("Actual status code:"+getStatusCode()+ ":Expected: "+ expectedCode);
		if(getStatusCode()==expectedCode)
		{
			flag=true;
		}
		return flag;
	}
	
	public Response initaiteRestAPICall(String url)
	{
		try {
			if(reqHeaders==null)
			{
				response=given().relaxedHTTPSValidation().when().get(url);
			}
			else
			{
				response = given().relaxedHTTPSValidation().headers(reqHeaders).when().get(url);
				}
		logger.debug("Json Response: "+  response.asString());
		}
		catch(Exception e)
		{
			response=null;
			logger.error("Intiate rest call exception message" + e.getMessage());
		}
		return response;
	} 
	
	public int getStatusCode()
	{
		return response.statusCode();
	}
	
	public Response getResponse()
	{
		return response;
	}
}

