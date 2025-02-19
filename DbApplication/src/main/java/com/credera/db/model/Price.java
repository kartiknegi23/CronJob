package com.credera.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PRICES")
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    @Column(name = "variant_id")
    private String variantId;

    @Column(name = "currency")
    private String currency;

    @Column(name = "price")
    private int price;
}
