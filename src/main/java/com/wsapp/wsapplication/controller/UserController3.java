/*
package com.wsapp.wsapplication.controller;

import com.wsapp.wsapplication.exception.UserServiceException;
import com.wsapp.wsapplication.model.UserDetailsRequestModel;
import com.wsapp.wsapplication.model.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    // Store User Temporary
      Map<String,UserRest> users;
        // Note: We cant run Queries Param together with "Getting All Users
        @GetMapping
        //    Optional Queries -- Getting all Users on a Page with Limit No --  http://localhost:8080/users?page=1&limit=50
        public String getUsers(@RequestParam(value="page", defaultValue = "1") int pageNo,
                               @RequestParam(value="limit", defaultValue = "50") int limitNo,
                               @RequestParam(value="sort", defaultValue = "60", required = false) String sort)
        {
            return "http GET USERS was called on PageNo: "+pageNo+ " with LimitNo: "+limitNo+" and sort: "+sort;
        }

    */
/*@GetMapping    // Getting All users on a Page -- http://localhost:8080/users
    public String getUsers()
    {
        return "http GET All USERS was called";
    }*//*



        //  Returning Object as JSON or XML Representation   // Getting specific {userID} on a Page -- http://localhost:8080/users/{userID}
        @GetMapping(path="/{userID}", produces= {
                MediaType.APPLICATION_ATOM_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<UserRest> getUser(@PathVariable String userID)
        {
           // Map<String,UserRest> users; -- Creating Our New RequestMapping

//         String firstName=null;   //Handle Inbuilt & Custom Exception within  getUser
//         int firstNameLength=firstName.length();  //Handle Inbuilt & Custom Exception within  getUser

            if(true) throw new UserServiceException("A user service exeception is thrown");// Throw and Handle your own Custom Exception







            if(users.containsKey(userID))  // users/userID
            {
                return new ResponseEntity<>(users.get(userID), HttpStatus.OK) ;
            } else
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }



        }

        // Reading HTTP POST Request Body     // Creating a User details on a Page -- http://localhost:8080/users  --
        // Body: {}
        @PostMapping(consumes={MediaType.APPLICATION_ATOM_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE},
                produces={MediaType.APPLICATION_ATOM_XML_VALUE,
                        MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<UserRest>createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
            UserRest userRestVal = new UserRest();
            userRestVal.setEmail(userDetails.getEmail());
            userRestVal.setFirstName(userDetails.getFirstName());
            userRestVal.setLastName(userDetails.getLastName());


            // Store Users Temporary
            String userId = "MyLove";
            userRestVal.setUserId(userId);

            if(users==null) users=new HashMap<>();  //  Instatiating Map(users) with Childclass(HashMap)
           users.put(userId, userRestVal);  // if condition was required to Post
            return new ResponseEntity<UserRest>(userRestVal, HttpStatus.OK);

        }
         // Updating a specific {userID} on a Page -- http://localhost:8080/users/{userID} -- {"firstName": "Adebusoye","lastName": "Akinade"}
        @PutMapping(path="/{userID}", consumes= {MediaType.APPLICATION_ATOM_XML_VALUE,
        MediaType.APPLICATION_JSON_VALUE},
        produces= {
                MediaType.APPLICATION_ATOM_XML_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<UserRest> updateUser(@PathVariable String userID, @Valid @RequestBody UserDetailsRequestModel userDetails)
        {
            UserRest userInfo = new UserRest();
            userInfo.setFirstName(userDetails.getFirstName());
            userInfo.setLastName(userDetails.getLastName());
            userInfo.setEmail("adewunmi@gmail.com");

            users.put(userID,userInfo);
           // return userInfo;
            return new ResponseEntity<UserRest>(userInfo, HttpStatus.OK);

        }
        @DeleteMapping(path="/{userID}")  //Deleting a specific User on a Page -- http://localhost:8080/users/{userID}
        public ResponseEntity<Void> deleteUser(@PathVariable String userID)  //
        {
                     users.remove(userID);

                     return ResponseEntity.noContent().build();

        }
}
*/
