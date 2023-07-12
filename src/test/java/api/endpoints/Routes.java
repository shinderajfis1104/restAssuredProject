package api.endpoints;

/*      Post Store order  - https://petstore.swagger.io/v2/store/order
        Get Store order - https://petstore.swagger.io/v2/store/order/7
        Delete Store order - 'https://petstore.swagger.io/v2/store/order/7
        Get Store Inventory - https://petstore.swagger.io/v2/store/inventory    */
public class Routes {
    public static String base_url = "https://petstore.swagger.io/v2";

    //Store Module
    public static String post_order = base_url+"/store/order";
    public static String get_order = base_url+"/store/order/{orderId}";
    public static String delete_order = base_url+"/store/order/{orderId}";
    public static String get_store_inventory = base_url+"/store/inventory";


    // Pet Module
/*
*   Get Pet by status https://petstore.swagger.io/v2/pet/findByStatus?status=available
*   Get Pet by id https://petstore.swagger.io/v2/pet/1421
*   Create Pet Post https://petstore.swagger.io/v2/pet'
*   Update Pet Put https://petstore.swagger.io/v2/pet
*   Update Pet with form https://petstore.swagger.io/v2/pet/1421
*   Delete Pet https://petstore.swagger.io/v2/pet/200
*
*
* */

    public static String post_pet = base_url+"/pet";
    public static String update_pet = base_url+"/pet";
    public static String update_pet_by_form = base_url+"/pet/";
    public static String get_pet_by_status = base_url+"/pet/findByStatus?status={status}";
    public static String get_pet_by_id = base_url+"/pet/{petId}";
    public static String delete_pet = base_url+"/pet/{petId}";


}
