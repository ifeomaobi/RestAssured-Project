package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_Or_Read_All_Products {
	
	@Test
	public void read_All_Productes() {
	
//		https://techfios.com/api-prod/api/product
		Response response=
		
	given()
//		.log().all() is used to get a log when you run the program
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
	.when()
//		.log().all()
		.get("/read.php")
	.then()
//		.log().all()
		.statusCode(200)
		.extract()
		.response();
		
		
	int statusCode = response.getStatusCode();
	System.out.println("Status Code:" + statusCode);
	Assert.assertEquals(statusCode, 200);
	
	String responseBody = response.getBody().asString();
	System.out.println(responseBody);
	}

}
