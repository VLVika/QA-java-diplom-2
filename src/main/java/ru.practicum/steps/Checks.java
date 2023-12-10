package ru.practicum.steps;

import io.qameta.allure.Step;
import org.junit.Assert;

public class Checks {

    @Step("Проверяет, что полученное сообщение соответсвует ожидаемому")
    public static void checkResult(String expected, String messageError) {
        Assert.assertEquals("Ошибка!!! Ожидали сообщение --->" + expected + "<--Получили-->" + messageError, expected, messageError);
    }
}
