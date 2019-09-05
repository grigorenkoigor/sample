package reqres.api.apiTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqres.api.models.usersModels.createUserModels.CreateUserRequestModel;
import reqres.api.models.usersModels.createUserModels.CreateUserResponseModel;
import reqres.api.services.usersApiService.UsersApiService;
import reqres.api.steps.LoginSteps;

import static org.testng.Assert.assertEquals;
import static reqres.api.conditions.Conditions.statusCode;
import static reqres.api.dataHelpers.DataGenerator.getFakerUserJob;
import static reqres.api.dataHelpers.DataGenerator.getFakerUserName;

public class CreateUserPostTest {

    UsersApiService usersApiService = new UsersApiService();
    LoginSteps loginSteps = new LoginSteps();

    private String authToken;

    @BeforeClass
    public void setupToken() {
        authToken = loginSteps.loginUser_returnAuthToken();
    }

    @Test(description = "Create new user by model")
    public void createNewUser() {
        CreateUserRequestModel createUserRequestModel = new CreateUserRequestModel()
                .setJob(getFakerUserJob())
                .setName(getFakerUserName());

        CreateUserResponseModel createUserResponseModel = usersApiService
                .createNewUser(authToken, createUserRequestModel)
                .shouldHave(statusCode(201))
                .responseAs(CreateUserResponseModel.class);

        assertEquals(createUserResponseModel.getName(), createUserRequestModel.getName());
        assertEquals(createUserResponseModel.getJob(), createUserRequestModel.getJob());
    }
}
