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
@Table(name = "VARIANT")
@AllArgsConstructor
@NoArgsConstructor
public class Variant {
	

    @Column(name = "product_id")
	private String productId;
	@Id
	@Column(name = "variant_id")
	private String variantId;
	
	@Column(name = "variant_name")
	private String variantName;
}
