package com.credera.training.cronjob.utils.impl;

import com.credera.training.cronjob.dto.MasterVariantDTO;
import com.credera.training.cronjob.utils.MasterVariantCSVParser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MasterVariantCSVParserImpl implements MasterVariantCSVParser {

    @Override
    public List<MasterVariantDTO> parseMasterVariantCSV(String filePath) {

        try (BufferedReader bReader = new BufferedReader(new FileReader(filePath));
             CSVParser csvParser = new CSVParser(bReader, CSVFormat.DEFAULT.withHeader())) {
            List<MasterVariantDTO> mastervariants = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord record : csvRecords) {

                MasterVariantDTO csvRecord = new MasterVariantDTO();

                csvRecord.setProductId(record.get("product_id"));
                csvRecord.setMasterVariantId(record.get("master_variant_id"));
                csvRecord.setProductName(record.get("product_name"));
                csvRecord.setProductType(record.get("product_type"));
                csvRecord.setDescription(record.get("description"));
                csvRecord.setPublished(Boolean.parseBoolean(record.get("is_published")));
                System.out.println(csvRecord);
                mastervariants.add(csvRecord);
            }

            System.out.println(mastervariants);
            return mastervariants;
        } catch (IOException e) {
            throw new RuntimeException("CSV data is failed to parse: " + e.getMessage());
        }
    }
}
