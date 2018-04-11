package com.ppm.dataimport.repository;

import com.ppm.dataimport.model.GeneralAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralAttributesRepository extends JpaRepository<GeneralAttributes,Long> {
}
