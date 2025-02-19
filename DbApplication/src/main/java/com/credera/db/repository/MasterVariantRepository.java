package com.credera.db.repository;

import com.credera.db.model.MasterVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterVariantRepository extends JpaRepository<MasterVariant, String> {
}
