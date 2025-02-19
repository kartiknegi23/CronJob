package com.credera.db.service;

import java.util.Optional;
import com.credera.db.model.Variant;

public interface VariantService {

	public Optional<Variant> saveVariant(Variant variant);
}
