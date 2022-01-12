package chatserver.pojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.ChatCreateUserPOJO;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayloads.createUserPayload;

public class createUser {

    @Test

    public void createUserTest()
    {
        RestAssured.baseURI ="http://localhost:80/chat/lhc_web/index.php/site_admin";

        ChatCreateUserPOJO chatCreateUserPOJO = new ChatCreateUserPOJO();
        chatCreateUserPOJO.setName("amol");
        chatCreateUserPOJO.setSurname("ujagare");
        chatCreateUserPOJO.setUsername("amol3210");
        chatCreateUserPOJO.setPassword("1234");
        chatCreateUserPOJO.setChat_nickname("am");
        chatCreateUserPOJO.setEmail("amol@gmail.com");

        ArrayList<Integer> dept = new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};

        chatCreateUserPOJO.setDepartments(dept);


        ArrayList<Integer> deptGrp = new ArrayList<Integer>(){{
            add(1);

        }};

        chatCreateUserPOJO.setDepartment_groups(deptGrp);

        ArrayList<Integer> usrGrp = new ArrayList<Integer>(){{
            add(1);

        }};

        chatCreateUserPOJO.setUser_groups(usrGrp);

        ArrayList<Integer> deptRead = new ArrayList<Integer>(){{

            add(2);
        }};

        chatCreateUserPOJO.setDepartments_read(deptRead);

        String CreateUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(chatCreateUserPOJO)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
    }
}
