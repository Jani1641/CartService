package com.EcommWeb.CartService.models;

public class CreateCartResponse {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CreateCartResponse(Integer id) {
        this.id = id;
    }
}
