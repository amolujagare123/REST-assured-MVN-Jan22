package JsonPaylodDemo;

import io.restassured.RestAssured;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayloads.createUserPayload;

public class chatServerCreateUser {

    @Test
    public void createUSerTest() throws IOException {
        RestAssured.baseURI ="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String CreateUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("jsonpaylods/chatServerCreateUser.json"))))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

    }
}
