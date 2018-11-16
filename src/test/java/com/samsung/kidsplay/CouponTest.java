package com.samsung.kidsplay;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.samsung.kidsplay.TestBase.FilePath;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class CouponTest {

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
	public void couponCode() 
	{
	given().spec(spec).when().get("/exists/{code}","SRBD1MTEST").then().assertThat().statusCode(200);
	}
	
	@Test(priority=2)
	public void couponID() 
	{
	given().spec(spec).when().get("/exists/{code}/{user_id}","SRBD1MTEST","b649b1bdf61295ee").then().assertThat().statusCode(200);
	}
	
	@Test(priority=3)
	public void couponIDCountry() 
	{
	given().spec(spec).when().get("/exists/{code}/{user_id}/{country}","SRBD1MTEST","b649b1bdf61295ee","US").then().assertThat().statusCode(200);
	}
}
