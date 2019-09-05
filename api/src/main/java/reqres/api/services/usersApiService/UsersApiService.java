package reqres.api.services.usersApiService;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import reqres.api.AssertableResponse;
import reqres.api.models.usersModels.createUserRequestModel.CreateUserRequestModel;
import reqres.api.models.usersModels.updateUserRequestModel.UpdateUserRequestModel;
import reqres.api.services.SetupApiService;

@Slf4j
public class UsersApiService extends SetupApiService {

    @Step("Send GET api/users?params={pageNumber}")
    public AssertableResponse getListOfUsers(String token, int pageNumber) {
        log.info("Get list of users");
        Response response =
                setup()
                        .given()
                        .headers("token", token)
                        .param("page", pageNumber)
                        .when()
                        .get("users")
                        .then().extract().response();
        return new AssertableResponse(response);
    }

    @Step("Send GET api/users/{userId}")
    public AssertableResponse getSingleUser(String token, int userId) {
        log.info("Get single user");
        Response response =
                setup()
                        .given()
                        .headers("token", token)
                        .when()
                        .get("users/" + userId)
                        .then().extract().response();
        return new AssertableResponse(response);
    }

    @Step("Send POST api/users")
    public AssertableResponse createNewUser(String token, CreateUserRequestModel createUserRequestModel) {
        log.info("Create new user");
        Response response =
                setup()
                        .given()
                        .headers("token", token)
                        .body(createUserRequestModel)
                        .when()
                        .post("users")
                        .then().extract().response();
        return new AssertableResponse(response);
    }

    @Step("Send PUT api/users/{userId}")
    public AssertableResponse updateUser(String token, int userId, UpdateUserRequestModel updateUserRequestModel) {
        log.info("Update user");
        Response response =
                setup()
                        .given()
                        .headers("token", token)
                        .body(updateUserRequestModel)
                        .when()
                        .put("users/" + userId)
                        .then().extract().response();
        return new AssertableResponse(response);
    }

    @Step("Send DELETE api/users/{userId}")
    public AssertableResponse deleteUser(String token, int userId) {
        log.info("Delete user");
        Response response =
                setup()
                        .given()
                        .headers("token", token)
                        .when()
                        .delete("users/" + userId)
                        .then().extract().response();
        return new AssertableResponse(response);
    }
}
