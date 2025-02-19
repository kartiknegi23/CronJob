package com.credera.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.credera.db.model.Variant;

@Repository
public interface VariantRepository extends JpaRepository<Variant, String> {

}
