package com.credera.training.cronjob.utils.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.credera.training.cronjob.dto.Variant;
import com.credera.training.cronjob.utils.VariantCSVParser;

@Component
public class VariantCSVParserImpl implements VariantCSVParser {

	@Override
	public List<Variant> parseVariantCSV(String filePath) {
		List<Variant> variants = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                Variant variant = new Variant(
                        record.get("product_id"),
                        record.get("variant_id"),
                        record.get("variant_name")
                );
                variants.add(variant);
                System.out.print(variant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return variants;
	}

}
