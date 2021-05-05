package com.test.pet.ApiTestCases;

import dataCreationFromModel.UserDataCreator;
import dataModel.UserPojo;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Properties;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserAPITestCase extends BaseTest {
    public static List<UserPojo> listOfUser;
    String username = "";

    @Test(priority = 0)
    public void createListOfUser() {
        /*
         * Create a pojo class for the request
         * Create a object and init all class variables using constructor
         * Pass that in the body of the request
         */
        UserDataCreator us = new UserDataCreator();
        listOfUser = us.createUser(5);
        Response response = given()
                .filter(new RequestLoggingFilter(captor)) //This line is mandatory to log the request details to extent report
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(listOfUser) //passing obj in request body
                .post(Properties.createMultipleUserEndPoint); //posting request
        response.prettyPrint();

//        // Assert status code
        response.then().statusCode(200);
        //this will work if you run the test case through xml file if you are running the test case through class then comment this line

        writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());


    }

    @Test(dependsOnMethods = "createListOfUser", priority = 1)
    public void updateUserDetail() {
        UserDataCreator us = new UserDataCreator();
        UserPojo user = us.DataForUSerCreation();
        username = user.getUsername();
        Response response = given()
                .filter(new RequestLoggingFilter(captor)) //This line is mandatory to log the request details to extent report
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(user) //passing obj in request body
                .put(String.format("/user/%s", listOfUser.get(0).getUsername())); //posting request
        response.prettyPrint();
        // Assert status code
        response.then().statusCode(400);
        //this will work if you run the test case through xml file if you are running the test case through class then comment this line
        // writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());
    }

    @Test(dependsOnMethods = "updateUserDetail", priority = 2)
    public void getUserDetail() {
        System.out.println(username);
        Response response = given()
                .filter(new RequestLoggingFilter(captor)) //This line is mandatory to log the request details to extent report
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get(String.format("/user/%s", username)); //posting request
        //response.prettyPrint();

        //this will work if you run the test case through xml file if you are running the test case through class then comment this line
        // writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());

        // Assert status code
        //  response.then().statusCode(200);


        Assert.assertEquals(200, response.getStatusCode());
    }
}