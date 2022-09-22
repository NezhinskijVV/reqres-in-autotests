package ru.buttonone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("API https://reqres.in/ должен")
public class YasiaMain {

    @DisplayName("корректно создавать пользователя")
    @Test
    public void shouldCreateUserCorrectly() {

        given()
                .baseUri("https://reqres.in")
                .param("email","eve1.holt2@reqres.in")
                .param("password","pistol1")
                .when()
                .get("/api/register")
                .then()
                .statusCode(200)
        ;

    }

}
