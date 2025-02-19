package com.credera.training.cronjob.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.credera.training.cronjob.dto.Variant;
import com.credera.training.cronjob.service.VariantService;
import com.credera.training.cronjob.utils.VariantCSVParser;


@Service
public class VariantServiceImpl implements VariantService{
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private VariantCSVParser variantCSVParser;
	
	Logger log = LoggerFactory.getLogger(VariantServiceImpl.class);
	 
	@Override
	public void processVariantFile() {
		log.info("==================== processVariantFile ====================\"+ count++");
		
		String filePath = "D:\\CronJob\\Files\\variants.csv";
	    Path path = Paths.get(filePath);
	    
	    if (Files.exists(path)) {
	        log.info("File exists: " + filePath);
	        variantCSVParser.parseVariantCSV(filePath).forEach(variant -> {
	            restTemplate.postForEntity("http://localhost:8080/api/variant/add", variant, Variant.class);
	        });
	    } else {
	        log.warn("File not found at: " + filePath + ". Skipping processing.");
	    }
		
	}
}
