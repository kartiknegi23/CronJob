package com.credera.db.service;

import java.util.Optional;

import com.credera.db.model.MasterVariant;

public interface MasterVariantService {

    public Optional<MasterVariant> saveMasterVariant(MasterVariant masterVariant);
}
