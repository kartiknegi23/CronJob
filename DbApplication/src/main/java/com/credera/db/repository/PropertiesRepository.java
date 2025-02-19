package com.credera.db.repository;


import com.credera.db.model.Properties;
import com.credera.db.model.PropertiesCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, PropertiesCompositeKey> {
}
