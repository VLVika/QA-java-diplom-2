package ru.practicum.pojo;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateUserModelRq {

    @Step("Формирует Json для создания нового пользователя с рандомными данными")
    public static CreateUserPojoRq newUserAllFieldsRandom() {
        return CreateUserPojoRq.builder()
                .name(String.format("Alexandr %s", RandomStringUtils.randomAlphabetic(5)))
                .email(String.format("alex_'%s'@yandex.ru", RandomStringUtils.randomNumeric(5)))
                .password(RandomStringUtils.randomAlphanumeric(6, 8))
                .build();
    }
}
