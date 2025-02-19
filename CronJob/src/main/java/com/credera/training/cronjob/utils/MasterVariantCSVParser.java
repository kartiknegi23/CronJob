package com.credera.training.cronjob.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.credera.training.cronjob.dto.MasterVariantDTO;


public interface MasterVariantCSVParser {


    public List<MasterVariantDTO> parseMasterVariantCSV(String filePath);
}
