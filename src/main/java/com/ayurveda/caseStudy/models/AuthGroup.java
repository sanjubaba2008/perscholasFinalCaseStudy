package com.ayurveda.caseStudy.models;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class AuthGroup implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authId;

    @NonNull
    Long customerId;

    @NonNull
    String authGroup;//either customer role, admin role
    //one user can have many authorizations
    //e.g id 1 can be admin as well as customer and so on

}
