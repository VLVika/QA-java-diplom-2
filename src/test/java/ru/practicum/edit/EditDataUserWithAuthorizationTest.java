package ru.practicum.edit;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.pojo.EditFieldsModelRq;
import ru.practicum.steps.EditDataUser;

@DisplayName("Изменение данных пользователя")
public class EditDataUserWithAuthorizationTest extends CreateDeleteUser {

    EditDataUser editField = new EditDataUser();


    @DisplayName("Изменение данных в поле email авторизированного пользователя")
    @Test
    public void editFieldEmailWithAuthorizationTest() {

        var request = EditFieldsModelRq.editEmailField();
         editField.editFieldEmailUser(request, token);
    }


    @DisplayName("Изменение данных в поле name авторизированного пользователя")
    @Test
    public void editFieldNameWithAuthorizationTest() {

        var request = EditFieldsModelRq.editNameField();
        editField.editFieldNameUser(request, token);
    }


    @DisplayName("Изменение данных в поле password авторизированного пользователя")
    @Test
    public void editFieldPasswordWithAuthorizationTest() {

        var request = EditFieldsModelRq.editPasswordField();
        editField.editFieldPasswordUser(request, token);
    }

}
