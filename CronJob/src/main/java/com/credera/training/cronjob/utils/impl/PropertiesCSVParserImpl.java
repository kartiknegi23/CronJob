package com.credera.training.cronjob.utils.impl;

import com.credera.training.cronjob.dto.Properties;
import com.credera.training.cronjob.dto.Variant;
import com.credera.training.cronjob.utils.PropertiesCSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PropertiesCSVParserImpl implements PropertiesCSVParser {

    @Autowired
    private VariantCSVParserImpl variantCSVParserImpl;

    @Override
    public List<Properties> parsePropertiesCSV(String filePath) {
        List<Properties> properties = new ArrayList<>();
        try (BufferedReader bReader = new BufferedReader(new FileReader(filePath));
             CSVParser csvParser = new CSVParser(bReader, CSVFormat.DEFAULT.withHeader())) {

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            // Assuming parseVariantCSV returns a List<VariantDTO>
            List<Variant> variants = variantCSVParserImpl.parseVariantCSV("D:\\CronJob\\Files\\variants.csv");

            for (CSVRecord record : csvRecords) {
                Properties csvRecord = null;
                for (Variant variant : variants) {
                    System.out.println(variant);
                    if (variant.getVariantId().equals(record.get("variant_id"))) {
                        csvRecord = new Properties(variant, record.get("property_value"), record.get("property_name"));
                        break; // Found a match, exit the loop
                    }
                }

                if (csvRecord == null) {
                    // Handle the case where no matching VariantDTO is found
                    System.out.println("No matching VariantDTO found for variantId: " + record.get("variant_id"));
                } else {
                    properties.add(csvRecord);
                }
            }

            System.out.println(properties);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
