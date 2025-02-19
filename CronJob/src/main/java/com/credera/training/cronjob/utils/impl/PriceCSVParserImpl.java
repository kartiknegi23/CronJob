package com.credera.training.cronjob.utils.impl;

import com.credera.training.cronjob.dto.MasterVariantDTO;
import com.credera.training.cronjob.dto.PriceDTO;
import com.credera.training.cronjob.utils.PriceCSVParser;
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
public class PriceCSVParserImpl implements PriceCSVParser {

    @Override
    public List<PriceDTO> parsePriceCSV(String filePath){

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            List<PriceDTO> prices = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord record : csvRecords) {

                PriceDTO csvRecord = new PriceDTO();

                csvRecord.setVariantId(record.get("variant_id"));
                csvRecord.setCurrency(record.get("currency"));
                csvRecord.setPrice(Integer.parseInt(record.get("price")));
                System.out.println(csvRecord);
                prices.add(csvRecord);
            }

            System.out.println(prices);
            return prices;

        } catch (IOException e) {
            throw new RuntimeException("CSV data is failed to parse: " + e.getMessage());
        }

    }

}
