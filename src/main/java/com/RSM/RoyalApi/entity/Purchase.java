package com.RSM.RoyalApi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "purchases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String inoiceNo;

    @Column(nullable = false)
    private String supplierName;

    private String address;
    private String contact;

    @Column(nullable = false)
    private String galaNo;

    private String gstNumber;
    @Column(nullable = false)
    private LocalDate purchaseDate = LocalDate.now();

    private Double totalGst;
    private Double charges;
    private Double transportCharges;
    private Double labourCharges;
    private Double totalCharges;
    private Double totalAmount;
    private Double amountWithoutCharges;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PurchaseItem> items;
}

