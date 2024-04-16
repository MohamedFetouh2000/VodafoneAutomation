import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Breeds {
    public static String base = "https://catfact.ninja";

    @Test
    public void checkBreedsApiStatusCode (){
        RestAssured
                .given().baseUri(base)
                .when().get("/breeds")
                .then().log().ifValidationFails()
                .assertThat().statusCode(200);
    }

    @Test
    public void checkResponseSize(){
        RestAssured
                .given().baseUri(base)
                .when().get("/breeds")
                .then().log().ifValidationFails()
                .assertThat().body("data.size()" , equalTo(25) );
    }

    @Test
    public void checkResponseSchema(){
        RestAssured
                .given().baseUri(base)
                .when().get("/breeds")
                .then().log().ifValidationFails()
                .assertThat().body(matchesJsonSchemaInClasspath("Breeds.json"));
    }

    @Test
    public void checkSetLimit(){
        RestAssured
                .given().baseUri(base)
                .queryParam("limit", 5)
                .when().get("/breeds")
                .then().log().ifValidationFails()
                .assertThat().body("data.size()", equalTo(5));
    }
}
