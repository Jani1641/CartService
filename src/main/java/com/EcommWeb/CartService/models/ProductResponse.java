package com.EcommWeb.CartService.models;

public class ProductResponse {
    private Integer Id;
    private String title;
    private String description;
    private float price;

    private ProductResponse(ProductResponseBuilder productResponseBuilder){
        this.Id = productResponseBuilder.id;
        this.title = productResponseBuilder.title;
        this.description = productResponseBuilder.description;
        this.price = productResponseBuilder.price;
    }

    public ProductResponse() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public class ProductResponseBuilder{
        private Integer id;
        private String title;
        private String description;
        private float price;

        public ProductResponseBuilder title(String title){
            this.title = title;
            return this;
        }
        public ProductResponseBuilder description(String description){
            this.description = description;
            return this;
        }
        public ProductResponseBuilder price(float price){
            this.price = price;
            return this;
        }
        public ProductResponseBuilder id(Integer id){
            this.id = id;
            return this;
        }
        public ProductResponse build(){
            return new ProductResponse(this);
        }
    }
}
