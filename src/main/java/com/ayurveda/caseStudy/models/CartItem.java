package com.ayurveda.caseStudy.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity

public class CartItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    int quantity;


}
