package com.credera.db.controller;

import com.credera.db.model.Properties;
import com.credera.db.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/properties")
public class PropertiesController {

    @Autowired
    private PropertiesService propertiesService;

    @PostMapping("/add")
    public ResponseEntity<Properties> addProperties(@RequestBody Properties properties) throws Exception {
        return propertiesService.saveProperties(properties).map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Error"));
    }
}
