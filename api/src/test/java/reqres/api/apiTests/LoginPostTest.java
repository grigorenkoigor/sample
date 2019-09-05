package reqres.api.apiTests;

import org.testng.annotations.Test;
import reqres.api.models.loginModels.LoginRequestModel;
import reqres.api.services.loginApiService.LoginApiService;

import static org.hamcrest.Matchers.containsString;
import static reqres.api.conditions.Conditions.bodyField;
import static reqres.api.conditions.Conditions.statusCode;
import static reqres.api.properties.UserProp.USER_NAME_LOGIN;
import static reqres.api.properties.UserProp.USER_PASSWORD;

public class LoginPostTest {

    LoginApiService loginApiService = new LoginApiService();

    @Test(description = "Successful login")
    public void login() {
        LoginRequestModel loginRequestModel = new LoginRequestModel()
                .setEmail(USER_NAME_LOGIN)
                .setPassword(USER_PASSWORD);

        loginApiService
                .doLogin(loginRequestModel)
                .shouldHave(statusCode(200));
    }

    @Test(description = "Unsuccessful login")
    public void loginIncorrectCredentials() {
        LoginRequestModel loginRequestModel = new LoginRequestModel()
                .setEmail(USER_NAME_LOGIN);

        loginApiService
                .doLogin(loginRequestModel)
                .shouldHave(statusCode(400),
                        bodyField("error", containsString("Missing password")));
    }
}
