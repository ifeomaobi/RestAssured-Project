package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Create_Or_Post_A_Product {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void create_A_Product() {
	
//		https://techfios.com/api-prod/api/product/create.php
		HashMap payload = new HashMap();
		payload.put("name", "YSL handbag");
		payload.put("description", "The best luxury handbags");
		payload.put("price", "2599");
		payload.put("category_id", "2");
		Response response=
		
	given()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
		.body(payload)
	.when()
		.post("/create.php")
	.then()
		.extract().response();
		
		
//	int statusCode = response.getStatusCode();
//	System.out.println("Status Code: " + statusCode);
////	Assert.assertEquals(statusCode, 201);
//	softAssert.assertEquals(statusCode, 201);
	
	String responseBody = response.getBody().asString();
	System.out.println("responseBody: " + responseBody);
			
	
//	parsing responseBody to Json:
	JsonPath js = new JsonPath(responseBody);
//	Assert.assertEquals(actual, expected, message);
//	
//	String productId = js.getString("id");
//	String productname = js.get("name");
//	String productDescription = js.getString("description");
//	Assert.assertEquals(productId, "1158");
//	Assert.assertEquals(productname, "1158");
//	Assert.assertEquals(productDescription, "1158");
//	
//	long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//	System.out.println("Respnse Time: " + responseTime);
//	if(responseTime<=2000) {
//		System.out.println("Response time is within the range");
//	}else {
//			System.out.println("Not acceptable!!");
//	}
//		
	}

}
