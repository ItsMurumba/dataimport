package com.ppm.dataimport.repository;

import com.ppm.dataimport.model.OrgUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgUnitRepository extends JpaRepository<OrgUnit,Long> {
}
