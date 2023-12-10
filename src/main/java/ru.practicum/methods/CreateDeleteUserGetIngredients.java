package ru.practicum.methods;

import org.junit.Before;
import ru.practicum.pojo.CreateUserModelRq;
import ru.practicum.steps.Order;

import java.util.List;

public class CreateDeleteUserGetIngredients extends CreateDeleteUser{

    protected List<String> ingredients;

    @Override
    @Before
    public void createUserBeforeTest(){
        request = CreateUserModelRq.newUserAllFieldsRandom();
        email = request.getEmail();
        password = request.getPassword();
        token = user.createNewUserAndGetToken(request);

        ingredients = Order.getIngredients();


    }




}
