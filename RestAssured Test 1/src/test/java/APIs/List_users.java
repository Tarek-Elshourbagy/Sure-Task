package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class List_users {

    // Method to get the list of users (or unknown items if that's the intent)
    public Response List_of_user() {
        // Set base URI for the API
        RestAssured.baseURI = "https://reqres.in";

        // Send GET request to the /api/users endpoint to get a list of users (or /api/unknown if that's intended)
        Response response = given()
                .log().all() // Logs the request for debugging
                .header("Content-Type", "application/json")
                .when()
                .get("/api/users")  // This should be the correct endpoint for users
                .then()
                .log().all()  // Logs the response for debugging
                .assertThat()
                .statusCode(200)  // Verify the status code is 200 (OK)
                .extract()
                .response(); // Extract the entire response object for further use

        // Return the full response object
        return response;
    }
}
