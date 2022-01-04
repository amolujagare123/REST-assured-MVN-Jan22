package basicRESTRequests;

import io.restassured.RestAssured;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
//import static org.hamcrest.Matchers.equalTo;

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
                .then().log().all().assertThat().statusCode(201)
        .time(lessThan(Long.parseLong("2000")), TimeUnit.MILLISECONDS)
        .body("job",equalTo("leader"))
    ;
    }

}
