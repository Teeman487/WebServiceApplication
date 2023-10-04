/*@RestController
@RequestMapping("users")
public class UserController1 {

    // Note: We cant run Queries Param together with "Getting All Users
    @GetMapping  //    Queries-- Getting all Users on a Page with Limit No --  http://localhost:8080/users?page=1&limit=50
    public String getUsers(@RequestParam(value="page") int pageNo, @RequestParam(value="limit") int limitNo )
    {
        return "http GET USERS from PageNo: "+pageNo+ " with LimitNo: "+limitNo;
    }

    *//*@GetMapping    // Getting All users on a Page -- http://localhost:8080/users
    public String getUsers()
    {
        return "http GET All USERS was called";
    }*//*

   @GetMapping(path="/{userID}")  // Getting specific {userID} on a Page -- http://localhost:8080/users/{userID}
   public String getUser(@PathVariable String userID)
   {
        return "http GET SPECIFIC USER was called with userID: "+userID;
    }

    @PostMapping           // Creating a User details on a Page -- http://localhost:8080/users  -- Body: {"firstName": "Toheeb","lastName": "Akinade"}
    public String createUser(@RequestBody String userDetails) {

        return "http POST request was sent for User with details: "+userDetails;
    }

    @PutMapping(path="/{userID}")  // Updating a specific {userID} on a Page -- http://localhost:8080/users/{userID} -- {"firstName": "Adebusoye","lastName": "Akinade"}
    public String updateUser(@PathVariable String userID, @RequestBody String userDetails)
    {
        return "http UPDATE request was sent for User-ID: "+userID +" ,containing the following details: "+userDetails;
    }
    @DeleteMapping(path="/{userID}")  //Deleting a specific User on a Page -- http://localhost:8080/users/{userID}
    public String deleteUser(@PathVariable String userID)  //
    {
        return "http Delete user was called for: "+userID;
    }


}*/
