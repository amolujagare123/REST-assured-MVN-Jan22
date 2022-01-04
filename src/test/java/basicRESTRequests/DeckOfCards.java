package basicRESTRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeckOfCards {

    @Test
    public void myCards()
    {
        RestAssured.baseURI ="https://deckofcardsapi.com";

        String response = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle")
                .then().log().all().statusCode(200).extract().response().asString();

        System.out.println("\n====== Below is the printed response ======");
        System.out.println(response);

        JsonPath js = new JsonPath(response);

        String deckId =  js.getString("deck_id");

        System.out.println("Deck id =" + deckId);


        given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw")
                .then().log().all().assertThat().statusCode(200);


    }
}
