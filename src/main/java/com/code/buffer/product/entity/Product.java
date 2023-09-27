package com.code.buffer.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="product_price")
    private Double price;

    @Column(name="product_name")
    private String productName;

    @Column(name="quantity")
    private Long quantity;

    @Column(name="created_date",updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name="updated_date",insertable = false )
    @UpdateTimestamp
    private LocalDate updatedDate;



}

