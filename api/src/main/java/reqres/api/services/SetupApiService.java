package reqres.api.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static reqres.api.properties.UrlLinksProp.MAIN_URL;

public class SetupApiService {

    protected RequestSpecification setup(){
        return RestAssured.given()
                .baseUri(MAIN_URL)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured());
    }
}
