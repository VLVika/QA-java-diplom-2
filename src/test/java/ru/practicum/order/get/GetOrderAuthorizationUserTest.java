package ru.practicum.order.get;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.steps.Order;

@DisplayName("Заказ")
public class GetOrderAuthorizationUserTest extends CreateDeleteUser {

    Order order = new Order();

    @DisplayName("Получение заказов авторизованного пользователя")
    @Test
    public void getOrderAuthorizationUserTest() {

        order.getOrdersWithAuthorization(token);
    }
}
