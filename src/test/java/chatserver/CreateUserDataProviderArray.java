package chatserver;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static payload.ChatServerPayloads.createUserPayload;

public class CreateUserDataProviderArray {


    @Test (dataProvider = "getData")
    public void createUserTest(String myUsername,String myPassword,String myEmail
    ,String myName,String mySurname,String myNickname)
    {
        RestAssured.baseURI ="http://localhost:80/chat/lhc_web/index.php/site_admin";


        String CreateUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(createUserPayload(myUsername,myPassword,myEmail,myName,mySurname,myNickname))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[3][6]; // row x col --> ( records x inputs )

        data[0][0] = "laxman11";
        data[0][1] = "laxman123";
        data[0][2] = "l@gmail.com";
        data[0][3] = "Laxman";
        data[0][4] = "P";
        data[0][5] = "l-xyz";

        data[1][0] = "chetan11";
        data[1][1] = "chetan123";
        data[1][2] = "c@gmail.com";
        data[1][3] = "Chetan";
        data[1][4] = "G";
        data[1][5] = "c-xyz";

        data[2][0] = "depthi11";
        data[2][1] = "depthi123";
        data[2][2] = "d@gmail.com";
        data[2][3] = "Depthi";
        data[2][4] = "V";
        data[2][5] = "d-xyz";

        return data;
    }
}
