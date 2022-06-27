package com.EcommWeb.CartService.exceptions;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ItemAlreadyExists extends RuntimeException{
    public ItemAlreadyExists(){
        super();
    }
    public ItemAlreadyExists(String message){
        super(message);
    }
}
