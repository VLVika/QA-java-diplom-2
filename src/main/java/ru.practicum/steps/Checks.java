package ru.practicum.steps;

import org.junit.Assert;

public class Checks {

    public static void checkResult(String expected, String messageError) {
        Assert.assertEquals("Ошибка!!! Ожидали сообщение --->" + expected + "<--Получили-->" + messageError, expected, messageError);
    }
}
