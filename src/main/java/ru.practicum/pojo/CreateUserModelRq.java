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

    @Step("Формирует Json для создания нового пользователя с пустым обязательным полем email")
    public static CreateUserPojoRq newUserWithoutEmailField() {
        return CreateUserPojoRq.builder()
                .name(String.format("Alexandr %s", RandomStringUtils.randomAlphabetic(5)))
                .email(null)
                .password(RandomStringUtils.randomAlphanumeric(6, 8))
                .build();
    }

    @Step("Формирует Json для создания нового пользователя с пустым обязательным полем password")
    public static CreateUserPojoRq newUserWithoutPasswordField() {
        return CreateUserPojoRq.builder()
                .name(String.format("Alexandr %s", RandomStringUtils.randomAlphabetic(5)))
                .email(String.format("alex_'%s'@yandex.ru", RandomStringUtils.randomNumeric(5)))
                .password(null)
                .build();
    }


    @Step("Формирует Json для создания нового пользователя с пустым обязательным полем name")
    public static CreateUserPojoRq newUserWithoutNameField() {
        return CreateUserPojoRq.builder()
                .name(null)
                .email(String.format("alex_'%s'@yandex.ru", RandomStringUtils.randomNumeric(5)))
                .password(RandomStringUtils.randomAlphanumeric(6, 8))
                .build();
    }


}
