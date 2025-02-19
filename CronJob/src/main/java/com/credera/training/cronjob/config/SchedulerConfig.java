package com.credera.training.cronjob.config;

import com.credera.training.cronjob.service.PriceService;
import com.credera.training.cronjob.service.PropertiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.credera.training.cronjob.service.MasterVariantService;
import com.credera.training.cronjob.service.VariantService;

import java.time.LocalDateTime;

@Slf4j
@Configuration
@EnableScheduling
public class SchedulerConfig {
    @Autowired
    private MasterVariantService masterVariantService;
    
    @Autowired
    private VariantService variantService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private PropertiesService propertiesService;

    @Scheduled(cron = "*/5 * * * * *")
    public void scheduleFileProcessing() {
        log.info("########## Scheduler Started ###############" + LocalDateTime.now());
        masterVariantService.processMasterVariantFile();
        
        log.info("************* VariantFile Started *************");
        variantService.processVariantFile();

        log.info("************ Prices File Started *************");
        priceService.processPriceFile();
        log.info("########## Scheduler Ended ###############" + LocalDateTime.now());

        log.info("************** Properties File Started ********************");
        propertiesService.processPropertiesFile();

    }
}
