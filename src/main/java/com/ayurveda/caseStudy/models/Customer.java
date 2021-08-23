package com.ayurveda.caseStudy.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull(message  = "Can't be null")
    @ToString.Include
    Long id;

    @NonNull
    @NotBlank(message = "Please provide first name")
    @ToString.Include
    String firstName;

    @NonNull
    @ToString.Include
    @NotBlank(message = "Please provide last name")
    String lastName;

    @NonNull
    @ToString.Include
    @Email(message = "Please enter a valid email", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    //@NotBlank(message = "Please provide email")
    String email;

    @NonNull
    //@NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$",message= "Password must contain: at least one digit [0-9],\n" +
            " at least one lowercase character [a-z],\n" +
            " at least one uppercase character [A-Z],\n" +
            " at least one special character like ! @ # & ( ),\n" +
            " must contain a length between 8 and 20 characters.")
    String password;


    //@NotBlank
    @ToString.Include
    String address;

    @OneToMany(cascade = CascadeType.ALL)
    List<Product> products;

    public Customer(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
