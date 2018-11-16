package com.samsung.kidsplay.TestBase;

public class payload {
	
 static String emailid = "samsungkids25@gmail.com";
		
public static String registerUserDetails()
{
	String det = "{"+
			"\"email_id\":\""+emailid+"\","+
			"\"password\": \"Welcome123\" "+
			"}" ;
	return det;
	
}

public static String secretDetails()
{
	String sec = "{"+
			"\"email_id\":\""+emailid+"\","+
			"\"secret\": \"thankyou\" "+
			"}" ;
	return sec;
	
}
public static String changePwdDetails()
{
	String pwd = "{"+
			"\"email_id\":\""+emailid+"\","+
			"\"secret\": \"thankyou\" "+
			"}" ;
	return pwd;
	
}
public static String emailDetails()
{
	String md = "{" + 
			"\"email_id\": \""+emailid+"\"" + 
			"}";
	return md;
	
}
public static String changeemailDetails()
{
	String emd = "{"+
			"\"old_email_id\":\""+emailid+"\","+
			"\"new_email_id\": \"samsungkids16@gmail.com\" "+
			"}";
	return emd;
	
}

public static String emailSupportDetails()
{
	String ems = "{"+
			"\"user_id\":\"fp_b55e4ca2a4a047c4\","+
			"\"subject\": \"Test message\","+
			"\"body\": \"This is a Test message\" "+
			"}";
	
	return ems;
}

public static String NextPaymentDetails()
{
	String npd = "{"+
			 "\"user_id\": \"b649b1bdf61295ee\","+
			 "\"plan\": \"monthly\","+
			 "\"coupon\": \"100PERCENTOFF12MOv2\","+
			 "\"address_zip\": \"94538\","+
			 "\"address_state\": \"CA\","+
			 "\"address_country\": \"US\" "+
				"}" ;
	return npd;			
}
public static String search()
{
String src = "{"+
		"\"query\":\"user_id\","+
		"\"limit\": \"10\","+
		"\"offset\": \"0\","+
		"\"sort\": \"Ascending\" "+
		"}" ;
return src;
}
public static String getGoogleID()
{
String gid = "{"+
		 "\"token\": \"ga__sYWMAi27zJjyX4OS\" "+
			"}"  ;
return gid;
}

public static String subscDetails()
{
	String sd = "{"+
			"\"plan\": \"monthly\","+
			"\"coupon\": \"SRBD1MTEST\" "+
			"}" ;
	return sd;
}

public static String syncDetails()
{
	String sync = "{"+
			  "\"appVersions\": "+
			   "{" +
	    "\"APK\": "+
	    "{" +
	     "\"versionCode\": 1 ," +
	     "\"versionName\": \" 1.9.1 r1 \" "+
	    "}" +
	  "},"+
	  "\"sso\": "+
	  "{"+
	    "\"user_id\": \"fp_495a2bd5963f4bf0\"," +
	    "\"email_id\": \"mnc@abc.com\""+
	 " },"+
	  "\"pin\": \"1234\","+
	  "\"localPin\": \"1234\","+
	  "\"device\": "+
	   "{"+
	    "\"device_id\": \"ee0e09140ce508c1\","+
	    "\"serial\": \"9887a8455a4e45564b\","+
	    "\"model\": \"SM-G950U\","+
	    "\"manufacturer\": \"samsung\","+
	    "\"operator_name\": \"\"," +
	    "\"operator_code\": \"\","+
	    "\"sales_code\": \"USC\","+
	    "\"product_code\": \"SM-G950UZKAUSC\","+
	    "\"boot_carrierid\": \"USC\","+
	    "\"carrierid\": \"USC\","+
	    "\"carrier\": \"unknown\","+
	    "\"boot_sales_code\": \"USC\""+
	  "},"+
	  "\"appsflyerUID\": \"1533760395283-212544540304767576\","+
	  "\"territory\": \"US\","+
	  "\"partner\": \"samsung\","+
	  "\"kids\": [ "+
	    "{"+
	     "\"name\": \"234\","+
	      "\"age\": 5,"+
	      "\"avatar\": \" \","+
	      "\"photoId\": 0,"+
	      "\"bTotalLimitEnabled\": true,"+
	      "\"bFunVideosLocked\": false,"+
	      "\"totalLimit\": 495,"+
	      "\"gamesLimit\": 495,"+
	     "\"booksLimit\": 495,"+
	      "\"videosLimit\": 495,"+
	     "\"recentlyWatchedVids\": [] ,"+
	     "\"id\": \"ac77e8cb-7d24-3ba-cfbf-429c345b74d6\","+
	      "\"filterAgeMin\": 4,"+
	      "\"filterAgeMax\": 6,"+
	     "\"filterSubjects\": [ "+
	        "\"math\","+
	        "\"social-studies\","+
	        "\"critical-thinking\","+
	        "\"language-arts\","+
	        "\"science\","+
	        "\"creativity\" "+
	      "],"+
	      "\"filterMediaTypes\": ["+
	        "\"game\","+
	       "\"book\" "+
	      "],"+
	     "\"whitelistedPackages\": [],"+
	     "\"t\": 1533760846.636"+
	    "}"+
	 " ],"+
	  "\"deletedKids\": [],"+
	 "\"sessions\": {"+
	    "\"latest\": {} ,"+
	    "\"updates\": [] "+
	 " },"+
	  "\"clientTime\": 1533760904.402,"+
	  "\"onboarding_state\": \"complete\","+
	"}";
	return sync;
}

}
