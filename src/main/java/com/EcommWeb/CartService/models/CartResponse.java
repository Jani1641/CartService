package com.EcommWeb.CartService.models;

import java.util.List;

public class CartResponse {
    private Integer cartId;
    private float amount;
    private List<DetailResponse> items;

    public Integer getCartId() {
        return cartId;
    }
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public List<DetailResponse> getItems() {
        return items;
    }
    public void setItems(List<DetailResponse> items) {
        this.items = items;
    }

    private CartResponse(CartResponseBuilder cartResponseBuilder){
        this.cartId=cartResponseBuilder.cartId;
        this.amount=cartResponseBuilder.amount;
        this.items = cartResponseBuilder.detailResponseList;
    }

    public static class CartResponseBuilder{

        private Integer cartId;
        private float amount;
        private List<DetailResponse> detailResponseList;

        public CartResponseBuilder cartId (Integer cartId){
            this.cartId = cartId;
            return this;
        }

        public CartResponseBuilder amount(float amount){
            this.amount = amount;
            return this;
        }

        public CartResponseBuilder detailList(List<DetailResponse> detailResponseList){
            this.detailResponseList= detailResponseList;
            return this;
        }

        public CartResponse build(){
            return new CartResponse(this);

        }

    }
}
