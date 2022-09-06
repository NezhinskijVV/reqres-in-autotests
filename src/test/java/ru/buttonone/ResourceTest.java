package ru.buttonone;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.buttonone.domain.Resource;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("API reqres")
public class ResourceTest {

    public static final String REGRES_API_URL = "https://reqres.in";
    public static final String REGRES_API_URN = "/api/resource";

    @DisplayName("Checking the correct receipt of resources")
    @Test
    public void shouldHaveCorrectGetResource() {

        ValidatableResponse validatableResponse = given()
                .baseUri(REGRES_API_URL)
                .when()
                .get(REGRES_API_URN)
                .then()
                .statusCode(200);

        List<Resource> resourceList = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getList("data", Resource.class);

        System.out.println("resourceList = " + resourceList);

        assertThat(resourceList, Matchers.containsInAnyOrder(
                new Resource(1, "cerulean", 2000, "#98B2D1", "15-4020"),
                new Resource(2, "fuchsia rose", 2001, "#C74375", "17-2031"),
                new Resource(3, "true red", 2002, "#BF1932", "19-1664"),
                new Resource(4, "aqua sky", 2003, "#7BC4C4", "14-4811"),
                new Resource(5, "tigerlily", 2004, "#E2583E", "17-1456"),
                new Resource(6, "blue turquoise", 2005, "#53B0AE", "15-5217")
        ));
    }

    @DisplayName("Checking the correctness of the status code field display")
    @Test
    public void shouldHaveCorrectStatusCode() {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("Connection", "keep-alive")
                .setBaseUri(REGRES_API_URL)
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(200)
                .build();

        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get(REGRES_API_URN)
                .then()
                .spec(responseSpecification);
    }

    @DisplayName("Checking the correctness of the Connection field display")
    @Test
    public void shouldHaveCorrectConnection() {

        RestAssured
                .given()
                .header("X-Powered-By", "Express")
                .baseUri(REGRES_API_URL)
                .when()
                .get(REGRES_API_URN)
                .then()
                .contentType(ContentType.JSON)
                .log().all()
                .header("Connection", "keep-alive")
                .statusCode(200);
    }

    @DisplayName("Checking the correctness of the URL")
    @Test
    public void shouldHaveCorrectGetUrl() {

        RestAssured
                .given()
                .baseUri(REGRES_API_URL)
                .when()
                .get(REGRES_API_URL)
                .then()
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking the correctness of the head resource")
    @Test
    public void shouldHaveCorrectHeadResource() {

        RestAssured
                .given()
                .and()
                .when()
                .head(REGRES_API_URL)
                .then()
                .log().all()
                .statusCode(200);
    }

    @DisplayName("Checking the correctness of the options resource field display")
    @Test
    public void shouldHaveCorrectOptionsResource() {

        RestAssured
                .given()
                .and()
                .when()
                .options(REGRES_API_URL)
                .then()
                .log().all();
    }
}
