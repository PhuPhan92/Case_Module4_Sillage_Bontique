package com.cg.model.dto.product;

import com.cg.model.Customer;
import com.cg.model.CustomerAvatar;
import com.cg.model.LocationRegion;
import com.cg.model.product.Product;
import com.cg.model.product.ProductAvatar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private Long quantity;
    private String description;
    private ProductAvatarDTO productAvatar;
    public ProductDTO(Long id, String title,BigDecimal price , Long quantity, String description, ProductAvatar productAvatar) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.productAvatar = productAvatar.toProductAvatarDTO();
    }


    public Product toProduct() {
        return new Product()
                .setId(id)
                .setTitle(title)
                .setDescription(description)
                .setPrice(price)
                .setQuantity(quantity)
                .setProductAvatar(productAvatar.toProductAvatar())
                ;
    }
}
