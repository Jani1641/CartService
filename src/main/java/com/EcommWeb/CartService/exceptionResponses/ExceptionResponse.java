package com.EcommWeb.CartService.exceptionResponses;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    private Integer code;
    private String message;
    private String status;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExceptionResponse(){
        this.timestamp = new Date();
    }

    public ExceptionResponse(HttpStatus header, String message){
        this();
        this.code=header.value();
        this.status = header.name();
        this.message = message;
    }
}
