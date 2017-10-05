package com.labracode.controller;

import com.labracode.exceptions.UserAlreadyExistsException;
import com.labracode.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> userAlreadyExistsException() {
        ErrorMessage errorMessage = new ErrorMessage("USER_ALREADY_EXISTS", "A user with the given username already exists");
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.CONFLICT);
    }

}
