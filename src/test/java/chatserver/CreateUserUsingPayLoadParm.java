package chatserver;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayloads.createUserPayload;

public class CreateUserUsingPayLoadParm {


    @Test
    public void createUSerTest()
    {
        RestAssured.baseURI ="http://localhost:80/chat/lhc_web/index.php/site_admin";

       /* String CreateUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(createUserPayload("jayashree","jayashre123",
                        "j@gmail.com","jayashree","k","jaya"))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();*/


        String myUsername = "Amar";
        String myPassword = "amar123";
        String myEmail = "a@gmail.com";
        String myName = "Amar";
        String mySurname = "T";
        String myNickname = "amar-xyz";


        String CreateUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(createUserPayload(myUsername,myPassword,myEmail,myName,mySurname,myNickname))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

    }
}
