package com.cg.service.product;

import com.cg.model.Customer;
import com.cg.model.dto.CustomerUpdateAvatarResDTO;
import com.cg.model.dto.product.ProductCreateReqDTO;
import com.cg.model.dto.product.ProductCreateResDTO;
import com.cg.model.dto.product.ProductResDTO;
import com.cg.model.dto.product.ProductUpdateResDTO;
import com.cg.model.product.Product;
import com.cg.service.IGeneralService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface IProductService extends IGeneralService <Product>{
    ProductCreateResDTO create(ProductCreateReqDTO productCreateReqDTO);
    List<ProductResDTO> findAllProductByDeletedFalse();
    Optional<ProductResDTO> findProductById(Long id);
    ProductUpdateResDTO updateWithAvatar(Product product, MultipartFile avatarFile) throws IOException;
}
