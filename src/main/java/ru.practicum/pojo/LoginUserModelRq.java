package ru.practicum.pojo;

import io.qameta.allure.Step;

public class LoginUserModelRq {

    @Step("Формирует Json для создания аутентификации пользователя")
    public static LoginUserPojoRq login(String email, String password) {
        return LoginUserPojoRq.builder()
                .email(email)
                .password(password)
                .build();
    }

}
