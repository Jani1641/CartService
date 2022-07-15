package com.EcommWeb.CartService.services;

import com.EcommWeb.CartService.entities.Details;
import com.EcommWeb.CartService.models.DetailResponse;

public class DetailConverter {
    public static DetailResponse convertDetailToDetailResponse(Details details){
        return new DetailResponse.DetailsResponseBuilder()
                .item(details.getItem())
                .price(details.getItemPrice())
                .quantity(details.getQuantity())
                .imageUrl(details.getImageUrl())
                .title(details.getTitle())
                .build();
    }
}
