package chatserver;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {


    @Test
    public void getUsersTest()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all().auth().preemptive().basic("admin","admin123")
                .when().get("/restapi/getusers").then().log().all().assertThat().statusCode(200);
    }
}
