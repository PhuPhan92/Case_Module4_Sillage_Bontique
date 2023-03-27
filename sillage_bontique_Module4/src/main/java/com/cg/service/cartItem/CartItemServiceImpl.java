package com.cg.service.cartItem;


import com.cg.model.cart.CartItem;
import com.cg.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemServiceImpl implements ICartItemService{
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> findAll() {
        return null;
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return null;
    }

    @Override
    public void delete(CartItem cartItem) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
