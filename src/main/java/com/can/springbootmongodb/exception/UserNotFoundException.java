package com.can.springbootmongodb.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class UserNotFoundException extends RuntimeException{
    private String message = "User not found!";
}