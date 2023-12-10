package ru.practicum.steps;

import io.qameta.allure.Step;
import ru.practicum.pojo.LoginUserModelRq;
import ru.practicum.pojo.LoginUserPojoRq;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static ru.practicum.util.GlobalVariables.ENDPOINT_LOGIN;
import static ru.practicum.util.Specification.*;

public class Login {

    @Step("Логинится в систему")
    public String login(LoginUserPojoRq request){
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .post(ENDPOINT_LOGIN)
                .then()
                .spec(RES_SPEC_OK)
                .body("success", is(true))
                .extract()
                .jsonPath().getString("accessToken");
    }

    @Step("Логинится в систему c ошибкой в логине или пароле")
    public String loginWithWrong(LoginUserPojoRq request){
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(request)
                .post(ENDPOINT_LOGIN)
                .then()
                .spec(RES_SPEC_UNAUTHORIZED)
                .body("success", is(false))
                .extract()
                .jsonPath().getString("message");
    }

}
