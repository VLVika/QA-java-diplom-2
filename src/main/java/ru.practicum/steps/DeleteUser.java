package ru.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static ru.practicum.util.Specification.*;

public class DeleteUser {

    @Step("Удаляет пользователя")
    public static Response deleteUser(String token) {
        return  given()
                .spec(REQ_SPEC)
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .delete("user")
                .then()
                .spec(RES_SPEC_ACCEPTED)
                .body("success", is(true))
                .extract().response();


    }

}
