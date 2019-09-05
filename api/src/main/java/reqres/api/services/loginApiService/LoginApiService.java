package reqres.api.services.loginApiService;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import reqres.api.AssertableResponse;
import reqres.api.models.loginModels.LoginRequestModel;
import reqres.api.services.SetupApiService;

@Slf4j
public class LoginApiService extends SetupApiService {

    @Step("Send POST api/login")
    public AssertableResponse doLogin(LoginRequestModel loginRequestModel) {
        log.info("login user by model {}", loginRequestModel);
        Response response =
                setup()
                        .given()
                        .body(loginRequestModel)
                        .when()
                        .post("login")
                        .then().extract().response();
        return new AssertableResponse(response);
    }
}
