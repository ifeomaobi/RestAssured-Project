package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Delete_A_Product {
	
	SoftAssert softAssert = new SoftAssert();
	
	
	@Test
	public void delete_A_Product() {
	
//		https://techfios.com/api-prod/api/product/delete.php
		HashMap payload = new HashMap();
		payload.put("id", "1293");
//		payload.put("name", "YSL Envelope large handbag");
//		payload.put("description", "The best luxury handbag designer");
//		payload.put("price", "2650");
//		payload.put("category_id", "1");
		Response response=
		
	given()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
		.body(payload)
	.when()
		.delete("/delete.php")
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
	
//	String message = js.getString("message");
//	
//	softAssert.assertEquals(message, "Product was deleteed.", "Not matching the assertions!!!");
//	
//	softAssert.assertAll();
//	Assert.assertEquals(actual, expected, message);
	
//	softAssert.assertEquals(actual, expected, message);
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
