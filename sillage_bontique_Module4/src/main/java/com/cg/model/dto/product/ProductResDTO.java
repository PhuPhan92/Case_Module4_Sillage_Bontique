package com.cg.model.dto.product;

import com.cg.model.LocationRegion;
import com.cg.model.dto.CustomerAvatarDTO;
import com.cg.model.dto.CustomerDTO;
import com.cg.model.dto.LocationRegionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private Long quantity;
    private String description;
    private String avatarId;
    private String fileFolder;
    private String fileName;
    private String fileUrl;

    public ProductResDTO(Long id, String title, String description, BigDecimal price, Long quantity, String fileFolder, String fileName, String fileUrl,String avatarId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.fileFolder = fileFolder;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.avatarId = avatarId;

    }

    public ProductDTO toProductDTO(ProductAvatarDTO productAvatarDTO) {
        return new ProductDTO()
                .setId(id)
                .setTitle(title)
                .setQuantity(quantity)
                .setDescription(description)
                .setPrice(price)
                .setProductAvatar(productAvatarDTO)
                ;
    }

}
