//package com.cg.service.productCategory;
//
//import com.cg.model.product.ProdCategory;
//import com.cg.model.enums.EProdCategory;
//import com.cg.repository.ProdCategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductCategoryService implements IProdCategoryService{
//    @Autowired
//    ProdCategoryRepository prodCategoryRepository;
//
//    @Override
//    public List<ProdCategory> findAll() {
//        return prodCategoryRepository.findAll();
//    }
//
//    @Override
//    public Optional<ProdCategory> findById(Long id) {
//        return prodCategoryRepository.findById(id);
//    }
//
//    @Override
//    public Boolean existById(Long id) {
//        return null;
//    }
//    @Override
//    public Optional<ProdCategory> findByName(EProdCategory name) {
//        return prodCategoryRepository.findByName(name);
//    }
//
//    @Override
//    public ProdCategory save(ProdCategory prodCategory) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//
//    @Override
//    public void delete(ProdCategory prodCategory) {
//
//    }
//
//}
