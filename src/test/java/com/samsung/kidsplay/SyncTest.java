package com.samsung.kidsplay;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.samsung.kidsplay.TestBase.FilePath;
import com.samsung.kidsplay.TestBase.payload;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class SyncTest {
	
	RequestSpecification spec;
	Properties prop = new Properties();
		
	@BeforeTest
	public  void initSpec() throws IOException{
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
	public void sync() {
	given().spec(spec).body(payload.syncDetails()).when().post("/sync").then().assertThat().statusCode(200);
		}

}
