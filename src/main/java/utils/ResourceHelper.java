package utils;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;


public class ResourceHelper {

    public static ResponseBody post( String endPoint, String payload) {
        ResponseBody response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(payload)
                .post(endPoint).andReturn().then().statusCode(200).extract().response().getBody();

        return response;

    }

    public static void get(String endPoint) {
        given()
                .when()
                .get(endPoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
