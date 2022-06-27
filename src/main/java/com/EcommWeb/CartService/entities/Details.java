package com.EcommWeb.CartService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Details")
public class Details {
    @Id
    @GeneratedValue
    private Integer Id;

    private Integer item;

    private float itemPrice;
    private Integer quantity;

    public Details() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"details","handler","hibernateLazyInitializer"})
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
    private CartOrder cartOrder;

    public Details(Integer id, Integer item, float itemPrice, Integer quantity, CartOrder cartOrder) {
        this.item = item;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.cartOrder = cartOrder;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getItem() {
        return item;
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
}
