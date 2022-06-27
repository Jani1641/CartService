package com.EcommWeb.CartService.models;

import com.EcommWeb.CartService.entities.CartOrder;
import com.EcommWeb.CartService.entities.Details;

public class DetailResponse {
    private Integer item;
    private float itemPrice;
    private Integer quantity;

    public DetailResponse() {
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Details dtoConvert(CartOrder cartOrder){
        Details details = new Details();
        details.setCartOrder(cartOrder);
        return details;
    }
    private DetailResponse(DetailsResponseBuilder detailsResponseBuilder){
        this.item=detailsResponseBuilder.item;
        this.itemPrice = detailsResponseBuilder.itemPrice;
        this.quantity = detailsResponseBuilder.quantity;
    }
    public static class DetailsResponseBuilder{
        private Integer item;
        private float itemPrice;
        private Integer quantity;

        public DetailsResponseBuilder item(Integer item){
            this.item = item;
            return this;
        }
        public DetailsResponseBuilder itemPrice(float itemPrice){
            this.itemPrice = itemPrice;
            return this;
        }
        public DetailsResponseBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        public DetailResponse build(){
            return new DetailResponse(this);
        }
    }
}
