package ru.practicum.steps;

import io.qameta.allure.Step;
import ru.practicum.pojo.CreateUserPojoRq;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static ru.practicum.util.Specification.*;

public class CreateUser {

    @Step("Создаёт пользователя")
    public String createNewUserAndGetToken(CreateUserPojoRq request) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .post("register")
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract()
                .jsonPath().getString("accessToken");

    }


    @Step("Повторно создаёт уже существующего пользователя")
    public String createExistingUser(CreateUserPojoRq request) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .post("register")
                .then()
                .spec(RES_SPEC_FORBIDDEN)
                .body("success", is(false))
                .extract()
                .jsonPath().getString("message");

    }


}
