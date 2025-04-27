package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Update_user {

    public Response updateUser(int ID) {
        // Base URI for the API
        RestAssured.baseURI = "https://reqres.in";

        // Sending a PUT request to update the user with the provided ID
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": " + ID + ",\n" +
                        "    \"name\": \"tarek\",\n" +
                        "    \"year\": 2000,\n" +
                        "    \"color\": \"#98B2D1\",\n" +
                        "    \"pantone_value\": \"15-4020\"\n" +
                        "}")
                .when()
                .put("/api/unknown/" + ID)
                .then()
                .log().all() // Log request and response details for inspection
                .assertThat()
                .statusCode(200)  // Assert that the status code is 200 (OK)
                .body("name", equalTo("tarek"))  // Assert that the name returned is "tarek"
                .body("id", equalTo(ID))  // Assert that the ID in response is the same as the input ID
                .extract().response(); // Extract and return the full response

        // Return the full response object
        return response;
    }
}
