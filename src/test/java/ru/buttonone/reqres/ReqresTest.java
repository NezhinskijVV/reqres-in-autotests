package ru.buttonone.reqres;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.buttonone.domain.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("From Api Reqres should ")
public class ReqresTest {

    public static final String BASE_REQRES_URL = "https://reqres.in";
    public static final String LIST_USERS_ID = "/api/users?page=2";

    @DisplayName("correct get list users")
    @Test
    public void shouldHaveCorrectGetListUsers() {
        ValidatableResponse validatableResponse = given()
                .spec(ReqresSpecifications.requestReqresSpecification())
                .when()
                .get(LIST_USERS_ID)
                .then()
                .spec(ReqresSpecifications.
                        responseLotrSpecification("application/json", 200));

        List<User> userList = validatableResponse
                .extract()
                .body()
                .jsonPath().getList("data", User.class);

        System.out.println("userList = " + userList);

        Assertions.assertAll(
                () -> assertTrue(userList.stream().anyMatch(b -> b.getEmail().
                        equals("lindsay.ferguson@reqres.in")))
        );

        assertThat(userList, hasItem(new User("tobias.funke@reqres.in")));

        assertThat(userList, Matchers.containsInAnyOrder
                (new User("michael.lawson@reqres.in"),
                        new User("lindsay.ferguson@reqres.in"),
                        new User("tobias.funke@reqres.in"),
                        new User("byron.fields@reqres.in"),
                        new User("george.edwards@reqres.in"),
                        new User("rachel.howell@reqres.in")
                ));

    }


}