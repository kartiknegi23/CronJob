package com.credera.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertiesCompositeKey implements Serializable {

    @Column(name = "variant_id")
    private String variantId;

    @Column(name = "property_name")
    private String propertyName;

}


