import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Courses;
import pojo.Dashboard;
import pojo.SampleCoplexJsonPojo;

import java.util.ArrayList;

public class ComplexJsonPrintPojo {

    public static void main(String[] args) throws JsonProcessingException {

        Dashboard dashboard = new Dashboard();
        dashboard.setPurchaseAmount(1000);
        dashboard.setWebsite("facebbok.com");

        ArrayList<Courses> courses = new ArrayList<>();

        Courses ob1 = new Courses();
        ob1.setTitle("Software testing");
        ob1.setPrice(150);
        ob1.setCopies(10);

        Courses ob2 = new Courses();
        ob2.setTitle("Selenium");
        ob2.setPrice(200);
        ob2.setCopies(9);

        Courses ob3 = new Courses();
        ob3.setTitle("Cucumber");
        ob3.setPrice(100);
        ob3.setCopies(5);

        courses.add(ob1);
        courses.add(ob2);
        courses.add(ob3);


        SampleCoplexJsonPojo sampleCoplexJsonPojo = new SampleCoplexJsonPojo();

        sampleCoplexJsonPojo.setDashboard(dashboard);
        sampleCoplexJsonPojo.setCourses(courses);


        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(sampleCoplexJsonPojo);

        System.out.println(jsonString);


    }
}
