package com.ecom.customerorder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private com.ecom.customerorder.model.Customer customer;
    /*@ManyToOne →Many orders can belong to one customer.
        The customer field in this class links each order to a specific customer.

        @JoinColumn(name = "customer_id", nullable = false) →
        Specifies that the customer_id column in the database will store the foreign key.
        nullable = false ensures that every order must be linked to a customer.*/
}
