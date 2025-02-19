package com.credera.training.cronjob.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Variant {

    @Column(name = "product_id")
    private String productId;
    @Id
    @Column(name = "variant_id")
    private String variantId;

    @Column(name = "variant_name")
    private String variantName;
}
