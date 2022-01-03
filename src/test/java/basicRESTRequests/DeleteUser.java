package basicRESTRequests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    public void deleteUser()
    {
        RestAssured.baseURI="https://reqres.in";

        given().log().all()
                .when().delete("/api/users/2")
                .then().log().all().assertThat().statusCode(204);

    }
}
