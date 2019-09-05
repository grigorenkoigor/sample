package reqres.api.steps;

import io.qameta.allure.Step;
import reqres.api.models.loginModels.LoginRequestModel;
import reqres.api.services.loginApiService.LoginApiService;

import static reqres.api.conditions.Conditions.statusCode;
import static reqres.api.properties.UserProp.USER_NAME_LOGIN;
import static reqres.api.properties.UserProp.USER_PASSWORD;

public class LoginSteps {

    LoginApiService loginApiService = new LoginApiService();

    @Step("Login user and return AuthToken")
    public String loginUser_returnAuthToken() {
        LoginRequestModel loginRequestModel = new LoginRequestModel()
                .setEmail(USER_NAME_LOGIN)
                .setPassword(USER_PASSWORD);

        return loginApiService
                .doLogin(loginRequestModel)
                .shouldHave(statusCode(200))
                .getBodyByPath("token");
    }
}
