package basicRESTRequests.pojo;

import io.restassured.RestAssured;
import org.junit.Test;
import pojo.SampleUserPOJO;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class createUser {

    @Test
    public void createUserTest()
    {
        RestAssured.baseURI="https://reqres.in";

        SampleUserPOJO sampleUserPOJO = new SampleUserPOJO();
        sampleUserPOJO.setName("Sameer");
        sampleUserPOJO.setJob("Java trainer");

        given().log().all().header("Content-Type","application/json")
                .body(sampleUserPOJO)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .time(lessThan(Long.parseLong("2000")), TimeUnit.MILLISECONDS)
                .body("job",equalTo("Java trainer"));
    }
}
