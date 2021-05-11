package Test;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RestAssuredTest {
    
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get validation")
    @Story("Get service")
    @Step("Verify get service")
    @Parameters()
    void getTest(){

        //Specify base URI
        RestAssured.baseURI = "https://httpbin.org/get";

        //Request object
        RequestSpecification httpGetRequest = RestAssured.given();

        //Response object
        Response response = httpGetRequest.request(Method.GET);

        //Print response in console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is " + responseBody);

        //
        System.out.println("================================");

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //
        System.out.println("================================");

        //Status line verification
        String statusLine = response.getStatusLine();
        System.out.println("StatusLine is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        System.out.println("================================");

    }
/*
    @Test
    void postTest(){

        //Specify base URI
        RestAssured.baseURI = "https://httpbin.org/post";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object

        JSONPObject requestParams = new JSONPObject();
        requestParams.put("FirstName","");
        requestParams.put("LastName","");
        requestParams.put("UserName","");
        requestParams.put("Password","");
        requestParams.put("Email","");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams,toJSONString());

        //Response object
        Response response = httpRequest.request(Method.POST);

        //Print response in console Window
        String responseBody = response.postBody().asString();
        System.out.println("Response Body is " + responseBody);
    }*/
}
