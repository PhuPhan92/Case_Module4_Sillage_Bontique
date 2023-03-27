//package com.cg.model.product;
//
//import com.cg.model.enums.EProdCategory;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "product_categories")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class ProdCategory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//
//    @Enumerated(EnumType.STRING)
//    private EProdCategory name;
//
//    @OneToMany(mappedBy = "prodCategory")
//    private List<Product> products;
//
//}