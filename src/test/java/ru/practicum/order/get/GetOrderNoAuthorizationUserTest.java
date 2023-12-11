package ru.practicum.order.get;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.practicum.steps.Checks;
import ru.practicum.steps.Order;

@DisplayName("Заказ")
public class GetOrderNoAuthorizationUserTest {

    Order order = new Order();
    String expected = "You should be authorised";

    @DisplayName("Получение заказов не авторизованного пользователя")
    @Test
    public void getOrderAuthorizationUserTest(){

        String messageError = order.getOrdersNoAuthorization();

        Checks.checkResult(expected, messageError);
    }
}

