package ru.practicum.order;


import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUserGenerateRandomHash;
import ru.practicum.pojo.CreateOrderModelRq;
import ru.practicum.steps.Order;

@DisplayName("Заказ")
public class CreateOrderAuthorWithWrongIdTest extends CreateDeleteUserGenerateRandomHash {

    Order order = new Order();


    @DisplayName("Создание заказа c некорректным id ингредиентов авторизированным пользователем")
    @Test
    public void createOrderAuthorUserWithWrongIdIngredientsTest() {

        var request = CreateOrderModelRq.createOrder(randomId);
        Response response = order.createOrderAuthorUserWithWrongIdIngredients(request, token);


    }


}
