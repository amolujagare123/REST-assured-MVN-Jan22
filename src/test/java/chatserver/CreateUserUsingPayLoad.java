package chatserver;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayloads.createUserPayload;

public class CreateUserUsingPayLoad {


    @Test
    public void createUSerTest()
    {
        RestAssured.baseURI ="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String CreateUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(createUserPayload())
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

    }
}
