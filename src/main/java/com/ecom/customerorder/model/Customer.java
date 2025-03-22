package com.ecom.customerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Order> orders;
    /*A customer can have multiple orders.
    The mappedBy = "customer" indicates that the customer field in the Order entity owns the relationship.
    cascade = CascadeType.ALL means that if a customer is created, updated, or deleted, the same operations will apply to their orders.
    @JsonManagedReference →Used to prevent infinite recursion when serializing objects to JSON.*/
}
