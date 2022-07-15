package com.EcommWeb.CartService.services;

import com.EcommWeb.CartService.entities.CartOrder;
import com.EcommWeb.CartService.entities.Details;
import com.EcommWeb.CartService.exceptions.AlreadyDeletedException;
import com.EcommWeb.CartService.exceptions.ItemAlreadyExists;
import com.EcommWeb.CartService.exceptions.NotFoundException;
import com.EcommWeb.CartService.models.CartOrderResponse;
import com.EcommWeb.CartService.models.DetailResponse;
import com.EcommWeb.CartService.models.ProductResponse;
import com.EcommWeb.CartService.repository.CartOrderRepository;
import com.EcommWeb.CartService.repository.DetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CartServices {

    @Autowired
    private CartOrderRepository cartOrderRepository;
    @Autowired
    private DetailsRepository detailsRepository;
    @Autowired
    private RestTemplate restTemplate;
    private static final String PRODUCTS_URL = "http://localhost:8081/list";

    public ProductResponse getProductService(Integer id){
        log.info("Started getProductService in CartServices");
        String url = PRODUCTS_URL+"/"+Integer.toString(id);
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(url, ProductResponse.class);
        response.getBody().setId(id);
        log.info("End of getProductService in CartServices");
        return response.getBody();
    }


    public void itemSave(ProductResponse productResponse, Integer order_id,Integer quantity){
        log.info("Started itemSave function in CartServices");
        CartOrder cartOrder = cartOrderRepository.findById(order_id).orElse(null);
        Details item = detailsRepository.findByItem(order_id, productResponse.getId());
        if(cartOrder==(null) ) {
            throw new ItemAlreadyExists("Cart is not present");
        }else if(item==(null)) {
            item = new Details();
            item.setItem(productResponse.getId());
            item.setCartOrder(cartOrder);
            item.setQuantity(quantity);
            item.setImageUrl(productResponse.getImageUrl());
            item.setTitle(productResponse.getTitle());
            item.setItemPrice(productResponse.getPrice()*quantity);
            detailsRepository.save(item);
            cartOrder.setAmount(findValueOfCart(cartOrder.getOrderId()));
            cartOrderRepository.save(cartOrder);
        }else{
            item.setQuantity(item.getQuantity()+1);
            item.setItemPrice(item.getItemPrice()+ productResponse.getPrice());
            detailsRepository.save(item);
            cartOrder.setAmount(findValueOfCart(cartOrder.getOrderId()));
            cartOrderRepository.save(cartOrder);
        }
        log.info("End of itemSave function in CartServices");
    }

    public void updateItemService (Integer quantity, ProductResponse productResponse, Optional<CartOrder> cartOrder1){
        log.info("Started updateItemService function in CartServices");
        CartOrder cartOrder = cartOrder1.get();
        Details detail = detailsRepository.findByItem(cartOrder.getOrderId(),productResponse.getId());
        float newPrice = productResponse.getPrice()*quantity;
        detail.setQuantity(quantity);
        detail.setItemPrice(newPrice);
        detailsRepository.save(detail);
        cartOrder.setAmount(findValueOfCart(cartOrder.getOrderId()));
        cartOrderRepository.save(cartOrder);
        log.info("End of updateItemService function in CartServices");
    }

    public Integer getItemId(Integer item_id, Integer order_id){
        log.info("Started getItemId function in CartServices");
        Details item = detailsRepository.findByItem(order_id, item_id);
        if(item == null){
            throw new NotFoundException("cart_id "+order_id+" and item_id "+item_id+" not found!");
        }else{
            Integer id = item.getId();
            log.info("End of getItemId function in CartServices");
            return id;
        }
    }

    public Optional<CartOrder> findCartOrderById (Integer order_id){
        log.info("Started findCartOrderById function in CartServices");
        Optional<CartOrder> cartOrder = Optional.of(cartOrderRepository.findById(order_id)
                .orElseThrow(()->
                     new NotFoundException("id " + order_id + " not found")
                ));
        Optional<CartOrder> cartOrder1 = cartOrder;
        log.info("End of findCartOrderById function in CartServices");
        return cartOrder1;
    }

    public List<DetailResponse> findDetailsOfCart (Integer order_id){
        log.info("Started findDetailsOfCart function from CartServices");
        List<DetailResponse> details = findCartOrderById(order_id).get().getDetails().stream()
                .map(DetailConverter::convertDetailToDetailResponse).collect(Collectors.toList());
        log.info("End of findDetailsOfCart function from CartServices");
        return details;
    }
    public CartOrder saveCart (CartOrder cartOrder){
        CartOrder savedCart = cartOrderRepository.save(cartOrder);
        return savedCart;
    }

    public void deleteCart(Integer order_id){
        log.info("Started deleteCart function in CartServices");
        CartOrder cartOrder = cartOrderRepository.findById(order_id).orElse(null);
        if(cartOrder.equals(null)){
            throw new AlreadyDeletedException("id "+order_id+" already deleted.");
        }
        cartOrderRepository.deleteById(order_id);
        log.info("End of deleteCart function in CartServices");
    }

    public void deleteItem (Integer item_id,Integer order_id){
        log.info("Started deleteItem function from CartServices");
        Optional<Details> details = detailsRepository.findById(item_id);
        CartOrder cartOrder = cartOrderRepository.findById(order_id).get();
        if(details.equals(null)){
            throw new NotFoundException("item is already deleted");
        }
        detailsRepository.deleteById(item_id);
        cartOrder.setAmount(findValueOfCart(cartOrder.getOrderId()));
        cartOrderRepository.save(cartOrder);
        log.info("End of deleteItem function from CartServices");
    }

    public CartOrderResponse findCartDetails (Integer order_id){
        log.info("Started findCartDetails function from CartServices");
        Optional<CartOrder> cartOrder = findCartOrderById(order_id);
        CartOrderResponse value = new CartOrderResponse.CartOrderResponseBuilder()
                .cartId(cartOrder.get().getOrderId())
                .amount(cartOrder.get().getAmount())
                .address(cartOrder.get().getAddress())
                .build();
        log.info("End of findCartDetails function from CartServices");
        return value;
    }

    public float findValueOfCart(Integer order_id){
        float reduce = cartOrderRepository.findById(order_id).get().getDetails()
                .stream().map(a -> a.getItemPrice()).reduce((float) 0, (a, b) -> a + b);
        return reduce;
    }

}