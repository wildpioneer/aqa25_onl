package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ResponseTestRailTest extends BaseApiTest {

    @Test
    public void getAllProjectsTest() {
        String endpoint = "index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .body("get(0).limit", is(250))
                .statusCode(HttpStatus.SC_OK);
    }



    @Test
    public void getAllUsers() {
        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .body("name", is(expectedUser.getName()))
                .body("email", equalTo(expectedUser.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getTest() {
        int userID = 1;

        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUser = given()
                .pathParam("user_id", userID)
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class, ObjectMapperType.GSON);

        System.out.println(actualUser.toString());
        Assert.assertTrue(expectedUser.equals(actualUser));
    }
}
