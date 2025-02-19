package com.credera.training.cronjob.utils;

import java.util.List;

import com.credera.training.cronjob.dto.Variant;

public interface VariantCSVParser {
	
	public List<Variant> parseVariantCSV(String filePath);
}
