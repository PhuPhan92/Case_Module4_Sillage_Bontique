package com.cg.model.dto.product;

import com.cg.model.Customer;
import com.cg.model.LocationRegion;
import com.cg.model.dto.CustomerAvatarDTO;
import com.cg.model.product.Product;
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
public class ProductUpdateResDTO {
    private Long id;

    private BigDecimal price;
    private String title;
    private Long quantity;
    private String description;
    private ProductAvatarDTO productAvatar;

    public ProductUpdateResDTO(Product product, ProductAvatarDTO productAvatar) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.title = product.getTitle();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.productAvatar = productAvatar;
    }
}
