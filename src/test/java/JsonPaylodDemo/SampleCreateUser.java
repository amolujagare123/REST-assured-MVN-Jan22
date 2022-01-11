package JsonPaylodDemo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class SampleCreateUser {


    @Test
    public void createUser() throws IOException {
        RestAssured.baseURI="https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("D:\\sampleAPI.json"))))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .time(lessThan(Long.parseLong("2000")), TimeUnit.MILLISECONDS)
                .body("job",equalTo("manager"));
    }
}
