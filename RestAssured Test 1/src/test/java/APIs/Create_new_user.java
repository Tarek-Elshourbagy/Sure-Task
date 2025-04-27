package APIs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Create_new_user {

    // Method to create a new user
    public Response Create_user(int ID, String name, int year) {
        // Set the base URI for the API
        RestAssured.baseURI = "https://reqres.in";

        // Define the request body as a JSON string
        String requestBody = "{\n" +
                "    \"id\": " + ID + ",\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"year\": " + year + ",\n" +
                "    \"color\": \"#98B2D1\",\n" +
                "    \"pantone_value\": \"15-4020\"\n" +
                "}";

        // Send a POST request to create a user and capture the response
        Response response = given()
                .log().all()  // Logs the request for debugging purposes
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/api/unknown")  // API endpoint
                .then()
                .log().all()  // Logs the response for debugging purposes
                .assertThat()
                .statusCode(201)  // Verify the status code is 201 (Created)
                .body("name", equalTo(name))  // Verify the name in the response body matches the provided name
                .extract()
                .response();  // Extract the response to a Response object

        // Return the full response object
        return response;
    }
}

