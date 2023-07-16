package api.payloads;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    String id;
    Category category;
    String name;
    List<String> photoUrls= new ArrayList<>();;
    //HashMap <String,String> photoUrls = new HashMap<String,String>();
    List<Tags> tags;
    String status;

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotourl(ArrayList<String> photourl) {
        this.photoUrls = photourl;
    }

    /*public void setPhotourl(HashMap<String,String> photourl) {
        this.photoUrls = photourl;
    }
*/
    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotourl() {
        return photoUrls;
    }

    /*public HashMap<String,String> getPhotourl() {
        return photoUrls;
    }*/

    public List<Tags> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
}
