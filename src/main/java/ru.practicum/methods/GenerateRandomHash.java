package ru.practicum.methods;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class GenerateRandomHash {

//Метод создает рандомное значение id ингредиента и формирует лист

    protected static ArrayList<String> randomId;


    public static ArrayList<String> generateListWithRandomIdIngredients() {
        String id = RandomStringUtils.randomAlphanumeric(24);
        id.toLowerCase(Locale.ROOT);
        return randomId = new ArrayList<>(Arrays.asList(id));

    }
}
