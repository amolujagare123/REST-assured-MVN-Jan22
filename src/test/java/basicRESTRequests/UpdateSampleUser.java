package basicRESTRequests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateSampleUser {

    @Test
    public void updateSampleUser()
    {
        RestAssured.baseURI="https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200);
    }

}
