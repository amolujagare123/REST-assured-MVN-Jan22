package basicRESTRequests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateSampleUser {

    @Test
    public void createUserTest()
    {
        RestAssured.baseURI="https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

}
