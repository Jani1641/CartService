package com.EcommWeb.CartService.repository;

import com.EcommWeb.CartService.entities.CartOrder;
import com.EcommWeb.CartService.entities.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<Details,Integer> {
    @Query("SELECT detail FROM Details detail WHERE detail.cartOrder.orderId= ?1 AND  detail.item = ?2")
    Details findByItem (Integer order_id,Integer product_id);

}
