package stepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefination {
    ResponseSpecification res;
    RequestSpecification reqq;
    Response response;

    @Given("Add place Payload")
    public void add_place_payload() {
        RestAssured.baseURI = "https://rahulshettyacademy.com/";
        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress("Ostring 52");
        addPlace.setLanguage("Deutsch");
        addPlace.setPhone_number("+94923234234");
        addPlace.setWebsite("https//lsdjfjsdfsdf");
        addPlace.setName("Alex");
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("ldldld");
        addPlace.setTypes(myList);
        Location location = new Location();
        location.setLat(33.43);
        location.setLng(99.554);
        addPlace.setLocation(location);


        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();

        res =  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

         reqq = given().spec(req)
                .body(addPlace);

        Response response = reqq.when().post("maps/api/place/add/json")
                .then().spec(res).extract().response();
        String responseINString = response.asString();
        System.out.println(responseINString);
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {
        response = reqq.when().post("maps/api/place/add/json")
                .then().spec(res).extract().response();
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
       Assert.assertEquals( response.getStatusCode(),200);
    }
    @Then("{string}  in response body is {string}")
    public void in_response_body_is(String key, String value) {
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
       Assert.assertEquals( jsonPath.get(key).toString(), value);

    }
}
