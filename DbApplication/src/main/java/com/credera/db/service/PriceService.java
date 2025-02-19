package com.credera.db.service;

import com.credera.db.model.Price;
import java.util.Optional;

public interface PriceService {
    public Optional<Price> savePrice(Price price);
}
