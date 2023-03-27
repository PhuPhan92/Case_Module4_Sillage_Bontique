package com.cg.repository;

import com.cg.model.cart.Cart;
import com.cg.model.cart.CartItem;
import com.cg.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByProductAndCart(Product product, Cart cart);

    List<CartItem> findByCart(Cart cart);


    @Query("SELECT SUM(cd.productAmount) FROM CartItem AS cd WHERE cd.cart = :cart ")
    BigDecimal getTotalAmount(@Param("cart") Cart cart);

}
