package ru.practicum.methods;

import io.qameta.allure.Step;

import java.util.*;

public class GetIngredientsAndCreateList {

    static List<String> orderIngredients = new ArrayList<>();

    @Step("Берет из списка рандомные ингредиенты и формирует List с набором из 4х ингредиентов")
    public static List<String> getIngredientsAndCreateList(List<String> ingredients){
        for(int i=0; i<4; i++){
            String inList = ingredients.get(i);
            orderIngredients.add(inList);
        }
        return orderIngredients;
    }
}
