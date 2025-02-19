package com.credera.db.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credera.db.model.Price;
import com.credera.db.repository.PriceRepository;
import com.credera.db.service.PriceService;


@Service
public class PriceServiceIImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Optional<Price> savePrice(Price price){
        return Optional.of(price).map(priceRepository::save);
    }
}
