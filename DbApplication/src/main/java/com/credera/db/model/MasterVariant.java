package com.credera.db.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "MASTER_VARIANT")
@AllArgsConstructor
@NoArgsConstructor
public class MasterVariant {
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
