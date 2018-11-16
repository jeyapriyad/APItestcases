package com.samsung.kidsplay;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.samsung.kidsplay.TestBase.FilePath;
import com.samsung.kidsplay.TestBase.ValidationUtils;

public class SchemaValidationTest {
	Properties prop = new Properties();
	
	@BeforeTest
	public  void initSpec() throws IOException{
		FileInputStream file = new FileInputStream(FilePath.JSONSCHEMA);
		prop.load(file);
		FileInputStream file1 = new FileInputStream(FilePath.DATA);
		prop.load(file1);
		//FileInputStream file2 = new FileInputStream(FilePath.INVALDATA);
		//prop.load(file2);
	}
	
	@Test
	public void validation() throws ProcessingException, IOException
	{
	    File schemaFile = new File("C:\\Users\\j.ganesan\\Downloads\\samsungkids\\schema.json");
	    File jsonFile = new File("C:\\Users\\j.ganesan\\Downloads\\samsungkids\\data.json");
	    //File jsonFile = new File("C:\\Users\\j.ganesan\\Downloads\\samsungkids\\invalidata.json");
	    	
	    if (ValidationUtils.isJsonValid(schemaFile, jsonFile)){
	    	System.out.println("JSON Schema and Response data matches");
	    }else{
	    	System.out.println("Response doesn't match with the JSON schema");
	    }
	}
	
}
