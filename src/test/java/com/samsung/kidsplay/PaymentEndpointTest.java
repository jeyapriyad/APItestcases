package com.samsung.kidsplay;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.samsung.kidsplay.TestBase.FilePath;
import com.samsung.kidsplay.TestBase.payload;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PaymentEndpointTest {
RequestSpecification spec;
    
    Properties prop = new Properties();
    
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream file = new FileInputStream(FilePath.PROPERTY_FILE_PATH);
		prop.load(file);
				
		spec = new RequestSpecBuilder()
			       .setContentType(ContentType.JSON)
			       .setBaseUri(prop.getProperty("BaseURI"))
			       .addFilter(new ResponseLoggingFilter())
			       .addFilter(new RequestLoggingFilter())
			       .build();
		
	}
	@Test(priority=1)
	public void getSubscriptionUsers() 
	{
	given().spec(spec).when().get("/subscriptions/users/{user_id}", "fp_b55e4ca2a4a047c4").then().assertThat().statusCode(200);
	}
	
	@Test(priority=2)
	public void updateSubscription() 
	{
	given().spec(spec).when().get("/updateSubscription/{user_id}", "fp_b55e4ca2a4a047c4").then().assertThat().statusCode(200);
	}
	
	@Test(priority=3)
	public void updateSubscriptionNext() 
	{
	given().spec(spec).body(payload.subscDetails()).when().post("/updateSubscriptionNext").then().assertThat().statusCode(200);
	}
	
	@Test(priority=4)
	public void getNextPayment() 
	{	
	 given().spec(spec).body(payload.NextPaymentDetails()).when().post("/userLogin").then().assertThat().statusCode(200);
    }
	
	@Test(priority=5)
	public void getPublishableStripeKey() 
	{
	given().spec(spec).when().get("/getPublishableStripeKey/{user_id}", "fp_b55e4ca2a4a047c4").then().assertThat().statusCode(200);
	}

	@Test(priority=6)
	public void getPublishableStripeKeyNext() 
	{
	given().spec(spec).when().get("/getPublishableStripeKeyNext/{user_id}", "fp_b55e4ca2a4a047c4").then().assertThat().statusCode(200);
	}

	//@Test(priority=6)
	//public void getPlans() 
	//{
	//given().spec(spec).when().get("/plans/{user_id}", "fp_b55e4ca2a4a047c4").then().assertThat().statusCode(200);
	//}
	
	@Test(priority=7)
	public void getPlans() 
	{
	given().spec(spec).when().get("/plans").then().assertThat().statusCode(200);
	}
	
	@Test(priority=8)
	public void getCatalogVersion() 
	{
	given().spec(spec).when().get("/catalogVersion").then().assertThat().statusCode(200);
	}
}
