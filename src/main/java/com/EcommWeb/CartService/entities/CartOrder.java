package com.EcommWeb.CartService.entities;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class CartOrder {

    @Id
    @GeneratedValue
    private Integer orderId;

    private float  amount;

    @Past
    private Date startDate;

    private Integer customerId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Size(max = 50)
    private String address;
    @OneToMany(mappedBy = "cartOrder", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Details> details;

    public CartOrder(Integer orderId, float amount, Date startDate, String address) {
        this.orderId = orderId;
        this.amount = amount;
        this.startDate = startDate;
        this.address = address;
    }

    public CartOrder() {
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }

    public float getAmount() {
        return amount;
    }

    public List<Details> getDetails() {
        return details;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderId() {
        return orderId;
    }
}
