package ru.practicum.edit;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.methods.CreateDeleteUser;
import ru.practicum.pojo.EditFieldsModelRq;
import ru.practicum.steps.Checks;
import ru.practicum.steps.EditDataUser;

@DisplayName("Изменение данных пользователя")
public class EditDataUserNoAuthorizationTest extends CreateDeleteUser {

    EditDataUser editField = new EditDataUser();
    String expected = "You should be authorised";


    @DisplayName("Изменение данных в поле email не авторизированного пользователя")
    @Test
    public void editFieldEmailNoAuthorizationTest() {

        var request = EditFieldsModelRq.editEmailField();
        String messageError = editField.editFieldEmailUserNoAuthor(request);

        Checks.checkResult(expected, messageError);
    }


    @DisplayName("Изменение данных в поле name не авторизированного пользователя")
    @Test
    public void editFieldNameNoAuthorizationTest() {

        var request = EditFieldsModelRq.editNameField();
        String messageError = editField.editFieldNameUserNoAuthor(request);

        Checks.checkResult(expected, messageError);
    }


    @DisplayName("Изменение данных в поле password не авторизированного пользователя")
    @Test
    public void editFieldPasswordNoAuthorizationTest() {

        var request = EditFieldsModelRq.editPasswordField();
        String messageError = editField.editFieldPasswordUserNoAuthor(request);

        Checks.checkResult(expected, messageError);
    }


}
