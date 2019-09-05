package reqres.api.services.registerApiService;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import reqres.api.AssertableResponse;
import reqres.api.models.registerModels.RegisterRequestModel;
import reqres.api.services.SetupApiService;

@Slf4j
public class RegisterApiService extends SetupApiService {

    @Step("Send POST api/register")
    public AssertableResponse register(RegisterRequestModel registerRequestModel) {
        log.info("register user by model {}", registerRequestModel);
        Response response =
                setup()
                .given()
                .body(registerRequestModel)
                .when()
                .post("register")
                .then().extract().response();
        return new AssertableResponse(response);
    }
}
