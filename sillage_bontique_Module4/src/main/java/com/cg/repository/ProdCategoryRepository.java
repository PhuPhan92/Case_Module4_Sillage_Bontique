//package com.cg.repository;
//
//import com.cg.model.product.ProdCategory;
//import com.cg.model.enums.EProdCategory;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface ProdCategoryRepository extends JpaRepository<ProdCategory, Long> {
//    Optional<ProdCategory> findByName(EProdCategory name);
//}