package com.RSM.RoyalApi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(nullable = false)
    private String pName;

    private String description;

    @Column(nullable = false)
    private Double Qty;

    private Double sellingPrice;
    private String category;

}
