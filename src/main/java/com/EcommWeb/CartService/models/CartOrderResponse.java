package com.EcommWeb.CartService.models;

import lombok.Getter;
import lombok.Setter;

public class CartOrderResponse {
    private float amount;
    private String address;
    private Integer cartId;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    private CartOrderResponse(CartOrderResponseBuilder cartOrderResponseBuilder){
        this.amount = cartOrderResponseBuilder.amount;
        this.address = cartOrderResponseBuilder.address;
        this.cartId = cartOrderResponseBuilder.cartId;
    }

    public static class CartOrderResponseBuilder{
        private float amount;
        private String address;
        private Integer cartId;

        public CartOrderResponseBuilder amount(float amount){
            this.amount = amount;
            return this;
        }

        public CartOrderResponseBuilder address(String address){
            this.address = address;
            return this;
        }
        public CartOrderResponseBuilder cartId(Integer cartId){
            this.cartId= cartId;
            return this;
        }
        public CartOrderResponse build(){
            return new CartOrderResponse(this);
        }
    }

}
