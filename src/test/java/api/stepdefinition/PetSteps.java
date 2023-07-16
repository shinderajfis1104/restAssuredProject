package api.stepdefinition;

import api.endpoints.PetEndPoints;
import api.payloads.Category;
import api.payloads.Pet;
import api.payloads.Tags;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PetSteps extends CommonSteps {

    //public static Response response;
    JsonPath jsonPathEvaluator;

    @Given("User fetches the pet details by Pet Status {string}")
    public void userFetchesThePetDetailsByPetStatus(String arg0) {

        response = PetEndPoints.getPetByStatus("sold");
        response.then().log().all();
    }

    @And("Pet with name {string} is found")
    public void petWithNameIsFound(String arg0) {
        if(response.statusCode()==200 && arg0 !="") {
            jsonPathEvaluator = response.jsonPath();
            String name = jsonPathEvaluator.get("name");
                Assert.assertTrue(name.contains(arg0));
            }
        else {
            System.out.println("No Info");
        }
        }


    @And("Pet with name {string} is found in the list")
    public void petWithNameIsFoundInTheList(String arg0) {
        if(response.statusCode()==200 && arg0 !="") {
            jsonPathEvaluator = response.jsonPath();

                ArrayList<String> name = jsonPathEvaluator.get("name");
                Assert.assertTrue(name.contains(arg0));

        }
        else {
            System.out.println("No Info");
        }
    }

    @And("Pet with status {string} is found")
    public void petWithStatusIsFoundInTheList(String arg0) {
        if(response.statusCode()==200 && arg0 !="") {
            jsonPathEvaluator = response.jsonPath();

            String status = jsonPathEvaluator.get("status");
            Assert.assertTrue(status.contains(arg0));

        }
        else {
            System.out.println("No Info");
        }
    }

    @Then("Status code is {int}")
    public void status_code_is(Integer int1) {
        System.out.println("Status Code: "+response.statusCode());
        org.junit.Assert.assertTrue(response.statusCode()==int1);
    }

    @Then("Status in response body is {string}")
    public void status_in_response_body_is(String value2) {
        System.out.println("Status Code: "+response.statusLine());
        org.junit.Assert.assertTrue(response.statusLine().contains(value2));
    }

    @Given("User fetches the pet details by Pet Id {string}")
    public void userFetchesThePetDetailsByPetId(String arg0) {
        response = PetEndPoints.getPetById(arg0);
        response.then().log().all();
    }

    @Given("User updates the pet details by form with Pet Id {string} and Pet Name {string} and Pet Status {string}")
    public void userUpdatesThePetDetailsByFormWithPetIdAndPetNameAndPetStatus(String arg0, String arg1, String arg2) {
        response = PetEndPoints.updatePetByForm(arg0,arg1,arg2);
        response.then().log().all();
    }

    @Given("User creates the pet by with Pet Id {string} and Pet Name {string} and Pet Status {string} and Photo URL {string}")
    public void userCreatesThePetByWithPetIdAndPetNameAndPetStatusAndPhotoURL(String arg0, String arg1, String arg2, String arg3) {

        Pet petPayload = new Pet();
        ArrayList<String> urls = new ArrayList<>();
        urls.add(arg3);

        Category cat1 = new Category();
        cat1.setId(arg0);
        cat1.setName(arg1);

        Tags tag1 = new Tags();
        tag1.setId(arg0);
        tag1.setName(arg1);

        List<Tags> taglist = new ArrayList<>();
        taglist.add(tag1);

        petPayload.setId(arg0);
        petPayload.setCategory(cat1);
        petPayload.setName(arg1);
        petPayload.setPhotourl(urls);
        petPayload.setTags(taglist);
        petPayload.setStatus(arg2);

        response = PetEndPoints.createPet(petPayload);
        response.then().log().all();

    }

    @Given("User updates the pet by with Pet Id {string} and Pet Name {string} and Pet Status {string} and Photo URL {string}")
    public void userUpdatesThePetByWithPetIdAndPetNameAndPetStatusAndPhotoURL(String arg0, String arg1, String arg2, String arg3) {
        Pet petPayload = new Pet();
        ArrayList<String> urls = new ArrayList<>();
        urls.add(arg3);

        Category cat1 = new Category();
        cat1.setId(arg0);
        cat1.setName(arg1);

        Tags tag1 = new Tags();
        tag1.setId(arg0);
        tag1.setName(arg1);

        List<Tags> taglist = new ArrayList<>();
        taglist.add(tag1);

        petPayload.setId(arg0);
        petPayload.setCategory(cat1);
        petPayload.setName(arg1);
        petPayload.setPhotourl(urls);
        petPayload.setTags(taglist);
        petPayload.setStatus(arg2);

        response = PetEndPoints.updatePet(petPayload);
        response.then().log().all();
    }

    @Given("User deletes the pet by Id {string}")
    public void userDeletesThePetById(String arg0) {
        response = PetEndPoints.deletePet(arg0);
        response.then().log().all();
    }
}
