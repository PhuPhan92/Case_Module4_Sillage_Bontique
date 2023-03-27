package com.cg.service.bill;

import com.cg.exception.DataInputException;
import com.cg.model.User;
import com.cg.model.cart.Bill;
import com.cg.model.cart.BillDetail;
import com.cg.model.cart.CartItem;
import com.cg.model.cart.Cart;
import com.cg.repository.BillDetailRepository;
import com.cg.repository.BillRepository;
import com.cg.repository.CartItemRepository;
import com.cg.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BillServiceImpl implements IBillService{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartDetailRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public List<Bill> findAll() {
        return null;
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }

    @Override
    public void createOrder(User user) {
        Optional<Cart> cartOptional = cartRepository.findByUser(user);

        if (!cartOptional.isPresent()) {
            throw new DataInputException("Cart is empty");
        }

        Cart cart = cartOptional.get();

        Bill bill = cart.toBill();
        bill.setId(null);
        billRepository.save(bill);

        List<CartItem> cartDetails = cartDetailRepository.findByCart(cart);

        for (CartItem item : cartDetails) {
            BillDetail billDetail = item.toBillDetail(bill);
            billDetailRepository.save(billDetail);
            cartDetailRepository.delete(item);
        }

        cartRepository.delete(cart);
    }

    @Override
    public Bill save(Bill bill) {
        return null;
    }

    @Override
    public void delete(Bill bill) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
