package com.EcommWeb.CartService.models;

import java.util.List;

public class CartResponse {

    private Integer cartId;

    private float amount;
    private String address;

    private List<DetailResponse> details;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<DetailResponse> getDetails() {
        return details;
    }

    public void setDetails(List<DetailResponse> details) {
        this.details = details;
    }

    private CartResponse(CartResponseBuilder cartResponseBuilder){
        this.cartId=cartResponseBuilder.cartId;
        this.address=cartResponseBuilder.address;
        this.amount=cartResponseBuilder.amount;
        this.details = cartResponseBuilder.detailResponseList;
    }

    public static class CartResponseBuilder{

        private Integer cartId;

        private float amount;

        private String address;
        private List<DetailResponse> detailResponseList;

        public CartResponseBuilder cartId (Integer cartId){
            this.cartId = cartId;
            return this;
        }

        public CartResponseBuilder amount(float amount){
            this.amount = amount;
            return this;
        }

        public CartResponseBuilder address(String address){
            this.address = address;
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
