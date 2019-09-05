package reqres.api.apiTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqres.api.models.usersModels.listOfUsersResponseModel.ListOfUsersResponseModel;
import reqres.api.models.usersModels.singleUserResponseModel.SingleUserResponseModel;
import reqres.api.services.usersApiService.UsersApiService;
import reqres.api.steps.LoginSteps;

import static org.testng.Assert.assertEquals;
import static reqres.api.conditions.Conditions.statusCode;
import static reqres.api.dataHelpers.DataGenerator.getFakerRandomNumberInt;

public class UsersGetTest {

    UsersApiService usersApiService = new UsersApiService();
    LoginSteps loginSteps = new LoginSteps();

    private String authToken = "";

    @BeforeClass
    public void setupToken(){
        authToken = loginSteps.loginUser_returnAuthToken();
    }

    @Test
    public void getListOfUsers(){
        ListOfUsersResponseModel usersResponseModel = usersApiService
                .getListOfUsers(authToken, 2)
                .shouldHave(statusCode(200))
                .responseAs(ListOfUsersResponseModel.class);

        assertEquals(usersResponseModel.getPage(), 2, "The page number don`t equal to 2");
    }

    @Test
    public void getSingleUser(){
        SingleUserResponseModel singleUserResponseModel = usersApiService
                .getSingleUser(authToken, 6)
                .shouldHave(statusCode(200))
                .responseAs(SingleUserResponseModel.class);

        assertEquals(singleUserResponseModel.getData().getId(), 6, "The user id doesn`t equal 6");
    }

    @Test
    public void getUserByUnrealId(){
      usersApiService
                .getSingleUser(authToken, getFakerRandomNumberInt(3))
                .shouldHave(statusCode(404));
    }

}
