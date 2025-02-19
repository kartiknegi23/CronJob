package com.credera.training.cronjob.utils;

import com.credera.training.cronjob.dto.Properties;

import java.util.List;

public interface PropertiesCSVParser {

    public List<Properties> parsePropertiesCSV(String filePath);
}