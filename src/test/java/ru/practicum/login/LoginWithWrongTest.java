package ru.practicum.login;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.pojo.LoginUserModelRq;
import ru.practicum.steps.Checks;
import ru.practicum.steps.Login;

@DisplayName("Логин")
public class LoginWithWrongTest extends CreateDeleteUser {

    Login loginUser = new Login();
    String wrongEmail = String.format("shurick_'%s'@yandex.ru", RandomStringUtils.randomNumeric(6));
    String wrongPassword = RandomStringUtils.randomAlphabetic(6);
    String expected = "email or password are incorrect";


    @DisplayName("Логин существующего пользователя с ошибкой в email")
    @Test
    public void loginWithWrongInEmailTest() {
        var request = LoginUserModelRq.login(wrongEmail, password);
        String messageError = loginUser.loginWithWrong(request);

        Checks.checkResult(expected, messageError);

    }


    @DisplayName("Логин существующего пользователя с ошибкой в password")
    @Test
    public void loginWithWrongInPasswordTest() {
        var request = LoginUserModelRq.login(email, wrongPassword);
        String messageError = loginUser.loginWithWrong(request);

        Checks.checkResult(expected, messageError);

    }
}
