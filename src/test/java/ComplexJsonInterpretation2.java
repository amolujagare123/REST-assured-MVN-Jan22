import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static payload.Sample.getSamplePayLoad;

public class ComplexJsonInterpretation2 {


    @Test
    public void testJson()
    {

        String myJson = getSamplePayLoad();

        JsonPath js = new JsonPath(myJson);

        int coursesCount = js.get("courses.size()");

        System.out.println("coursesCount="+coursesCount);

        int actualSum = 0;

        for(int i=0;i<coursesCount;i++)
        {
            int price = js.getInt("courses["+i+"].price");
            int copies =js.getInt("courses["+i+"].copies");
            int totalValue = price * copies ;

            actualSum = actualSum + totalValue;
        }


        int expectedPurchaseAmount = js.getInt("dashboard.purchaseAmount");

        System.out.println("expectedPurchaseAmount="+expectedPurchaseAmount);
        System.out.println("actualSum="+actualSum);


        Assert.assertEquals(actualSum,expectedPurchaseAmount,"wrong sum");



    }

}
