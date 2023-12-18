package ru.practicum.order.get;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.steps.Checks;
import ru.practicum.steps.Order;

@DisplayName("Заказ")
public class GetOrderNoAuthorizationUserTest {


    String expected = "You should be authorised";

    @DisplayName("Получение заказов не авторизованного пользователя")
    @Test
    public void getOrderAuthorizationUserTest() {

        String messageError = Order.getOrdersNoAuthorization();

        Checks.checkResult(expected, messageError);
    }
}

