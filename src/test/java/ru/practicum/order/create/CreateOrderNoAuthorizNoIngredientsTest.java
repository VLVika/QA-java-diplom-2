package ru.practicum.order.create;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.pojo.CreateOrderModelRq;
import ru.practicum.steps.Order;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Заказ")
public class CreateOrderNoAuthorizNoIngredientsTest {

    Order order = new Order();
    List<String> emptyListForOrder = new ArrayList<>();

    @DisplayName("Создание заказа без ингредиентов не авторизированным пользователем")
    @Test
    public void createOrderNoAuthorUserWithoutIngredientsTest() {

        var request = CreateOrderModelRq.createOrder(emptyListForOrder);
        order.createOrderNoAuthorUserWithoutIngredients(request);

    }
}
