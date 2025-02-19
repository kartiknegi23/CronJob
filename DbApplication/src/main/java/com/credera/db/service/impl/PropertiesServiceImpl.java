package com.credera.db.service.impl;

import com.credera.db.model.Properties;
import com.credera.db.repository.PropertiesRepository;
import com.credera.db.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private PropertiesRepository propertiesRepository;

    @Override
    public Optional<Properties> saveProperties(Properties properties) {
        return Optional.of(properties).map(propertiesRepository::save);
    }
}
