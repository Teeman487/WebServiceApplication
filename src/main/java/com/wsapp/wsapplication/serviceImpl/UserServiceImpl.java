/*
package com.wsapp.wsapplication.serviceImpl;

import com.wsapp.wsapplication.model.UserDetailsRequestModel;
import com.wsapp.wsapplication.model.UserRest;
import com.wsapp.wsapplication.service.UserService;
import com.wsapp.wsapplication.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    Map<String,UserRest> users;  //
    Utils utils; // Constructor Based Dependency Injection

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }
    public UserServiceImpl() {}

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        //Copied & Pasted Entire Business logic in PostMapping
        UserRest userRestVal = new UserRest();
        userRestVal.setEmail(userDetails.getEmail());
        userRestVal.setFirstName(userDetails.getFirstName());
        userRestVal.setLastName(userDetails.getLastName());


        // Store Users Temporary
        //String userId = "MyLove";
        String userId = utils.generateUserId();
        userRestVal.setUserId(userId);

        if(users==null) users=new HashMap<>();  //  Instatiating Map(users) with Childclass(HashMap)
        users.put(userId, userRestVal);  // if condition was required to Post

        return userRestVal;
    }
}
*/
