package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredSimpleTest {

    @Test
    public void simpleStepByStepGetApiTest() {
        // Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        // Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        // Setup request Object
        RequestSpecification request = given();

        // Setup response and execute request
        Response response = request.request(Method.GET, endpoint);

        // Validate response
        // Get and check status code
        int statusCode = response.getStatusCode();
        System.out.println("StatusCode " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void simpleShortGetApiTest() {
        // Setup endpoint
        int userID = 2;
        String endpoint = "https://reqres.in/api/users/" + userID;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
