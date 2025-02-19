package com.credera.training.cronjob.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterVariantDTO {
    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "master_variant_id")
    private String masterVariantId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "description")
    private String description;

    @Column(name = "is_published")
    private boolean isPublished;

}
