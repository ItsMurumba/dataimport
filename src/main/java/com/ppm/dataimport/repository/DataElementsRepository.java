package com.ppm.dataimport.repository;

import com.ppm.dataimport.model.DataElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataElementsRepository extends JpaRepository<DataElement,Long> {
}
