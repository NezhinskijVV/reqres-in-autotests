package ru.buttonone.reqres;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqresSpecifications {

    public static final String BASE_REQRES_URL = "https://reqres.in";

    public static RequestSpecification requestReqresSpecification() {
        return new RequestSpecBuilder()
                .addHeader("language", "en")
                .setBaseUri(BASE_REQRES_URL)
                .build();
    }

    public static ResponseSpecification responseLotrSpecification
            (String contentType, int statusCode) {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(contentType)
                .expectStatusCode(statusCode)
                .build();
    }

}
