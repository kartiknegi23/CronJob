package com.credera.training.cronjob.service.impl;

import com.credera.training.cronjob.dto.MasterVariantDTO;
import com.credera.training.cronjob.service.MasterVariantService;
import com.credera.training.cronjob.utils.MasterVariantCSVParser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MasterVariantServiceImpl implements MasterVariantService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MasterVariantCSVParser masterVariantCSVParser;

    public int count = 0;

    public void processFile() {
        processMasterVariantFile();


    }

    @Override
    public void processMasterVariantFile() {
        log.info("==================== processProductFile ====================" + count++);
        masterVariantCSVParser.parseMasterVariantCSV("D:\\CronJob\\Files\\master_variant.csv").forEach(masterVariant -> {
            restTemplate.postForEntity("http://localhost:8080/api/masterVariant/add", masterVariant, MasterVariantDTO.class);
        });
    }
}
