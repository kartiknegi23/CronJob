package com.credera.training.cronjob.utils;

import com.credera.training.cronjob.dto.PriceDTO;

import java.util.List;

public interface PriceCSVParser {
    public List<PriceDTO> parsePriceCSV(String filepath);
}
