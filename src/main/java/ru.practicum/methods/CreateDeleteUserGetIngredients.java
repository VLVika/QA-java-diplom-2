package ru.practicum.methods;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import ru.practicum.pojo.CreateUserModelRq;
import ru.practicum.steps.Order;

import java.util.List;


public class CreateDeleteUserGetIngredients extends CreateDeleteUser {

    protected List<String> ingredients;
    protected List<String> ingredientsForOrder;

    @DisplayName("Регистрирует пользователя и создает список с ингредиентами")
    @Override
    @Before
    public void createUserBeforeTest() {
        request = CreateUserModelRq.newUserAllFieldsRandom();
        email = request.getEmail();
        password = request.getPassword();
        token = user.createNewUserAndGetToken(request);

        ingredients = Order.getIngredients();

        ingredientsForOrder =
                GetIngredientsAndCreateList.getIngredientsAndCreateList(ingredients);


    }


}
