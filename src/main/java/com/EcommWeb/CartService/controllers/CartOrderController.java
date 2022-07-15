package com.EcommWeb.CartService.controllers;

import com.EcommWeb.CartService.entities.CartOrder;
import com.EcommWeb.CartService.models.*;
import com.EcommWeb.CartService.services.CartServices;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;



@CrossOrigin("*")
@Slf4j
@RestController
public class CartOrderController {

    private static final String PRODUCTS_URL = "http://localhost:8081/list";

    @Autowired
    private CartServices cartServices;
    @Autowired
    private RestTemplate restTemplate;


    //creating cart -working
    @PostMapping("/carts")
    public ResponseEntity<CreateCartResponse> getCartOrder (@RequestBody CartOrder cartorder){
        log.info("Started getCartOrder function in controller");
        cartorder.setStartDate(new Date());
        CartOrder savedCart = cartServices.saveCart(cartorder);
        CreateCartResponse response =  new CreateCartResponse(savedCart.getOrderId());
        log.info("End of getCartOrder function in controller");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }



    //display cart - working
    @GetMapping("/carts/{order_id}")
    public CartResponse getCart (@PathVariable Integer order_id){
        log.info("Started getCart function in controller");
        CartOrderResponse cartDetails = cartServices.findCartDetails(order_id);
        List<DetailResponse> detailsOfCart = cartServices.findDetailsOfCart(order_id);
        CartResponse totalDetails = new CartResponse.CartResponseBuilder()
                .cartId(cartDetails.getCartId())
                .address(cartDetails.getAddress())
                .amount(cartDetails.getAmount())
                .detailList(detailsOfCart)
                .build();
        log.info("End of getCart function in controller");
        return totalDetails;
    }


    //deletes cart -working
    @DeleteMapping("/carts/{order_id}")
    public ResponseEntity<HttpStatus> deleteCart (@PathVariable Integer order_id){
        log.info("Started deleteCart function in controller");
        cartServices.deleteCart(order_id);
        log.info("End of deleteCart function in controller");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    //deletes cart's item - working
    @DeleteMapping("/carts/{order_id}/products/{item_id}")
    public ResponseEntity<HttpStatus> deleteCartItem(@PathVariable Integer order_id, @PathVariable Integer item_id) {
        log.info("Started deleteCartItem function in controller");
        Integer val = cartServices.getItemId(item_id, order_id);
        cartServices.deleteItem(val,order_id);
        log.info("End of deleteCartItem function in controller");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    // saves the item into cart-working
    @PutMapping("/carts/{order_id}/products")
    public ResponseEntity<Object> addItems(@PathVariable Integer order_id, @RequestParam Integer product_id,@RequestParam Integer quantity){
        log.info("Started addItems function in controller");
        ProductResponse product = cartServices.getProductService(product_id);
        cartServices.itemSave(product,order_id,quantity);
        log.info("End of addItems function in controller");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //updates the quantity - working
    @PutMapping("/carts/{order_id}/products/{product_id}")
    public ResponseEntity<Object> addToCart(@PathVariable Integer order_id, @PathVariable Integer product_id, @RequestParam Integer quantity) {
        log.info("Started addCart function in Controller");
        if(quantity.equals(0)) {
            Integer val = cartServices.getItemId(product_id, order_id);
            cartServices.deleteItem(val,order_id);
        }else{
            Optional<CartOrder> cartOrder = cartServices.findCartOrderById(order_id);
            ProductResponse productResponse = cartServices.getProductService(product_id);
            cartServices.updateItemService(quantity, productResponse, cartOrder);
        }
        log.info("End of addCart function in Controller");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}