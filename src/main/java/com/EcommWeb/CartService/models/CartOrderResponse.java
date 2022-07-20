package com.EcommWeb.CartService.models;

import lombok.Getter;
import lombok.Setter;

public class CartOrderResponse {
    private float amount;
    private Integer cartId;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    private CartOrderResponse(CartOrderResponseBuilder cartOrderResponseBuilder){
        this.amount = cartOrderResponseBuilder.amount;
        this.cartId = cartOrderResponseBuilder.cartId;
    }

    public static class CartOrderResponseBuilder{
        private float amount;
        private Integer cartId;

        public CartOrderResponseBuilder amount(float amount){
            this.amount = amount;
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
