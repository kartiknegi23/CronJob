package com.credera.training.cronjob.service.impl;

import com.credera.training.cronjob.dto.Properties;
import com.credera.training.cronjob.service.PropertiesService;
import com.credera.training.cronjob.utils.PropertiesCSVParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PropertiesCSVParser propertiesCSVParser;

    @Override
    public void processPropertiesFile() {
        log.info("Parsing Starting");
        propertiesCSVParser.parsePropertiesCSV("D:\\CronJob\\Files\\properties.csv").forEach(properties -> {
            restTemplate.postForEntity("http://localhost:8080/api/properties/add", properties, Properties.class);
        });
        log.info("Parsing Completing");
    }
}
