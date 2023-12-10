package ru.practicum.user;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.pojo.CreateUserModelRq;
import ru.practicum.steps.Checks;
import ru.practicum.steps.CreateUser;

@DisplayName("Пользователь")
public class CreateWithoutRequiredFieldTest {

    String expect = "Email, password and name are required fields";
    CreateUser create = new CreateUser();

    @DisplayName("Создание нового пользователя с пустым полем логин/емайл")
    @Test
    public void createWithoutEmailFieldTest(){
        var request = CreateUserModelRq.newUserWithoutEmailField();
        String messageError = create.createUserWithoutRequiredField(request);

        Checks.checkResult(expect, messageError);

    }


    @DisplayName("Создание нового пользователя с пустым полем пароль")
    @Test
    public void createWithoutPasswordFieldTest(){
        var request = CreateUserModelRq.newUserWithoutPasswordField();
        String messageError = create.createUserWithoutRequiredField(request);

        Checks.checkResult(expect, messageError);

    }


    @DisplayName("Создание нового пользователя c пустым полем Имя")
    @Test
    public void createWithoutNameFieldTest(){
        var request = CreateUserModelRq.newUserWithoutNameField();
        String messageError = create.createUserWithoutRequiredField(request);

        Checks.checkResult(expect, messageError);

    }


}
