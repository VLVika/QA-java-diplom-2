package ru.practicum.order.create;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUserGetIngredients;
import ru.practicum.pojo.CreateOrderModelRq;
import ru.practicum.steps.Order;


@DisplayName("Заказ")
public class CreateOrderSuccessfullTest extends CreateDeleteUserGetIngredients {

    Order order = new Order();


    @DisplayName("Создание заказа с ингредиентами авторизированным пользователем")
    @Test
    public void createOrderAuthorUser() {

        var request = CreateOrderModelRq.createOrder(ingredientsForOrder);
        Response response = order.createOrderAuthorUser(request, token);

    }


}

