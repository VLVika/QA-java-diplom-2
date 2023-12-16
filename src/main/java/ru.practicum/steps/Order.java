package ru.practicum.steps;

import io.qameta.allure.Step;
import ru.practicum.pojo.CreateOrderPojoRq;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static ru.practicum.util.GlobalVariables.ENDPOINT_INGREDIENTS;
import static ru.practicum.util.GlobalVariables.ENDPOINT_ORDER;
import static ru.practicum.util.Specification.*;

public class Order {

    @Step("Получает список ингредиентов")
    public static List<String> getIngredients() {
        return given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .when()
                .get(ENDPOINT_INGREDIENTS)
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract()
                .jsonPath().getList("data._id");
    }

    @Step("Создаёт заказ с ингредиентами под авторизованным пользователем")
    public void createOrderAuthorUser(CreateOrderPojoRq request, String token) {
         given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .header("Authorization", token)
                .when()
                .body(request)
                .post(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract()
                .response();
    }


    @Step("Создаёт заказ без ингредиентов под авторизованным пользователем")
    public String createOrderAuthorUserWithoutIngredients(CreateOrderPojoRq request, String token) {
        return given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .header("Authorization", token)
                .when()
                .body(request)
                .post(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_BAD_REQUEST)
                .body("success", is(false))
                .extract()
                .jsonPath()
                .getString("message");
    }


    @Step("Создаёт заказ без ингредиентов не авторизованным пользователем")
    public void createOrderNoAuthorUserWithoutIngredients(CreateOrderPojoRq request) {
         given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .when()
                .body(request)
                .post(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .body("success", is(false))
                .extract()
                .jsonPath()
                .getString("message");
    }


    @Step("Создаёт заказ с ингредиентами не авторизованным пользователем")
    public void createOrderNoAuthorUserWithIngredients(CreateOrderPojoRq request) {
         given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .when()
                .body(request)
                .post(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .extract()
                .response();
    }


    @Step("Создаёт заказ с некорректным id ингредиента под авторизованным пользователем")
    public void createOrderAuthorUserWithWrongIdIngredients(CreateOrderPojoRq request, String token) {
         given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .header("Authorization", token)
                .when()
                .body(request)
                .post(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_INTERNAL_ERROR)
                .extract()
                .response();
    }


    @Step("Создаёт заказ с некорректным id ингредиента не авторизованным пользователем")
    public void createOrderNoAuthorUserWithWrongIdIngredients(CreateOrderPojoRq request) {
         given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .when()
                .body(request)
                .post(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .extract()
                .response();
    }


    @Step("Получает список заказов авторизованного пользователя")
    public static void getOrdersWithAuthorization(String token) {
         given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .header("Authorization", token)
                .when()
                .get(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract()
                .response();
    }


    @Step("Получает список заказов не авторизованного пользователя")
    public static String getOrdersNoAuthorization() {
        return given()
                .spec(REQ_SPEC_WITOUT_AUT)
                .when()
                .get(ENDPOINT_ORDER)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .body("success", is(false))
                .extract()
                .jsonPath().getString("message");
    }

}
