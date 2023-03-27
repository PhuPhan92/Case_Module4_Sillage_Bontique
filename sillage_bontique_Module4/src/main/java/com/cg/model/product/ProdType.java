//package com.cg.model.product;
//
//import com.cg.model.enums.EProdType;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "product_types")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class ProdType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 20)
//    private EProdType name;
//}
