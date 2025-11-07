package com.RSM.RoyalApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "sales_payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String customerName;

    @Column(nullable = false)
    private String billNo;

    private Double paidAmount;
    private LocalDate paymentDate;
    private String paymentMode; // e.g. Cash, UPI, Bank, etc.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    @JsonBackReference
    private Sale sale;

}

