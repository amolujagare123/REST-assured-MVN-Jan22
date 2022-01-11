package chatserver;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayloads.createUserPayload;

public class CreateUserDataProviderExcel {


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
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/MyData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount =sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount]; // row x col --> ( records x inputs )

        for(int i=0; i<rowCount ;i++)
        {
            XSSFRow row = sheet.getRow(i);

            data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
            data[i][2] = row.getCell(2).toString();
            data[i][3] = row.getCell(3).toString();
            data[i][4] = row.getCell(4).toString();
            data[i][5] = row.getCell(5).toString();
        }


     /*   data[0][0] = "laxman11";
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
*/
        return data;
    }
}
