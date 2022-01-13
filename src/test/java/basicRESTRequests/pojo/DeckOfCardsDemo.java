package basicRESTRequests.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.DrawCardResponsePOJO;
import pojo.ShuffeDeckResponsePOJO;

import static io.restassured.RestAssured.given;

public class DeckOfCardsDemo {


    @Test
    public void deckTest() throws JsonProcessingException {
        RestAssured.baseURI ="https://deckofcardsapi.com";

        ShuffeDeckResponsePOJO ob =   given().log().all().queryParam("deck_count","1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200).extract().as(ShuffeDeckResponsePOJO.class);

        System.out.println("deckId="+ob.getDeck_id());


        DrawCardResponsePOJO drawCards = given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+ob.getDeck_id()+"/draw/")
                .then().log().all().statusCode(200).extract().as(DrawCardResponsePOJO.class);

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(drawCards);

        System.out.println(jsonString);


    }


}
