package ru.practicum.order.create;


import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.methods.GetIngredientsAndCreateList;
import ru.practicum.pojo.CreateOrderModelRq;
import ru.practicum.steps.Order;

import java.util.List;

@DisplayName("Заказ")
public class CreateOrderNoAuthoriaWithIngredientsTest {

    Order order = new Order();
    List<String> ingredients;
    List<String> ingredientsForOrder;


    @DisplayName("Создаёт список ингредиентов")
    @Before
    public void getIngredients() {
        ingredients = Order.getIngredients();
        ingredientsForOrder =
                GetIngredientsAndCreateList.getIngredientsAndCreateList(ingredients);
    }


    @DisplayName("Создание заказа с ингредиентами не авторизированным пользователем")
    @Test
    public void createOrderNoAuthorUserWithIngredientsTest() {

        var request = CreateOrderModelRq.createOrder(ingredientsForOrder);
        Response response = order.createOrderNoAuthorUserWithIngredients(request);

    }
}
