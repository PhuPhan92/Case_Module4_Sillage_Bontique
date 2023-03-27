package com.cg.model.product;

import com.cg.model.BaseEntity;
import com.cg.model.dto.product.ProductCreateResDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@Accessors(chain = true)
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "title is not empty")
    private String title;
    private String description;
    private Long quantity;

    @Column(precision = 10, scale = 0, nullable = false)
    private BigDecimal price;
    @OneToOne
    @JoinColumn(name = "product_avatar_id", referencedColumnName = "id", nullable = false)
    private ProductAvatar productAvatar;

//    @ManyToOne
//    @JoinColumn(name = "product_type_id",referencedColumnName = "id", nullable = false)
//    private ProdType productType;

//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
//    private ProdCategory prodCategory;
    public ProductCreateResDTO toProductCreateResDTO(){
        return new ProductCreateResDTO()
                .setId(id)
                .setPrice(price)
                .setTitle(title)
                .setDescription(description)
                .setProductAvatar(productAvatar.toProductAvatarDTO());
    }

}
