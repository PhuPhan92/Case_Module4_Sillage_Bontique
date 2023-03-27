package com.cg.model.cart;

import com.cg.model.BaseEntity;
import com.cg.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart_items")
public class CartItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productTitle;

    @Column(precision = 10, scale = 0, nullable = false)
    private BigDecimal productPrice;

    private Long productQuantity;

    @Column(precision = 10, scale = 0, nullable = false)
    private BigDecimal productAmount;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private Cart cart;


    public BillDetail toBillDetail(Bill bill) {
        return new BillDetail()
                .setId(id)
                .setBill(bill)
                .setProduct(product)
                .setProductTitle(productTitle)
                .setProductPrice(productPrice)
                .setProductQuantity(productQuantity)
                .setProductAmount(productAmount)
                ;
    }



}
