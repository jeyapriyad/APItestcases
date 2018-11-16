package com.samsung.kidsplay;

import static io.restassured.RestAssured.given;

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

public class CheckEndPointTest {

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
	public void checkUpdate() 
	{
	given().spec(spec).when().get("/checkUpdate/{version}","10").then().assertThat().statusCode(200);
	}

	@Test(priority=2)
	public void checkUpdateFrom() 
	{
	given().spec(spec).when().get("/checkUpdateFrom/{current}/{version}","10","1").then().assertThat().statusCode(200);
	}
	
	@Test(priority=3)
	public void clientUpdate() 
	{
	given().spec(spec).when().get("/checkClientUpdate/package/{clientPackageName}/currentVersion/{currentVersion}","com.samsung.kidsplay","1").then().assertThat().statusCode(200);
	}
	
	@Test(priority=4)
	public void QAEnabled() 
	{
	given().spec(spec).when().get("/isQAEnabled/{device_id}", "355989080553345").then().assertThat().statusCode(200);
	}
	
	@Test(priority=5)
	public void useQAHub() 
	{
	given().spec(spec).when().get("/useQAHub/{device_id}/{bEnable}","355989080553345","true").then().assertThat().statusCode(200);
	}
	
	@Test(priority=6)
	public void clearSession() 
	{
	given().spec(spec).when().get("/qaEnabledClearSessions/{user_id}/{device_id}","fp_b55e4ca2a4a047c4","355989080553345").then().assertThat().statusCode(200);
	}
	
	@Test(priority=7)
	public void exists() 
	{
	given().spec(spec).when().get("/exists/{user_id}/{device_id}","fp_b55e4ca2a4a047c4","355989080553345").then().assertThat().statusCode(200);
	}
}
