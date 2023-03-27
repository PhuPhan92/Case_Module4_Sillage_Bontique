package com.cg.api;


//import com.cg.exception.DataInputException;
//import com.cg.exception.EmailExistsException;
//import com.cg.model.Customer;
//import com.cg.model.dto.CustomerCreateAvatarReqDTO;
//import com.cg.model.dto.CustomerCreateAvatarResDTO;
//import com.cg.model.dto.CustomerDTO;
//import com.cg.model.dto.LocationRegionDTO;
//import com.cg.model.product.ProdCategory;
//import com.cg.model.product.ProdType;
//import com.cg.model.product.Product;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Customer;
import com.cg.model.dto.CustomerAvatarDTO;
import com.cg.model.dto.CustomerDTO;
import com.cg.model.dto.CustomerResDTO;
import com.cg.model.dto.product.*;
//import com.cg.model.dto.product.ProductEditReqDTO;
//import com.cg.model.dto.product.ProductResponseDTO;
//import com.cg.model.enums.EProdCategory;
//import com.cg.model.enums.EProdType;
//import com.cg.repository.ProdCategoryRepository;
//import com.cg.service.productCategory.IProdCategoryService;
//import com.cg.service.productType.IProductTypeService;
import com.cg.model.product.Product;
import com.cg.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductAPI {
    @Autowired
    private IProductService productService;

//    @Autowired
//
//    private IProductTypeService productTypeService;
//
//    @Autowired
//    private IProdCategoryService prodCategoryService;

    @PostMapping
    public ResponseEntity<?> create(ProductCreateReqDTO productCreateReqDTO) {
        ProductCreateResDTO productCreateResDTO = productService.create(productCreateReqDTO);
        return new ResponseEntity<>(productCreateResDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAll() {

//        List<Customer> customers = customerService.findAll();

        List<ProductResDTO> productResDTOS = productService.findAllProductByDeletedFalse();
        List<ProductDTO> productDTOS = new ArrayList<>();
//
        for (ProductResDTO item : productResDTOS) {
            ProductAvatarDTO productAvatarDTO = new ProductAvatarDTO();
            productAvatarDTO.setId(item.getAvatarId());
            productAvatarDTO.setFileFolder(item.getFileFolder());
            productAvatarDTO.setFileName(item.getFileName());
            productAvatarDTO.setFileUrl(item.getFileUrl());
            ProductDTO productDTO = item.toProductDTO(productAvatarDTO);
            productDTOS.add(productDTO);
        }

        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<?> getById(@PathVariable Long productId) {


        Optional<ProductResDTO> productResDTO = productService.findProductById(productId);

        if (!productResDTO.isPresent()) {
            throw new ResourceNotFoundException("Product not valid");
        }

        ProductAvatarDTO productAvatarDTO = new ProductAvatarDTO();
        productAvatarDTO.setId(productResDTO.get().getAvatarId());
        productAvatarDTO.setFileFolder(productResDTO.get().getFileFolder());
        productAvatarDTO.setFileName(productResDTO.get().getFileName());
        productAvatarDTO.setFileUrl(productResDTO.get().getFileUrl());

        ProductDTO productDTO = productResDTO.get().toProductDTO(productAvatarDTO);

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> delete(@PathVariable Long productId) throws IOException {

        Optional<Product> productOptional = productService.findById(productId);

        if (!productOptional.isPresent()) {
            throw new ResourceNotFoundException("Product invalid");
        }
        Product product  = productOptional.get();
        product.setDeleted(true);
        productService.save(product);

        return new ResponseEntity<>(product.toProductCreateResDTO(),HttpStatus.OK);
    }



}
