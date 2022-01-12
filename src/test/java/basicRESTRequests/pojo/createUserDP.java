package basicRESTRequests.pojo;

import io.restassured.RestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.SampleUserPOJO;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class createUserDP {

    @Test (dataProvider = "getData")
    public void createUserTest(String name,String job)
    {
        RestAssured.baseURI="https://reqres.in";

        SampleUserPOJO sampleUserPOJO = new SampleUserPOJO();
        sampleUserPOJO.setName(name);
        sampleUserPOJO.setJob(job);

        given().log().all().header("Content-Type","application/json")
                .body(sampleUserPOJO)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .time(lessThan(Long.parseLong("2000")), TimeUnit.MILLISECONDS)
                .body("job",equalTo(job));
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = {

                {"rajesh","tester"},
                {"amol","dev"},
                {"sameer","lead"}

        };

        return data;
    }

}
