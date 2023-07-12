package api.tests;

import api.endpoints.PetEndPoints;
import api.payloads.Category;
import api.payloads.Pet;
import api.payloads.Tags;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests {

    Pet petPayload;
    Pet petPayload2;
    @BeforeClass
    public void setuppaylod(){

        petPayload = new Pet();
        ArrayList<String> urls = new ArrayList<>();
        urls.add("http://www.google.com");
        urls.add("ABCDSIJK");

       /* HashMap<String,String> urls = new HashMap<String, String>() ;
        urls.put("name","ABCDFGHTYH");*/

        Category cat1 = new Category();
        cat1.setId(1524);
        cat1.setName("GoldenRetriver");

        Category cat2 = new Category();
        cat1.setId(1524);
        cat1.setName("GoldenRetriver1234");

        Tags tag1 = new Tags();
        tag1.setId(1523);
        tag1.setName("ABCDEF");

        List<Tags> taglist = new ArrayList<>();
        taglist.add(tag1);

        petPayload.setId(1523);
        petPayload.setCategory(cat1);
        petPayload.setName("RioG");
        petPayload.setPhotourl(urls);
        petPayload.setTags(taglist);
        petPayload.setStatus("available");

        petPayload2 = new Pet();
        petPayload2.setId(1523);
        petPayload2.setCategory(cat2);
        petPayload2.setName("RioGold");
        petPayload2.setPhotourl(urls);
        petPayload2.setTags(taglist);
        petPayload2.setStatus("pending");

    }

    @Test()
    public void testPet(){

        Response response = PetEndPoints.createPet(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = PetEndPoints.getPetById("1422");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = PetEndPoints.updatePet(petPayload2);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        //Assert.assertEquals(response.getBody(),200);


        response = PetEndPoints.getPetById("1422");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = PetEndPoints.updatePetByForm("1422","Rio_Jagtap","sold");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = PetEndPoints.getPetByStatus("sold");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = PetEndPoints.getPetById("1422");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = PetEndPoints.deletePet("1422");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        response = PetEndPoints.getPetById("1422");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);











    }


    }
