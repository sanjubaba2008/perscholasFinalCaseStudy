package com.ayurveda.caseStudy.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    Long pid;

    @NonNull
    @ToString.Include
    String name;

    @NonNull
    @ToString.Include
    Double price;

    @NonNull
    Integer stock;

    @NonNull
    @Column(length = 700)
    String description;


}
