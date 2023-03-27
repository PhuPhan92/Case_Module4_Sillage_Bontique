package com.cg.repository;

import com.cg.model.dto.product.ProductResDTO;
import com.cg.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT NEW com.cg.model.dto.product.ProductResDTO (" +
            "pro.id, " +
            "pro.title, " +
            "pro.price, " +
            "pro.quantity, " +
            "pro.description, " +
            "ca.id, " +
            "ca.fileFolder, " +
            "ca.fileName, " +
            "ca.fileUrl " +
            ") " +
            "FROM Product AS pro " +
            "JOIN ProductAvatar AS ca " +
            "ON pro.productAvatar = ca " +
            "WHERE pro.deleted = false "
    )
    List<ProductResDTO> findAllProductByDeletedFalse();
    @Query("SELECT NEW com.cg.model.dto.product.ProductResDTO (" +
            "pro.id, " +
            "pro.title, " +
            "pro.price, " +
            "pro.quantity, " +
            "pro.description, " +
            "ca.id, " +
            "ca.fileFolder, " +
            "ca.fileName, " +
            "ca.fileUrl " +
            ") " +
            "FROM Product AS pro " +
            "JOIN ProductAvatar AS ca " +
            "ON pro.productAvatar = ca " +
            "WHERE pro.deleted = false "+
            "AND pro.id = :id "
    )
    Optional<ProductResDTO> findProductById(@Param("id") Long id);


}
