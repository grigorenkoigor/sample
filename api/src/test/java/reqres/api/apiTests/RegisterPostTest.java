package reqres.api.apiTests;

import org.testng.annotations.Test;
import reqres.api.models.registerModels.RegisterRequestModel;
import reqres.api.models.registerModels.RegisterResponseModel;
import reqres.api.services.registerApiService.RegisterApiService;
import static org.hamcrest.Matchers.containsString;
import static reqres.api.conditions.Conditions.bodyField;
import static reqres.api.conditions.Conditions.statusCode;

public class RegisterPostTest {

    RegisterApiService registerApiService = new RegisterApiService();

    @Test(description = "Successful register")
    public void registerSuccessful() {
        RegisterRequestModel registerRequestModel = new RegisterRequestModel()
                .setEmail("eve.holt@reqres.in")
                .setPassword("pistol");

        registerApiService
                .register(registerRequestModel)
                .shouldHave(statusCode(200))
                .responseAs(RegisterResponseModel.class);
    }

    @Test(description = "Unsuccessful register")
    public void registerUnsuccessful() {
        RegisterRequestModel registerRequestModel = new RegisterRequestModel()
                .setEmail("eve.holt@reqres.in");

        registerApiService
                .register(registerRequestModel)
                .shouldHave(statusCode(400),
                        bodyField("error", containsString("Missing password")));
    }
}
