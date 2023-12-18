package ru.practicum.user;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.steps.Checks;
import ru.practicum.steps.CreateUser;

@DisplayName("Пользователь")
public class CreateExistingUserTest extends CreateDeleteUser {


    String expected = "User already exists";
    CreateUser create = new CreateUser();


    @DisplayName("Создание пользователя, который уже зарегистрирован")
    @Test
    public void createExistingUserTest() {
        String messageError = create.createExistingUser(request);

        Checks.checkResult(expected, messageError);

    }


}
