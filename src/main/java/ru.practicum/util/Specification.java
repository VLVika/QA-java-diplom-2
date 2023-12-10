package ru.practicum.util;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.net.HttpURLConnection;

import static ru.practicum.util.GlobalVariables.BASE_URL;
import static ru.practicum.util.GlobalVariables.PATH_AUT;

public class Specification {

    public static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .addFilter(new AllureRestAssured())
                    .setContentType(ContentType.JSON)
                    .setRelaxedHTTPSValidation()
                    .setBaseUri(BASE_URL)
                    .setBasePath(PATH_AUT)
                    .log(LogDetail.ALL)
                    .build();


    public static final ResponseSpecification RES_SPEC_OK =
            new ResponseSpecBuilder()
                    .log(LogDetail.ALL)
                    .expectStatusCode(HttpURLConnection.HTTP_OK)
                    .build();

    public static final ResponseSpecification RES_SPEC_ACCEPTED =
            new ResponseSpecBuilder()
                    .log(LogDetail.ALL)
                    .expectStatusCode(HttpURLConnection.HTTP_ACCEPTED)
                    .build();

    public static final ResponseSpecification RES_SPEC_FORBIDDEN =
            new ResponseSpecBuilder()
                    .log(LogDetail.ALL)
                    .expectStatusCode(HttpURLConnection.HTTP_FORBIDDEN)
                    .build();
}
