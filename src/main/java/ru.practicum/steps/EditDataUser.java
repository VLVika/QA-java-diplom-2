package ru.practicum.steps;


import io.qameta.allure.Step;
import ru.practicum.pojo.EditFieldEmailPojoRq;
import ru.practicum.pojo.EditFieldNamePojoRq;
import ru.practicum.pojo.EditFieldPasswordPojoRq;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static ru.practicum.util.GlobalVariables.ENDPOINT_USER;
import static ru.practicum.util.Specification.*;

public class EditDataUser {

    @Step("Авторизированный Пользователь редактирует свои данные в поле email")
    public void editFieldEmailUser(EditFieldEmailPojoRq request, String token) {
         given()
                .spec(REQ_SPEC)
                .header("Authorization", token)
                .when()
                .body(request)
                .patch(ENDPOINT_USER)
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract().response();

    }


    @Step("Авторизированный Пользователь редактирует свои данные в поле name")
    public void editFieldNameUser(EditFieldNamePojoRq request, String token) {
         given()
                .spec(REQ_SPEC)
                .header("Authorization", token)
                .when()
                .body(request)
                .patch(ENDPOINT_USER)
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract().response();

    }


    @Step("Авторизированный Пользователь редактирует свои данные в поле password")
    public void editFieldPasswordUser(EditFieldPasswordPojoRq request, String token) {
         given()
                .spec(REQ_SPEC)
                .header("Authorization", token)
                .when()
                .body(request)
                .patch(ENDPOINT_USER)
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract().response();

    }


    @Step("Не авторизированный Пользователь редактирует свои данные в поле email")
    public String editFieldEmailUserNoAuthor(EditFieldEmailPojoRq request) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .patch(ENDPOINT_USER)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .body("success", is(false))
                .extract().jsonPath().getString("message");

    }


    @Step("Не фвторизированный Пользователь редактирует свои данные в поле name")
    public String editFieldNameUserNoAuthor(EditFieldNamePojoRq request) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .patch(ENDPOINT_USER)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .body("success", is(false))
                .extract().jsonPath().getString("message");

    }


    @Step("Не авторизированный Пользователь редактирует свои данные в поле password")
    public String editFieldPasswordUserNoAuthor(EditFieldPasswordPojoRq request) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .patch(ENDPOINT_USER)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .body("success", is(false))
                .extract().jsonPath().getString("message");

    }

}
