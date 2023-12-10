package ru.practicum.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUserGetIngredients;
import ru.practicum.methods.GetIngredientsAndCreateList;
import ru.practicum.pojo.CreateOrderModelRq;
import ru.practicum.steps.Order;

import java.util.List;


@DisplayName("Заказ")
public class CreateOrderTest extends CreateDeleteUserGetIngredients {

    Order order = new Order();

    @DisplayName("Создание заказа авторизированным пользователем")
    @Test
    public void createOrderAuthorUser(){

        List<String> ingredientsForOrder =
                GetIngredientsAndCreateList.getIngredientsAndCreateList(ingredients);

        var request = CreateOrderModelRq.createOrder(ingredientsForOrder);
        Response response = order.createOrderAuthorUser(request,token);

    }
}
