package ru.practicum.methods;

import org.junit.After;
import org.junit.Before;
import ru.practicum.pojo.CreateUserModelRq;
import ru.practicum.pojo.CreateUserPojoRq;
import ru.practicum.steps.CreateUser;
import ru.practicum.steps.DeleteUser;

public class CreateDeleteUser {

    CreateUser user = new CreateUser();
    protected String token;
    protected CreateUserPojoRq request;

    @Before
    public void createUserBeforeTest(){
        request = CreateUserModelRq.newUserAllFieldsRandom();
        token = user.createNewUserAndGetToken(request);
    }

    @After
    public void deleteUserAfterTest(){
        DeleteUser.deleteUser(token);
    }

}
