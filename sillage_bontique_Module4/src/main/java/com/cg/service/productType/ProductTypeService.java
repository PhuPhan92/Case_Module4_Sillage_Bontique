//package com.cg.service.productType;
//
//import com.cg.model.product.ProdType;
//import com.cg.model.enums.EProdType;
//import com.cg.repository.ProductTypeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductTypeService implements IProductTypeService {
//
//    @Autowired
//    ProductTypeRepository productTypeRepository;
//    @Autowired
//    private ProductTypeRepository prodTypeRepository;
//
//    @Override
//    public List<ProdType> findAll() {
//        return productTypeRepository.findAll();
//    }
//
//    @Override
//    public Optional<ProdType> findById(Long id) {
//        return productTypeRepository.findById(id);
//    }
//
//    @Override
//    public Boolean existById(Long id) {
//        return null;
//    }
//
//    @Override
//    public ProdType save(ProdType prodType) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//
//    @Override
//    public void delete(ProdType prodType) {
//
//    }
//
//    @Override
//    public ProdType findByName(EProdType name) {
//        return prodTypeRepository.findByName(name);
//    }
//
//    @Override
//    public ProdType findByName(String name) {
//        return productTypeRepository.findByName(name);
////        return null;
//    }
//}
