package com.credera.training.cronjob.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PROPERTIES")
@AllArgsConstructor
@NoArgsConstructor
public class Properties {

    @EmbeddedId
    private PropertiesCompositeKey id;

    @ManyToOne
    @MapsId("variantId")
    @JoinColumn(name = "variant_id")
    private Variant variant;

    @Column(name = "property_value")
    private String propertyValue;

    public Properties(Variant variant, String propertyValue, String propertyName) {
        super();
        this.id = PropertiesCompositeKey.builder().variantId(variant.getVariantId()).propertyName(propertyName).build();
        this.propertyValue = propertyValue;
        this.variant = variant;
    }
}