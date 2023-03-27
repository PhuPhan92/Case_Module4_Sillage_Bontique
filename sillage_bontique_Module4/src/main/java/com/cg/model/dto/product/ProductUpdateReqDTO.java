package com.cg.model.dto.product;

import com.cg.model.product.Product;
import com.cg.model.product.ProductAvatar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductUpdateReqDTO {
    private Long id;

    private BigDecimal price;
    private String title;
    private Long quantity;
    private String description;
    private MultipartFile avatarFile;
    public Product toProduct(ProductAvatar productAvatar){
        return new Product()
                .setId(id)
                .setTitle(title)
                .setPrice(price)
                .setDescription(description)
                .setQuantity(quantity)
                .setProductAvatar(productAvatar);

    }
}
