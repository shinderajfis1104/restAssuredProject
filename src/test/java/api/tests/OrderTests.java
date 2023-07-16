package api.tests;

import api.endpoints.StoreEndPoints;
import api.payloads.Order;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderTests {

    Order orderPayload;

    @BeforeClass
    public void setuppaylod(){

        orderPayload = new Order();

        orderPayload.setId("15");
        orderPayload.setPetid("1421a");
        orderPayload.setQuantity("200");
        orderPayload.setShipdate("2023-07-11T14:55:45.754Z");
        orderPayload.setStatus("placed");
        orderPayload.setComplete(Boolean.TRUE);
    }

    @Test()
    public void testOrder(){
        Response response = StoreEndPoints.createOrder(orderPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = StoreEndPoints.getOrder("15");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = StoreEndPoints.deleteOrder("15");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = StoreEndPoints.getOrder("15");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);

        response = StoreEndPoints.getOrderInventory();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }




}
