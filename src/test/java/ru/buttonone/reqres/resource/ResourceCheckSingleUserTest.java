package ru.buttonone.reqres.resource;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.buttonone.domain.Resource;

import static io.restassured.RestAssured.given;

@DisplayName("С API сайта Reqres")
public class ResourceCheckSingleUserTest {

    public static final String REQRES_URL = "https://reqres.in";
    public static final String API_UNKNOWN_2 = "/api/{resource}/2";
    public static final String RESOURCE_UNKNOWN = "unknown";
    // correct values
    public static final int ID_CORRECT = 2;
    public static final String NAME_CORRECT = "fuchsia rose";
    public static final int YEAR_CORRECT = 2001;
    public static final String COLOR_CORRECT = "#C74375";
    public static final String PANTONE_VALUE_CORRECT = "17-2031";
    public static final int STATUS_CODE_CORRECT = 200;
    //in correct values
    public static final int ID_NOT_CORRECT = 3;
    public static final String NAME_NOT_CORRECT = "true red";
    public static final int YEAR_NOT_CORRECT = 2002;
    public static final String COLOR_NOT_CORRECT = "#BF1932";
    public static final String PANTONE_VALUE_NOT_CORRECT = "19-1664";

    @DisplayName(" корректно получить ресурс одного пользователя")
    @Test
    public void shouldHaveCorrectGetSingleResourceTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(REQRES_URL)
                .pathParam("resource", RESOURCE_UNKNOWN)
                .when()
                .get(API_UNKNOWN_2)
                .then()
                .statusCode(STATUS_CODE_CORRECT);

        Resource resource = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getObject("data", Resource.class);

        Assertions.assertEquals(resource,
                new Resource(ID_CORRECT,
                        NAME_CORRECT,
                        YEAR_CORRECT,
                        COLOR_CORRECT,
                        PANTONE_VALUE_CORRECT));
    }

    @DisplayName(" НЕ корректно получить ресурс одного пользователя (негативный тест) - не корректный id")
    @Test
    public void shouldHaveInCorrectIdGetSingleResourceTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(REQRES_URL)
                .pathParam("resource", RESOURCE_UNKNOWN)
                .when()
                .get(API_UNKNOWN_2)
                .then()
                .statusCode(200);

        Resource resource = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getObject("data", Resource.class);

        Assertions.assertEquals(resource,
                new Resource(ID_NOT_CORRECT,        //не корректное значение
                        NAME_CORRECT,
                        YEAR_CORRECT,
                        COLOR_CORRECT,
                        PANTONE_VALUE_CORRECT));

    }

    @DisplayName(" НЕ корректно получить ресурс одного пользователя (негативный тест) - не корректный name")
    @Test
    public void shouldHaveInCorrectNameGetSingleResourceTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(REQRES_URL)
                .pathParam("resource", RESOURCE_UNKNOWN)
                .when()
                .get(API_UNKNOWN_2)
                .then()
                .statusCode(200);

        Resource resource = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getObject("data", Resource.class);

        Assertions.assertEquals(resource,
                new Resource(ID_CORRECT,
                        NAME_NOT_CORRECT,       //не корректное значение
                        YEAR_CORRECT,
                        COLOR_CORRECT,
                        PANTONE_VALUE_CORRECT));

    }

    @DisplayName(" НЕ корректно получить ресурс одного пользователя (негативный тест) - не корректный year")
    @Test
    public void shouldHaveInCorrectYearGetSingleResourceTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(REQRES_URL)
                .pathParam("resource", RESOURCE_UNKNOWN)
                .when()
                .get(API_UNKNOWN_2)
                .then()
                .statusCode(200);

        Resource resource = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getObject("data", Resource.class);

        Assertions.assertEquals(resource,
                new Resource(ID_CORRECT,
                        NAME_CORRECT,
                        YEAR_NOT_CORRECT,       //не корректное значение
                        COLOR_CORRECT,
                        PANTONE_VALUE_CORRECT));

    }

    @DisplayName(" НЕ корректно получить ресурс одного пользователя (негативный тест) - не корректный color")
    @Test
    public void shouldHaveInCorrectColorGetSingleResourceTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(REQRES_URL)
                .pathParam("resource", RESOURCE_UNKNOWN)
                .when()
                .get(API_UNKNOWN_2)
                .then()
                .statusCode(200);

        Resource resource = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getObject("data", Resource.class);

        Assertions.assertEquals(resource,
                new Resource(ID_CORRECT,
                        NAME_CORRECT,
                        YEAR_CORRECT,
                        COLOR_NOT_CORRECT,      //не корректное значение
                        PANTONE_VALUE_CORRECT));

    }

    @DisplayName(" НЕ корректно получить ресурс одного пользователя (негативный тест) - не корректный pantone_value")
    @Test
    public void shouldHaveInCorrectPantoneValueGetSingleResourceTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(REQRES_URL)
                .pathParam("resource", RESOURCE_UNKNOWN)
                .when()
                .get(API_UNKNOWN_2)
                .then()
                .statusCode(200);

        Resource resource = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getObject("data", Resource.class);

        Assertions.assertEquals(resource,
                new Resource(ID_CORRECT,
                        NAME_CORRECT,
                        YEAR_CORRECT,
                        COLOR_CORRECT,
                        PANTONE_VALUE_NOT_CORRECT));//не корректное значение

    }
}
