package com.wsapp.wsapplication.exception;

import java.io.Serial;

public class UserServiceException extends RuntimeException {  // Throw & Handle Your Own Custom Exception
    @Serial
    private static final long serialVersionUID = -3297240201888358523L;
    public UserServiceException(String message)
    {
        super(message);
    }

}
