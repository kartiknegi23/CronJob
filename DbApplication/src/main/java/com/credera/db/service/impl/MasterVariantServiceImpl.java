package com.credera.db.service.impl;

import com.credera.db.model.MasterVariant;
import com.credera.db.repository.MasterVariantRepository;
import com.credera.db.service.MasterVariantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MasterVariantServiceImpl implements MasterVariantService {

    @Autowired
    private MasterVariantRepository masterVariantRepository;


    public Optional<MasterVariant> saveMasterVariant(MasterVariant masterVariant) {
        masterVariantRepository.saveAndFlush(masterVariant);

        return Optional.empty();
    }
}
