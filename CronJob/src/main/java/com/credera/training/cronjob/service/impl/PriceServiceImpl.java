package com.credera.training.cronjob.service.impl;

import com.credera.training.cronjob.dto.PriceDTO;
import com.credera.training.cronjob.service.PriceService;
import com.credera.training.cronjob.utils.PriceCSVParser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PriceCSVParser priceCSVParser;

    Logger log = LoggerFactory.getLogger(VariantServiceImpl.class);

    @Override
    public void processPriceFile(){
        log.info("Parsing Starting");

        priceCSVParser.parsePriceCSV("D:\\CronJob\\Files\\prices.csv").forEach(prices-> {
            restTemplate.postForEntity("http://localhost:8080/api/price/add", prices, PriceDTO.class);
        });

    }
}
