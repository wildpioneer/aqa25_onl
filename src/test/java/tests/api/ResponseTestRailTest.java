package tests.api;

import baseEntities.BaseApiTest;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.User;
import models.Users;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
                .body("limit", is(250))
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
                .body("offset", is(0))
                //.body("name", is(expectedUser.getName()))
                //.body("email", equalTo(expectedUser.getEmail()))
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

    @Test
    public void getTest1() {
        int userID = 1;

        Response response = given()
                .pathParam("user_id", userID)
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        response.then().log().body();
        Assert.assertEquals(response.getBody().jsonPath().getString("name"), "Alex Trostyanko");
        Assert.assertEquals(response.getBody().jsonPath().getInt("id"), 1);
    }

    @Test
    public void getAllUsersAsArray() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        //User[] actualUsersJ = response.as(User[].class); // Jeckson
        User[] actualUsersG = response.getBody().jsonPath().getObject("users", User[].class); // GSon

        Assert.assertTrue(actualUsersG[0].equals(expectedUser));
    }

    @Test
    public void getAllUsersAsObject() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Users users = given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Users.class);

        Assert.assertTrue(users.getUsers()[0].equals(expectedUser));
    }

    @Test
    public void getAllUsersAsType() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        List<User> actualUsersList = gson.fromJson(response.getBody().asString(), listType);
    }
}
