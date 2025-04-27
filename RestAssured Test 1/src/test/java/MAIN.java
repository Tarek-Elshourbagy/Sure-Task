import APIs.*;

import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.Test;


public class MAIN {
    //To generate report

    //Objects for all classes responses
    Create_new_user Request_01 = new Create_new_user();
    List_users Request_02 = new List_users();
    Search_for_user Request_03 = new Search_for_user();
    Update_user Request_04 = new Update_user();
    Delete_user Request_05 = new Delete_user();

    int ID = 1;

    //Req_1: create new user
    @Test
    public void TC_01_Create_User(){
        String name = "Tarek";
        int year = 1998;
        // Call the method to get the response
        Response response_01 = Request_01.Create_user(ID,name,year);
        // Verify the status code (201 is expected when a new resource is created)
        Assert.assertEquals(response_01.statusCode(), 201, "Expected status code is 201");
        // Verify the 'name' field in the response body
        Assert.assertEquals(response_01.jsonPath().getString("name"), name, "The name in the response should be " + name);
        // Verify the 'Year' field in the response body
        Assert.assertEquals(response_01.jsonPath().getInt("year"), year, "The year in the response should be " + year);
    }

    //Req_2: List of users _ an error (the user should be shown in the list)
    @Test
    public void TC_02_List_of_Users(){
        // Call the method to get the response
        Response response_02 = Request_02.List_of_user();
        // Verify the status code is 200
        Assert.assertEquals(response_02.statusCode(), 200, "Expected status code is 200");
        // Verify the number of users returned in this page (per_page should be 6)
        Assert.assertEquals(response_02.jsonPath().getInt("per_page"), 6, "Users per page should be 6");
        // Verify the total number of users (should be 12)
        Assert.assertEquals(response_02.jsonPath().getInt("total"), 12, "Total users should be 12");
        // Verify the first user's name
        String firstName = response_02.jsonPath().getString("data[0].first_name");
        Assert.assertEquals(firstName, "George", "First user's name should be George");
        // Verify that all users have an avatar URL
        for (int i = 0; i < 6; i++) {
            String avatarUrl = response_02.jsonPath().getString("data[" + i + "].avatar");
            Assert.assertNotNull(avatarUrl, "Avatar URL should not be null for user " + i);
        }
    }

    //Req_3: Search with user ID _an error (the user should be shown in the after searched
    @Test
    public void TC_03_Search_for_User(){
        // Call the method to get the response
        Response response_03 = Request_03.search_for_user(ID);
        // Additional assertions
        Assert.assertEquals(response_03.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response_03.jsonPath().getString("data.name"), "cerulean", "Name should be 'cerulean'");
        // You can also print the response or extract any data you need
        System.out.println("Response body: " + response_03.getBody().asString());
    }

    //Req_4: Update data for user
    @Test
    public void TC_04_Update_user(){
        // Call the method to get the response
        Response response_04 = Request_04.updateUser(ID);
        // Assertions to verify the response
        Assert.assertEquals(response_04.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response_04.jsonPath().getString("name"), "tarek", "User name should be 'tarek'");
        Assert.assertEquals(response_04.jsonPath().getInt("id"), ID, "User ID should match the updated ID");

    }
    //Req_5: Delete the user
    @Test
    public void TC_05_Delete_user(){
        // Call the method to get the response
        Response response_05 = Request_05.deleteUser(ID);
        // Assert the status code
        Assert.assertEquals(response_05.getStatusCode(), 204, "Status code should be 204 (No Content)");
    }

}
