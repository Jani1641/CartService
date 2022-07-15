package com.EcommWeb.CartService.models;

import com.EcommWeb.CartService.entities.CartOrder;
import com.EcommWeb.CartService.entities.Details;

public class DetailResponse {
    private Integer id;
    private float price;
    private Integer quantity=1;
    private String imageUrl;
    private String title;

    public DetailResponse() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
        this.title = detailsResponseBuilder.title;
        this.id =detailsResponseBuilder.id;
        this.price = detailsResponseBuilder.price;
        this.quantity = detailsResponseBuilder.quantity;
        this.imageUrl = detailsResponseBuilder.imageUrl;
    }
    public static class DetailsResponseBuilder{
        private Integer id;
        private float price;
        private Integer quantity;
        private String imageUrl;
        private String title;

        public DetailsResponseBuilder item(Integer item){
            this.id = item;
            return this;
        }
        public DetailsResponseBuilder price(float itemPrice){
            this.price = itemPrice;
            return this;
        }
        public DetailsResponseBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        public DetailsResponseBuilder imageUrl (String imageUrl){
            this.imageUrl = imageUrl;
            return this;
        }
        public  DetailsResponseBuilder title (String title){
            this.title = title;
            return this;
        }
        public DetailResponse build(){
            return new DetailResponse(this);
        }
    }
}
