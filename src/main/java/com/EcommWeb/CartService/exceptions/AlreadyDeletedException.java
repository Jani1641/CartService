package com.EcommWeb.CartService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlreadyDeletedException extends RuntimeException{
    public AlreadyDeletedException(){
        super();
    }
    public AlreadyDeletedException(String message){
        super(message);
    }

}
