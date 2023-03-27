package com.cg.service.product;

import com.cg.exception.DataInputException;
import com.cg.model.Customer;
import com.cg.model.CustomerAvatar;
import com.cg.model.LocationRegion;
import com.cg.model.dto.CustomerResDTO;
import com.cg.model.dto.CustomerUpdateAvatarResDTO;
import com.cg.model.dto.product.*;
//import com.cg.model.product.ProdType;
import com.cg.model.product.Product;
import com.cg.model.product.ProductAvatar;
import com.cg.repository.ProductAvatarRepository;
import com.cg.repository.ProductRepository;
import com.cg.service.uploadMedia.UploadService;
import com.cg.utils.UploadUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAvatarRepository productAvatarRepository;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private UploadUtils uploadUtils;



    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ProductCreateResDTO create(ProductCreateReqDTO productCreateReqDTO) {
        ProductAvatar productAvatar = new ProductAvatar();
        productAvatarRepository.save(productAvatar);
        uploadAndSaveProductAvatar(productCreateReqDTO.getAvatarFile(), productAvatar);
        Product product = productCreateReqDTO.toProduct(productAvatar);
        product.setId(null);
        product.setQuantity(0L);
        productRepository.save(product);

        return new ProductCreateResDTO(product, productAvatar);
    }
    private void uploadAndSaveProductAvatar(MultipartFile file, ProductAvatar productAvatar) {
        try {
            Map uploadResult = uploadService.uploadImage(file, uploadUtils.buildProductImageUploadParams(productAvatar));
            String fileUrl = (String) uploadResult.get("secure_url");
            String fileFormat = (String) uploadResult.get("format");

            productAvatar.setFileName(productAvatar.getId() + "." + fileFormat);
            productAvatar.setFileUrl(fileUrl);
            productAvatar.setFileFolder(uploadUtils.PRODUCT_IMAGE_UPLOAD_FOLDER);
            productAvatar.setCloudId(productAvatar.getFileFolder() + "/" + productAvatar.getId());
            productAvatarRepository.save(productAvatar);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }
    @Override
    public List<ProductResDTO> findAllProductByDeletedFalse() {

        return productRepository.findAllProductByDeletedFalse();
    }
    @Override
    public Optional<ProductResDTO> findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public ProductUpdateResDTO updateWithAvatar(Product product, MultipartFile avatarFile) throws IOException {
        return null;
    }

//    @Override
//    public CustomerUpdateAvatarResDTO updateWithAvatar(Product product, MultipartFile avatarFile) throws IOException {
//        LocationRegion locationRegion = customer.getLocationRegion();
//        locationRegionRepository.save(locationRegion);
//
//        customer.setLocationRegion(locationRegion);
//
//        customerRepository.save(customer);
//
//        Optional<CustomerAvatar> customerAvatarOptional = customerAvatarRepository.findByCustomer(customer);
//
//        CustomerAvatar customerAvatar = new CustomerAvatar();
//
//        if (!customerAvatarOptional.isPresent()) {
//            customerAvatar.setCustomer(customer);
//
//            customerAvatarRepository.save(customerAvatar);
//
//            uploadAndSaveCustomerAvatar(avatarFile, customerAvatar);
//        }
//        else {
//            customerAvatar = customerAvatarOptional.get();
//            uploadService.destroyImage(customerAvatar.getCloudId(), uploadUtils.buildImageUploadParams(customerAvatar));
//            uploadAndSaveCustomerAvatar(avatarFile, customerAvatar);
//        }
//
//        return new CustomerUpdateAvatarResDTO(customer, locationRegion, customerAvatar.toCustomerAvatarDTO());
//    }

}
