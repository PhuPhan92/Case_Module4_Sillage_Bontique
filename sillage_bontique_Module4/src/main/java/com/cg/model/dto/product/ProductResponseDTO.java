package com.cg.model.dto.product;

//import com.cg.model.product.ProdType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponseDTO {

    private Long id;

    private BigDecimal price;
    private String description;

    private ProductAvatarDTO avatar;

//    private ProdType prodType;

//    private ProdCategoryDTO prodCategory;

}