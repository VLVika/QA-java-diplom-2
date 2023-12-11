package ru.practicum.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.pojo.CreateOrderModelRq;
import ru.practicum.steps.Order;

import java.util.ArrayList;

import static ru.practicum.methods.GenerateRandomHash.generateListWithRandomIdIngredients;

@DisplayName("Заказ")
public class CreateOrderNoAuthorizWithWrongIdTest {

    private ArrayList<String> randomId = new ArrayList<>();
    Order order = new Order();

    @DisplayName("Создаёт список с некорректным id ингредиента")
    @Before
    public void createListWithWrongIdIngredient() {
        randomId = generateListWithRandomIdIngredients();
    }


    @DisplayName("Создание заказа c некорректным id ингредиентов не авторизированным пользователем")
    @Test
    public void createOrderNoAuthorUserWithWrongIdIngredientsTest() {

        var request = CreateOrderModelRq.createOrder(randomId);
        Response response = order.createOrderNoAuthorUserWithWrongIdIngredients(request);

    }

}
