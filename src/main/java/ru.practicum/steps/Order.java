package ru.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.practicum.pojo.CreateOrderPojoRq;
import ru.practicum.pojo.LoginUserPojoRq;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static ru.practicum.util.GlobalVariables.*;
import static ru.practicum.util.Specification.*;

public class Order {

    @Step("Получает список ингредиентов")
    public static List<String> getIngredients(){
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
    public Response createOrderAuthorUser(CreateOrderPojoRq request, String token){
        return given()
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


}
