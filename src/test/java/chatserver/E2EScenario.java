package chatserver;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class E2EScenario {



    @Test
    public void chatTest()
    {
        RestAssured.baseURI ="http://localhost:80/chat/lhc_web/index.php/site_admin";

        String CreateUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"username\": \"vaishali24\",\n" +
                        "  \"password\": \"vaishali123\",\n" +
                        "  \"email\": \"vaishali@example.org\",\n" +
                        "  \"name\": \"vaishali\",\n" +
                        "  \"surname\": \"xyz\",\n" +
                        "  \"chat_nickname\": \"v-xyz\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(CreateUserResponse);
        int id = js.getInt("result.id");

        System.out.println("user id="+id);

        String email = "vaishali@gmail.com";

        given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \n" +
                        "  \"email\": \""+email+"\"\n" +
                        "  \n" +
                        "}")
                .when().put("/restapi/user/"+id)
                .then().log().all().assertThat().statusCode(200);

        String getUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .when().get("/restapi/user/"+id)
                .then().log().all().assertThat().statusCode(200).extract().response().asString()
        /*.body("result.email",equalTo(email))*/;

        JsonPath js1 = new JsonPath(getUserResponse);

        String actualEmail = js1.getString("result.email");

        System.out.println("Expected="+email);
        System.out.println("Actual="+actualEmail);

        Assert.assertEquals("incorrect email email not retrieved",email,actualEmail);

    }
}
