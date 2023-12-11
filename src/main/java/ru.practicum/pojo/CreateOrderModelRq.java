package ru.practicum.pojo;

import io.qameta.allure.Step;

import java.util.List;

public class CreateOrderModelRq {

    @Step("Создает Json запрос с ингредиентами для создания заказа")
    public static CreateOrderPojoRq createOrder(List<String> ingredients) {
        return CreateOrderPojoRq.builder()
                .ingredients(ingredients)
                .build();

    }

}
