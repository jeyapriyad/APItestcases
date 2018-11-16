package com.samsung.kidsplay;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.samsung.kidsplay.TestBase.FilePath;
import com.samsung.kidsplay.TestBase.payload;

//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrightcoveTest {
	
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
	public void brightcoveConfig() {
		 given().spec(spec).when().get("/brightcove/config").then().assertThat().statusCode(200)
        //.body("categories[0].name", equalTo("Top Picks"))
        //.body("categories[1].name", equalTo("Science & Nature"))
        .body("config.accountId", equalTo("5282994665001"))
        .body("config.policyKey", equalTo("BCpkADawqM1iU-GONy2Bg_cq9z732MLbgXDuOrg7N3KRvKOiS_qN05YD-MpqHaR6UjQBtZav1dUJWY4bZEuNXgj0npstFjMAN82ceSeysFEWuDoBwWzi6tAVXruN6xXEwJcLtLrUu5VK2LtL"));
           
	}

	@Test(priority=2)
	public void brightcoveSearch() {
	given().spec(spec).body(payload.search()).when().post("/brightcove/search").then().assertThat().statusCode(200);
		}
}       
	       
			                   
			                   
			       
	
	

