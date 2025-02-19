package com.credera.db.service;

import com.credera.db.model.Properties;

import java.util.Optional;

public interface PropertiesService {
    public Optional<Properties> saveProperties(Properties properties);
}
