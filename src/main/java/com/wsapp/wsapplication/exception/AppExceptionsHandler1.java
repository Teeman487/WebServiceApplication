/*
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
@ControllerAdvice   // Inbuilt Specific Exception Debugging
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object>handleAnyException(Exception ex, WebRequest request) {
        return  new ResponseEntity<>(  // place debug point
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
*/
