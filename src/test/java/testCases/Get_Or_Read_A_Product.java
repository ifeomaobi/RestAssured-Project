package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Get_Or_Read_A_Product {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void read_All_Productes() {
	
//		https://techfios.com/api-prod/api/product/read_one.php?id=1158
		Response response=
		
	given()
//		.log().all() is used to get a log when you run the program
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
		.queryParam("id", "1158")
	.when()
//		.log().all()
		.get("read_one.php?id=1158")
	.then()
//		.log().all()
		.statusCode(200)
		.extract()
		.response();
		
		
	int statusCode = response.getStatusCode();
	System.out.println("Status Code: " + statusCode);
//	Assert.assertEquals(statusCode, 201);
	softAssert.assertEquals(statusCode, 201);
	
	String responseBody = response.getBody().asString();
	System.out.println(responseBody);
	
//	parsing responseBody to Json:
	JsonPath js = new JsonPath(responseBody);
	
	String productId = js.getString("id");
	String productname = js.get("name");
	String productDescription = js.getString("description");
	
	Assert.assertEquals(productId, "1158");
	Assert.assertEquals(productname, "YSL handbag");
	Assert.assertEquals(productDescription, "The best luxury handbags.");
	
	long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
	System.out.println("Respnse Time: " + responseTime);
	if(responseTime<=2000) {
		System.out.println("Response time is within the range");
	}else {
			System.out.println("Not acceptable!!");
	}
		
	}

}
