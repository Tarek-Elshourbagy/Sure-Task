package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Delete_user {

    public Response deleteUser(int ID) {
        RestAssured.baseURI = "https://reqres.in";

        // Send a DELETE request and return the response
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when().delete("/api/unknown/" + ID)
                .then().log().all()
                .assertThat()
                .statusCode(204)  // Assert that the status code is 204 (No Content)
                .extract().response();  // Extract the response object

        // Return the response for further validation
        return response;
    }
}
