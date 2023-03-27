package com.cg.service.cart;

import com.cg.model.User;
import com.cg.model.cart.Cart;
import com.cg.service.IGeneralService;

public interface ICartService extends IGeneralService <Cart>{
    void addCart(Long productId, User user);
}
