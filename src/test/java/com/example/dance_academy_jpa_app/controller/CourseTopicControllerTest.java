package com.example.dance_academy_jpa_app.controller;

import com.example.dance_academy_jpa_app.domain.CourseTopic;
import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import com.example.dance_academy_jpa_app.repositories.CourseTopicRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseTopicControllerTest {

    @Autowired
    CourseTopicRepository courseTopicRepository;

    @Autowired
    CourseTopicController courseTopicController;

    @LocalServerPort
    private Integer port;

    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(
            "mysql:9.0.1"
    );

    @BeforeAll
    static void beforeAll() {
        mySQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        mySQLContainer.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    private final String API = "/api/courseTopics";

    CourseTopic first = CourseTopic.builder()
            .name("test1")
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .createdBy("test1")
            .lastModifiedBy("test1")
            .build();

    CourseTopic second = CourseTopic.builder()
            .name("test2")
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .createdBy("test2")
            .lastModifiedBy("test2")
            .build();

    @Disabled
    @Test
    void shouldSaveOneCourseTopic() {

        courseTopicRepository.deleteAll();

        String requestBody = "{\n" +
                "  \"name\": \"test1\",\n" +
                "  \"createdAt\": \"2019-03-28 14:47:33 PM\", \n" +
                "  \"lastModifiedAt\": \"2019-03-28 14:47:33 PM\", \n" +
                "  \"createdBy\": \"test2\", \n" +
                "  \"lastModifiedBy\": \"test2\"" +
                "  \"FK1bdlrvdx9cb2s10puxn0syto3\": \"1\", \n}";

        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post(API)
                .then()
                .extract().response();

        System.out.println(response.jsonPath().prettyPrint());

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("test1", response.jsonPath().getString("name"));
        Assertions.assertEquals("2019-03-28 14:47:33 PM", response.jsonPath().getString("createdAt"));
        Assertions.assertEquals("2019-03-28 14:47:33 PM", response.jsonPath().getString("lastModifiedAt"));
        Assertions.assertEquals("test2", response.jsonPath().getString("createdBy"));
        Assertions.assertEquals("test2", response.jsonPath().getString("lastModifiedBy"));
        Assertions.assertEquals("1", response.jsonPath().getString("FK1bdlrvdx9cb2s10puxn0syto3"));
    }

    @Disabled
    @Test
    void updateOneCourseTopic(){
        courseTopicRepository.deleteAll();

        courseTopicRepository.save(first);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("[test1]", response.jsonPath().getString("name"));
        ;

        String id = first.getId().toString();

        String requestBody = "{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"name\": \"Put\",\n}";

        System.out.println(requestBody.toString());

        Response response1 = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .put(API + "/" + id)
                .then()
                .extract().response();


        System.out.println(response1.jsonPath().prettyPrint());

        Assertions.assertEquals(200, response1.statusCode());
        Assertions.assertEquals("Put", response1.jsonPath().getString("name"));

        Response response2 = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response2.statusCode());
        Assertions.assertEquals("[Put]", response2.jsonPath().getString("name"));
    }

    @Disabled
    @Test
    void shouldFindOneCourseTopic(){
        courseTopicRepository.deleteAll();
        CourseTopic saved = courseTopicRepository.save(first);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API + "/" + saved.getId())
                .then()
                .extract().response();

        System.out.println(response.jsonPath().prettyPrint());

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("test1", response.jsonPath().getString("name"));
    }

    @Test
    void NotFoundCourseTopic(){
        courseTopicRepository.deleteAll();
        CourseTopic saved = courseTopicRepository.save(first);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API + "/" + (saved.getId() +10))
                .then()
                .extract().response();

        System.out.println(response.jsonPath().prettyPrint());

        Assertions.assertEquals(404, response.statusCode());
        Assertions.assertEquals("Not Found", response.jsonPath().getString("error"));
    }

    @Disabled
    @Test
    void shouldFindTwoCourseTopics(){
        courseTopicRepository.deleteAll();
        courseTopicRepository.save(first);
        courseTopicRepository.save(second);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("[test1, test2]", response.jsonPath().getString("name"));
    }

    @Disabled
    @DisplayName("DeleteById Test")
    @Test
    void shouldDeleteOneCouseTopic(){
        courseTopicRepository.deleteAll();
        DanceInstructor saved = courseTopicRepository.save(first);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(API + "/" + saved.getId())
                .then()
                .extract().response();

        System.out.println(response.jsonPath().prettyPrint());

        Assertions.assertEquals(200, response.statusCode());


        Response response2 = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response2.statusCode());
        Assertions.assertEquals("[]", response2.jsonPath().getString("name"));
    }

    @Test
    void shouldDeleteButNotFound(){
        courseTopicRepository.deleteAll();
        DanceInstructor saved = courseTopicRepository.save(first);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(API + "/" + (saved.getId() + 10))
                .then()
                .extract().response();

        System.out.println(response.jsonPath().prettyPrint());

        Assertions.assertEquals(404, response.statusCode());
        Assertions.assertEquals("Not Found", response.jsonPath().getString("error"));
    }

    @Disabled
    @Test
    void shouldDeleteDanceCourses(){
        courseTopicRepository.deleteAll();
        courseTopicRepository.save(first);
        courseTopicRepository.save(second);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());

        Response response1 = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(API)
                .then()
                .extract().response();

        System.out.println(response.jsonPath().prettyPrint());

        Assertions.assertEquals(200, response1.statusCode());

        Response response2 = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response2.statusCode());
    }

    @Disabled
    @Test
    void UpdateWithBadData(){
        courseTopicRepository.deleteAll();
        CourseTopic saved = courseTopicRepository.save(first);

        String badId = String.valueOf(saved.getId() +1000000);

        String requestBody = "{\n" +
                "  \"id\": \"" + badId + "\",\n" +
                "  \"name\": \"Bad data\",\n}";

        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .put(API + "/" + badId)
                .then()
                .extract().response();

        System.out.println(response.jsonPath().prettyPrint());

        Assertions.assertEquals(404, response.statusCode());
        Assertions.assertEquals("Not Found", response.jsonPath().getString("error"));
    }
}