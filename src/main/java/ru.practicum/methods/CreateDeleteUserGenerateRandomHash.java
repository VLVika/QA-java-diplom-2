package ru.practicum.methods;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import ru.practicum.pojo.CreateUserModelRq;

import java.util.ArrayList;

import static ru.practicum.methods.GenerateRandomHash.generateListWithRandomIdIngredients;

public class CreateDeleteUserGenerateRandomHash extends CreateDeleteUser {

    private static String id;
    protected static ArrayList<String> randomId = new ArrayList<>();

    @DisplayName("Регистрирует пользователя, создаёт список с некорректным id ингредиента")
    @Override
    @Before
    public void createUserBeforeTest() {
        request = CreateUserModelRq.newUserAllFieldsRandom();
        email = request.getEmail();
        password = request.getPassword();
        token = user.createNewUserAndGetToken(request);

        //создает рандомный id кладет в List
        randomId = generateListWithRandomIdIngredients();
    }
}
