package ru.practicum.methods;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import ru.practicum.pojo.CreateUserModelRq;
import ru.practicum.pojo.CreateUserPojoRq;
import ru.practicum.steps.CreateUser;
import ru.practicum.steps.DeleteUser;

public class CreateDeleteUser {

    CreateUser user = new CreateUser();
    protected String token;
    protected String email;
    protected String password;
    protected CreateUserPojoRq request;

    @DisplayName("Регистрирует пользователя")
    @Before
    public void createUserBeforeTest() {
        request = CreateUserModelRq.newUserAllFieldsRandom();
        email = request.getEmail();
        password = request.getPassword();
        token = user.createNewUserAndGetToken(request);
    }


    @DisplayName("Удаляет пользователя")
    @After
    public void deleteUserAfterTest() {
        DeleteUser.deleteUser(token);
    }

}
