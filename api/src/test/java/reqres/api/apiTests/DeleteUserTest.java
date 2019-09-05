package reqres.api.apiTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqres.api.services.usersApiService.UsersApiService;
import reqres.api.steps.LoginSteps;

import static reqres.api.conditions.Conditions.statusCode;

public class DeleteUserTest {

    UsersApiService usersApiService = new UsersApiService();
    LoginSteps loginSteps = new LoginSteps();

    private String authToken = "";

    @BeforeClass
    public void setupToken() {
        authToken = loginSteps.loginUser_returnAuthToken();
    }

    @Test
    public void deleteUserById() {
        usersApiService
                .deleteUser(authToken, 2)
                .shouldHave(statusCode(204));
    }
}
