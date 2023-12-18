package ru.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static ru.practicum.util.Specification.REQ_SPEC;
import static ru.practicum.util.Specification.RES_SPEC_ACCEPTED;

public class DeleteUser {

    @Step("Удаляет пользователя")
    public static void deleteUser(String token) {
         given()
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
