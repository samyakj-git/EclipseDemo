package Scripts.Demo.RestAssured;



import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;



import io.restassured.RestAssured;
import io.restassured.response.Response;
public class TestRunner {
	
	@Test
	public void MyFirstTest()
	{
		RestAssured.baseURI ="https://maps.googleapis.com";
		
		Response res = given()
		.param("input","+61293744000")
		.param("inputtype","phonenumber")
		.param("key","AIzaSyDrl7Qyos5Klo1KFzaEpzJlU5ym8P8dYCI").
		when().get("/maps/api/place/findplacefromtext/json").
		then().assertThat().statusCode(200).extract().response();
		System.out.println(res);
		String myStr = res.asString();
		System.out.println(myStr);
	}
}
