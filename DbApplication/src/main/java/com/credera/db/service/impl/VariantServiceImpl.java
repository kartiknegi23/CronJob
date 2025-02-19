package com.credera.db.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credera.db.model.Variant;
import com.credera.db.repository.VariantRepository;
import com.credera.db.service.VariantService;

@Service
public class VariantServiceImpl implements VariantService{

	@Autowired
    private VariantRepository variantRepository;

	@Override
    public Optional<Variant> saveVariant(Variant variant) {
        variantRepository.saveAndFlush(variant);

        return Optional.empty();
    }
}
