//package com.wsapp.wsapplication.controller;
//
//import com.wsapp.wsapplication.model.UserDetailsRequestModel;
//import com.wsapp.wsapplication.model.UserRest;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//
//    // Note: We cant run Queries Param together with "Getting All Users
//    @GetMapping
//    //    Optional Queries -- Getting all Users on a Page with Limit No --  http://localhost:8082/users?page=1&limit=50
//    public String getUsers(@RequestParam(value="page", defaultValue = "1") int pageNo,
//                           @RequestParam(value="limit", defaultValue = "50") int limitNo,
//                           @RequestParam(value="sort", defaultValue = "60", required = false) String sort)
//    {
//        return "http GET USERS was called on PageNo: "+pageNo+ " with LimitNo: "+limitNo+" and sort: "+sort;
//    }
//
////@GetMapping    // Getting All users on a Page -- http://localhost:8080/users
////    public String getUsers()
////    {
////        return "http GET All USERS was called";
////    }
//
//
//    //  Returning Object as JSON or XML Representation   // Getting specific {userID} on a Page -- http://localhost:8082/users/{userID}
//    @GetMapping(path="/{userID}"
//            , produces= {
//            MediaType.APPLICATION_ATOM_XML_VALUE,
//            MediaType.APPLICATION_JSON_VALUE}
//    )
//    public ResponseEntity<UserRest> getUser(@PathVariable String userID)
//    {
//        UserRest returnVal = new UserRest();
//        returnVal.setEmail("rofiat4@gmail.com");
//        returnVal.setFirstName("Rofiat");
//        returnVal.setLastName("Ogundimu");
//
//        return new ResponseEntity<UserRest>(returnVal, HttpStatus.OK) ;
//        //return "http GET SPECIFIC USER was called with userID: "+userID;
//    }
//
//    // Reading HTTP POST Request Body     // Creating a User details on a Page -- http://localhost:8080/users  --
//    // Body: {}
//    @PostMapping(
//            consumes={MediaType.APPLICATION_ATOM_XML_VALUE,
//    MediaType.APPLICATION_JSON_VALUE},
//    produces={MediaType.APPLICATION_ATOM_XML_VALUE,
//    MediaType.APPLICATION_JSON_VALUE}
//    )
//    public ResponseEntity<UserRest>createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
//            UserRest returnVal = new UserRest();
//            returnVal.setEmail(userDetails.getEmail());
//            returnVal.setFirstName(userDetails.getFirstName());
//            returnVal.setLastName(userDetails.getLastName());
//
//            return new ResponseEntity<UserRest>(returnVal, HttpStatus.OK);
//
//
//
//    }
//
//    @PutMapping(path="/{userID}")  // Updating a specific {userID} on a Page -- http://localhost:8080/users/{userID} -- {"firstName": "Adebusoye","lastName": "Akinade"}
//    public String updateUser(@PathVariable String userID, @RequestBody String userDetails)
//    {
//        return "http UPDATE request was sent for User-ID: "+userID +" ,containing the following details: "+userDetails;
//    }
//    @DeleteMapping(path="/{userID}")  //Deleting a specific User on a Page -- http://localhost:8080/users/{userID}
//    public String deleteUser(@PathVariable String userID)  //
//    {
//        return "http Delete user was called for: "+userID;
//    }
//}
