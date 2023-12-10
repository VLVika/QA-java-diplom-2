package ru.practicum.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.pojo.LoginUserModelRq;
import ru.practicum.steps.Checks;
import ru.practicum.steps.Login;

@DisplayName("Логин")
public class LoginSuccessfullTest extends CreateDeleteUser {

    Login newUserLogin = new Login();


    @DisplayName("Логин существующего пользователя")
    @Test
    public void login(){

    var request = LoginUserModelRq.login(email, password);
    String messageError = newUserLogin.login(request);

    }

}
