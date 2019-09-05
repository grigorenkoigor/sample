package reqres.api.apiTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqres.api.models.usersModels.updateUserModels.UpdateUserRequestModel;
import reqres.api.models.usersModels.updateUserModels.UpdateUserResponseModel;
import reqres.api.services.usersApiService.UsersApiService;
import reqres.api.steps.LoginSteps;

import static org.testng.Assert.assertEquals;
import static reqres.api.conditions.Conditions.statusCode;
import static reqres.api.dataHelpers.DataGenerator.getFakerUserJob;
import static reqres.api.dataHelpers.DataGenerator.getFakerUserName;

public class UpdateUserPutTest {

    UsersApiService usersApiService = new UsersApiService();
    LoginSteps loginSteps = new LoginSteps();

    private String authToken;

    @BeforeClass
    public void setupToken() {
        authToken = loginSteps.loginUser_returnAuthToken();
    }

    @Test(description = "Update user by model")
    public void updateUser() {
        UpdateUserRequestModel updateUserRequestModel = new UpdateUserRequestModel()
                .setJob(getFakerUserJob())
                .setName(getFakerUserName());

        UpdateUserResponseModel updateUserResponseModel = usersApiService
                .updateUser(authToken, 2, updateUserRequestModel)
                .shouldHave(statusCode(200))
                .responseAs(UpdateUserResponseModel.class);

        assertEquals(updateUserResponseModel.getJob(), updateUserRequestModel.getJob(), "Users job does not update");
        assertEquals(updateUserResponseModel.getName(), updateUserRequestModel.getName(), "Users name does not update");
    }
}
