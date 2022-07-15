package com.EcommWeb.CartService.models;

public class ProductResponse {
    private Integer id;
    private String title;
    private String description;
    private float price;
    private String imageUrl;
    private ProductResponse(ProductResponseBuilder productResponseBuilder){
        this.id=productResponseBuilder.id;
        this.price=productResponseBuilder.price;
        this.description=productResponseBuilder.description;
        this.imageUrl = productResponseBuilder.imageUrl;
        this.title = productResponseBuilder.title;
    }


    public ProductResponse() {
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        private String imageUrl;


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
        public ProductResponseBuilder imageUrl(String imageUrl){
            this.imageUrl = imageUrl;
            return this;
        }

        public ProductResponse build(){
            return new ProductResponse(this);
        }
    }
}
