package com.samsung.kidsplay;
import org.testng.annotations.BeforeTest;
import com.samsung.kidsplay.TestBase.payload;
import org.testng.annotations.Test;

import com.samsung.kidsplay.TestBase.FilePath;
import com.samsung.kidsplay.TestBase.response;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDetailsTest {
	String userid; //Global variable
	 
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
	public void registerUser() {
     Response resp = (Response) given()
     .spec(spec)
     .body(payload.registerUserDetails())
     .when()
	.post("/registerUser")
	.then().assertThat().statusCode(200)
    .extract().response();
	JsonPath js = response.rawToJson(resp);
		
	//Grabbing the user ID from the response and storing in global variable for subsequent TC use
	userid = js.get("user_id");
	System.out.println("User ID is " + userid);

}
	
	@Test(priority=2)
	public void userLogin() {
		
	 given()
	.spec(spec)
	.body(payload.registerUserDetails())
	.when()
	.post("/userLogin")
	.then().assertThat().statusCode(200);
    }

	@Test(priority=3)
	public void verifySecret() {
		
	 given()
	.spec(spec)
	.body(payload.secretDetails())
	.when()
	.post("/verifySecret")
	.then().assertThat().statusCode(200);
    }

	@Test(priority=4)
	public void changePassword() {
		
	 given()
	.spec(spec)
	.body(payload.changePwdDetails())
	.when()
	.post("/changePassword")
	.then().assertThat().statusCode(200);
    }

	@Test(priority=5)
	public void forgotPassword() {
	
	given()
	.spec(spec)
	.body(payload.emailDetails())
	.when()
	.post("/forgotPassword")
	.then().assertThat().statusCode(200);
	}

	@Test(priority=6)
	public void forgotPasswordResend() {
	
	given()
	.spec(spec)
	.body(payload.emailDetails())
	.when()
	.post("/forgotPasswordResend")
	.then().assertThat().statusCode(200);
	}

	@Test(priority=7)
	public void changeEmail() {
	
    given()
    .spec(spec)
    .body(payload.changeemailDetails())
	.when()
	.post("/changeEmail")
	.then().assertThat().statusCode(200);
	}
    
	@Test(priority=8)
	public void forgotPIN() {
    
	given()
	.spec(spec)
	.when()
	.get("/forgotPIN/{device_id}", "b649b1bdf61295ee")
	.then().assertThat().statusCode(200);
	}

	@Test(priority=9)
	public void getPublishableStripeKey() {
	
	given()
	.spec(spec)
	.when()
	.get("/getPublishableStripeKey/{user_id}", userid)
	.then().assertThat().statusCode(200);
	}

	@Test(priority=10)
	public void getPublishableStripeKeyNext() {
	
	given()
	.spec(spec)
	.when()
	.get("/getPublishableStripeKeyNext/{user_id}", userid)
	.then().assertThat().statusCode(200);
	}
	@Test(priority=11)
	public void userExist() {
	
	given()
	.spec(spec)
	.when()
	.get("/exists/{user_id}/{device_id}",userid,"b649b1bdf61295ee")
	.then().assertThat().statusCode(200);
	}
	@Test(priority=12)
	public void getPauseState() {
	 given()
	.spec(spec)
	.when()
	.post("/exists/{user_id}/{device_id}",userid,"b649b1bdf61295ee")
	.then().assertThat().statusCode(200);
	}
	
}