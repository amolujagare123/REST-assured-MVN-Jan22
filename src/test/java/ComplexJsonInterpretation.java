import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static payload.Sample.getSamplePayLoad;

public class ComplexJsonInterpretation {


    @Test
    public void testJson()
    {

        String myJson = getSamplePayLoad();

        JsonPath js = new JsonPath(myJson);

        int coursesCount = js.get("courses.size()");

        System.out.println("coursesCount="+coursesCount);

        int purchaseAmount = js.get("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);

        String course1 = js.get("courses[0].title");
        System.out.println("course1="+course1);

        System.out.println("===== All courses ======");


        for(int i=0;i<coursesCount;i++)
        {
            String courseName = js.getString("courses["+i+"].title");
            String coursePrice =  js.getString("courses["+i+"].price");

            System.out.println("Course "+(i+1)+" Name="+courseName);
            System.out.println("course "+(i+1)+" Price="+coursePrice);

        }





    }

}
