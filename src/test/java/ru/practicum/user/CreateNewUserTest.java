package ru.practicum.user;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.practicum.pojo.CreateUserModelRq;
import ru.practicum.steps.CreateUser;
import ru.practicum.steps.DeleteUser;

@DisplayName("Пользователь")
public class CreateNewUserTest {

    CreateUser user = new CreateUser();
    String token;

    @DisplayName("Создание нового пользователя с рандомными данными")
    @Test
    public void createNewUser(){
        var request = CreateUserModelRq.newUserAllFieldsRandom();
        token = user.createNewUserAndGetToken(request);
    }

    @After
    public void deleteUser(){
        DeleteUser.deleteUser(token);
    }
}
