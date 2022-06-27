package com.EcommWeb.CartService.exceptionHandler;

import com.EcommWeb.CartService.exceptionResponses.ExceptionResponse;
import com.EcommWeb.CartService.exceptions.AlreadyDeletedException;
import com.EcommWeb.CartService.exceptions.ItemAlreadyExists;
import com.EcommWeb.CartService.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException (Exception ex){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(status,ex.getMessage()),status);
    }

    @ExceptionHandler(ItemAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> handleItemAlreadyExists (Exception ex){
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        return new ResponseEntity<>(new ExceptionResponse(status, ex.getMessage()),status);
    }

    @ExceptionHandler(AlreadyDeletedException.class)
    public ResponseEntity<ExceptionResponse> handleItemAlreadyException (Exception ex){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ExceptionResponse(status, ex.getMessage()),status);
    }
}
