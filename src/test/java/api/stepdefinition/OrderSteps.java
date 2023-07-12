package api.stepdefinition;

import api.endpoints.StoreEndPoints;
import api.payloads.Order;
import api.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class OrderSteps extends StoreEndPoints {

    public static Response response;
    JsonPath js;
    public static String placeID;

    @Then("Status code is {int}")
    public void status_code_is(Integer int1) {
        System.out.println("Status Code: "+response.statusCode());
        Assert.assertTrue(response.statusCode()==int1);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String value1, String value2) {
        System.out.println("Status Code: "+response.statusLine());
        Assert.assertTrue(response.statusLine().contains(value2));
    }

    @Then("I retrieve the Place ID")
    public void i_retrieve_the_place_id() {
        js = Utilities.rawToJson(response);
        placeID = js.get("place_id");
        System.out.println("Place ID: "+placeID);
    }


    @Given("User creates order with parameters id {int} and petId {int} and quantity {int} shipdate {string} and status {string} and complete {string}")
    public void userCreatesOrderWithParametersIdAndPetIdAndQuantityShipdateAndStatusAndComplete(int arg0, int arg1, int arg2, String arg3, String arg4, String arg5) {
        Order orderPayload = new Order();

        orderPayload.setId(arg0);
        orderPayload.setPetid(arg1);
        orderPayload.setQuantity(arg2);
        orderPayload.setShipdate(arg3);
        orderPayload.setStatus(arg4);
        if (arg5=="True")
            orderPayload.setComplete(Boolean.TRUE);
        else
            orderPayload.setComplete(Boolean.FALSE);

        response = StoreEndPoints.createOrder(orderPayload);
    }

    @Given("User fetches the order details by orderId {int}")
    public void userFetchesTheOrderDetailsByOrderId(int arg0) {
        response = StoreEndPoints.getOrder(arg0);
    }

    @Given("User deletes the order by orderId {int}")
    public void userDeletesTheOrderByOrderId(int arg0) {
        //StoreEndPoints.deleteOrder(arg0);
    }

    @Given("User deletes the order by orderId {string}")
    public void userDeletesTheOrderByOrderId(String arg0) {

        try
        {
            response = StoreEndPoints.deleteOrder(arg0);
        }
        catch(NumberFormatException e){
            System.out.println("******* Error Message******"+e.getMessage());
            //Response res = new Response("This is my message");
        }

    }
}
