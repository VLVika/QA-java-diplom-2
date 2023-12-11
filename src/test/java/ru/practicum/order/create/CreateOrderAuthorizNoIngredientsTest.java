package ru.practicum.order.create;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.pojo.CreateOrderModelRq;
import ru.practicum.steps.Checks;
import ru.practicum.steps.Order;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Заказ")
public class CreateOrderAuthorizNoIngredientsTest extends CreateDeleteUser {


    Order order = new Order();
    String expected = "Ingredient ids must be provided";
    List<String> emptyListForOrder = new ArrayList<>();


    @DisplayName("Создание заказа без ингредиентов авторизированным пользователем")
    @Test
    public void createOrderAuthorUserWithoutIngredientsTest() {

        var request = CreateOrderModelRq.createOrder(emptyListForOrder);
        String messageError = order.createOrderAuthorUserWithoutIngredients(request, token);

        Checks.checkResult(expected, messageError);

    }
}
