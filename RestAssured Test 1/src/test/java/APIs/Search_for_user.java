package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Search_for_user {

    public Response search_for_user(int ID) {
        // Set the base URI for the API
        RestAssured.baseURI = "https://reqres.in";

        // Send the GET request to search for the user by ID
        Response response = given()
                .log().all()  // Log request details
                .header("Content-Type", "application/json")  // Set content type header
                .when()
                .get("/api/unknown/" + ID)  // Make the GET request for the specific user ID
                .then()
                .log().all()  // Log response details for debugging purposes
                .assertThat()
                .statusCode(200)  // Assert that the status code is 200 OK
                .body("data.name", equalTo("cerulean"))  // Assert that the 'name' field in the response is 'cerulean'
                .body("data.id", equalTo(ID))  // Optionally assert that the 'id' matches the provided ID
                .extract().response();  // Extract the response object

        // Return the response object
        return response;
    }
}
