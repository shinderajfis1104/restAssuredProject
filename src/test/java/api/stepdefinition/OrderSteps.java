package api.stepdefinition;

import api.endpoints.StoreEndPoints;
import api.payloads.Order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;

public class OrderSteps extends CommonSteps{

    JsonPath jsonPathEvaluator;
    //public Response response;
    @Given("User creates order with parameters id {string} and petId {string} and quantity {string} shipdate {string} and status {string} and complete {string}")
    public void userCreatesOrderWithParametersIdAndPetIdAndQuantityShipdateAndStatusAndComplete(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
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

    @Given("User fetches the order details by orderId {string}")
    public void userFetchesTheOrderDetailsByOrderId(String arg0) {
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

    @Given("User fetches the inventory")
    public void userFetchesTheInventory() {
        response = StoreEndPoints.getOrderInventory();
        response.then().log().all();
    }

    @And("Inventory with Status {string} and count {int} is found")
    public void inventoryWithStatusAndCountIsFound(String arg0, int arg1) {
        if(response.statusCode()==200 && arg0 !="") {
            jsonPathEvaluator = response.jsonPath();
            //HashMap<String,Integer> status = jsonPathEvaluator.getJsonObject("json");

            //Assert.assertTrue(status.containsKey(arg0));
            Assert.assertEquals(jsonPathEvaluator.get(arg0),Integer.valueOf(arg1));
        }
        else {
            System.out.println("No Info");
        }
    }
}
