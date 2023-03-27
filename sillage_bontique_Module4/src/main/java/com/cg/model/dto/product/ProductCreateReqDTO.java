package com.cg.model.dto.product;
//
//import com.cg.model.product.ProdCategory;
//import com.cg.model.product.ProdType;
import com.cg.model.enums.EProdCategory;

import com.cg.model.product.Product;
import com.cg.model.product.ProductAvatar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreateReqDTO implements Validator {

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
                .setProductAvatar(productAvatar);

    }

//    private String prodTypeStr;
//
//    private ProdType prodType;
//
//    private String prodCategoryStr;
//
//    private ProdCategory prodCategory;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductCreateReqDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductCreateReqDTO productCreateReqDTO = (ProductCreateReqDTO) target;
        String priceStr = productCreateReqDTO.getPrice().toString();
        MultipartFile file = productCreateReqDTO.getAvatarFile();


        if (priceStr==null|| priceStr.trim().equals("")) {
            errors.rejectValue("price", "price.empty","Product price is required");
        }
        else if (!priceStr.matches("[0-9]+")) {
            errors.rejectValue("price", "price.format", "Product price is invalid");
        }
        else {
            BigDecimal price = BigDecimal.valueOf(Long.parseLong(priceStr));
            BigDecimal minP = BigDecimal.valueOf(100L);
            BigDecimal maxP = BigDecimal.valueOf(10000L);
            if (price.compareTo(minP) < 0 || price.compareTo(maxP) > 0) {
                errors.rejectValue("price", "price.range", "Product price is from 100$ to 10000$");
            }
        }
        if (file == null) {
            errors.rejectValue("file", "file.empty", "Product image is required");
        }



    }
}