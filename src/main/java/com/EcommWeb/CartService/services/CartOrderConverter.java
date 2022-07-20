package com.EcommWeb.CartService.services;

import com.EcommWeb.CartService.entities.CartOrder;
import com.EcommWeb.CartService.models.CartOrderResponse;

public class CartOrderConverter {
    public static CartOrderResponse convertCartOrderToCartOrderResponse(CartOrder cartOrder){
        return new CartOrderResponse.CartOrderResponseBuilder()
                .cartId(cartOrder.getOrderId())
                .amount(cartOrder.getAmount())
                .build();
    }
}
