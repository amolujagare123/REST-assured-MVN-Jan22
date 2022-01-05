package chatserver;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUser {


    @Test
    public void getUser()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";
        given().log().all().auth().preemptive().basic("admin","admin123")
                .when().get("/restapi/user/26")
                .then().log().all().assertThat().statusCode(200);

    }
}
