package ru.practicum.pojo;


import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class EditFieldsModelRq {


    @Step("Формирует Json для редактирования данных в поле email пользователя ")
    public static EditFieldEmailPojoRq editEmailField() {
        return EditFieldEmailPojoRq.builder()
                .email(String.format("Ivan_%s@gmail.com", RandomStringUtils.randomAlphabetic(4)))
                .build();

    }

    @Step("Формирует Json для редактирования данных в поле name пользователя")
    public static EditFieldNamePojoRq editNameField() {
        return EditFieldNamePojoRq.builder()
                .name(String.format("Ivan_%s", RandomStringUtils.randomAlphabetic(5)))
                .build();

    }

    @Step("Формирует Json для редактирования данных в поле password пользователя")
    public static EditFieldPasswordPojoRq editPasswordField() {
        return EditFieldPasswordPojoRq.builder()
                .password(RandomStringUtils.randomAlphanumeric(7))
                .build();

    }

}
