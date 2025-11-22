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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "sale_id")
//    @JsonBackReference
//    private Sale sale; facing error : 2025-11-14T01:05:44.146+05:30  WARN 97647 --- [RoyalApi] [nio-8080-exec-9] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot construct instance of `com.RSM.RoyalApi.entity.Sale` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('322babfd-d3d3-4431-8d50-39675a5b628e')]
    private UUID sale;
}

