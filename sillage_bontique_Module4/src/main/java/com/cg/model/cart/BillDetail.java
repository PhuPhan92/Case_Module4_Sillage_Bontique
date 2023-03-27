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
@Table(name="bill_details")
public class BillDetail extends BaseEntity {
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
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false)
    private Bill bill;

}
