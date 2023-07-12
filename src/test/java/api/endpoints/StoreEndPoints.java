package api.endpoints;

import api.payloads.Order;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


// CRUD operations of Store


public class StoreEndPoints {

    public static Response createOrder(Order payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_order);

        return response;

    }

    public static Response getOrder(int orderId){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("orderId",orderId)
                .when()
                .get(Routes.get_order);
        return response;
    }

    public static Response deleteOrder(String orderId){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("orderId",orderId)
                .when()
                .delete(Routes.delete_order);
        return response;

    }

    public static Response getOrderInventory(){
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get(Routes.get_store_inventory);
        return response;
    }

}
