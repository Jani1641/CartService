package com.EcommWeb.CartService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Details")
public class Details {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer item;
    private  String title;
    private float itemPrice;
    private Integer quantity;
    private String imageUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"details","handler","hibernateLazyInitializer"})
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
    private CartOrder cartOrder;

    public Details() {
    }

    public Details(Integer item, String title, float itemPrice, Integer quantity, String imageUrl, CartOrder cartOrder) {
        this.item = item;
        this.title = title;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.cartOrder = cartOrder;
    }

    public Integer getId() {
        return id;
    }

    public Integer getItem() {return item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public CartOrder getCartOrder() {
        return cartOrder;
    }

    public void setCartOrder(CartOrder cartOrder) {
        this.cartOrder = cartOrder;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
