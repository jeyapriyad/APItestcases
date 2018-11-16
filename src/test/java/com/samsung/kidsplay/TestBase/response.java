package com.samsung.kidsplay.TestBase;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class response {
	
public static JsonPath rawToJson(Response resp) {
	//Converting the raw data to String 
		String response = resp.asString();
	//Converting the String into Json using JsonPath class
		JsonPath js = new JsonPath(response);
		return js;
}

}
