package api.endpoints;

// CRUD operations of Pet

import api.payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndPoints {

    public static Response createPet(Pet payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_pet);

        return response;

    }

    public static Response updatePet(Pet payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.update_pet);

        return response;

    }

    public static Response updatePetByForm(String petId,String name, String status){
        String strBody= "name="+name+"&status="+status;
        Response response = given().with()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .accept(ContentType.JSON)
                .body(strBody)
                .when()
                .post(Routes.update_pet_by_form+petId);
        return response;

    }

    public static Response getPetById(String petId){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("petId",petId)
                .when()
                .get(Routes.get_pet_by_id);
        return response;
    }

    public static Response getPetByStatus(String status){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("status",status)
                .when()
                .get(Routes.get_pet_by_status);
        return response;
    }

    public static Response deletePet(String petId){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("petId",petId)
                .when()
                .delete(Routes.delete_pet);
        return response;

    }

}
