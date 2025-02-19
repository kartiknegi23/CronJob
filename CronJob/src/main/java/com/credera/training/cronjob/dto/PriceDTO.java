package com.credera.training.cronjob.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceDTO {

    @Id
    @Column(name = "variant_id")
    private String variantId;

    @Column(name = "currency")
    private String currency;

    @Column(name = "price")
    private int price;
}
