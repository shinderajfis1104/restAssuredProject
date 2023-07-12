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

        orderPayload.setId(8);
        orderPayload.setPetid(1421);
        orderPayload.setQuantity(200);
        orderPayload.setShipdate("2023-07-11T14:55:45.754Z");
        orderPayload.setStatus("placed");
        orderPayload.setComplete(Boolean.TRUE);
    }

    @Test()
    public void testOrder(){
        Response response = StoreEndPoints.createOrder(orderPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = StoreEndPoints.getOrder(8);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        //response = StoreEndPoints.deleteOrder(8);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = StoreEndPoints.getOrder(8);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);

        response = StoreEndPoints.getOrderInventory();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }




}
