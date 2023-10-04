package com.wsapp.wsapplication.exception;

import com.wsapp.wsapplication.model.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice   // Custom Error Message Exception
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {  // Exception ex occurred in UserController
        String errorMessageDescription = ex.getLocalizedMessage();  // retrieve the localized message associated with exception in UserController
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString(); //
        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);  //  errorMessage containing Date & ....

        return  new ResponseEntity<>(  // place debug point
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);  // returning errorMessage containing Date and localized message associated with exception in UserController
    }     /*{ "timestamp": "2023-10-04T16:19:40.635+00:00", "message": "Cannot invoke \"String.length()\" because \"firstName\" is null"}*/

    // Handling a Specific NullPointer Custom Error Exception
    /*@ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object>handNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
        return  new ResponseEntity<>(  // place debug point
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    // Throw and Handle your own  Custom Exception
    /*@ExceptionHandler(value = {UserServiceException.class})  // Throw Exception
    public ResponseEntity<Object>handleUserServiceException(UserServiceException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
        return  new ResponseEntity<>(  // place debug point
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})  // Catch More than One Exception with One Method
    public ResponseEntity<Object>handleSpecificException(Exception ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
        return  new ResponseEntity<>(  // place debug point
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); }

}
