package ru.practicum.methods;

import java.util.ArrayList;
import java.util.List;

public class GetIngredientsAndCreateList {

    static List<String> orderIngredients = new ArrayList<>();


    public static List<String> getIngredientsAndCreateList(List<String> ingredients) {
        for (int i = 0; i < 4; i++) {
            String inList = ingredients.get(i);
            orderIngredients.add(inList);
        }
        return orderIngredients;
    }
}
