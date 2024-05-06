package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import models.enums.ProjectTypes;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostTestRailTest extends BaseApiTest {

    @Test
    public void getAllProjectsTest() {
        String endpoint = "index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectUsingStringTest() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_01");
        expectedProject.setAnnouncement("THis is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(ProjectTypes.SINGLE_SUITE_BASELINES);

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"announcement\": \"%s\",\n" +
                        "    \"show_announcement\": %b,\n" +
                        "    \"suite_mode\": %d\n" +
                        "}",
                        expectedProject.getName(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isShowAnnouncement(),
                        expectedProject.getSuiteMode()))
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectUsingMapTest() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_02");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(ProjectTypes.SINGLE_SUITE_BASELINES);

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", expectedProject.getName());
        jsonAsMap.put("announcement", expectedProject.getAnnouncement());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectUsingObjectTest() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_02");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(ProjectTypes.SINGLE_SUITE_BASELINES);

        given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectUsingObjectAndFakerTest() {
        String endpoint = "index.php?/api/v2/add_project";

        Faker faker = new Faker();

        Project expectedProject = new Project();
        expectedProject.setName(faker.company().name());
        expectedProject.setAnnouncement(faker.harryPotter().spell());
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(ProjectTypes.SINGLE_SUITE_BASELINES);

        given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectUsingFileTest() {
        String endpoint = "index.php?/api/v2/add_project";

        given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("data.json"))
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
