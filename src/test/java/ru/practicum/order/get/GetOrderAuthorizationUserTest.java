package ru.practicum.order.get;


import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.steps.Order;

@DisplayName("Заказ")
public class GetOrderAuthorizationUserTest extends CreateDeleteUser {

    Order order = new Order();

    @DisplayName("Получение заказов авторизованного пользователя")
    @Test
    public void getOrderAuthorizationUserTest(){

        Response response = order.getOrdersWithAuthorization(token);
    }
}
