package com.ppm.dataimport.repository;

import com.ppm.dataimport.model.DataSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSetRepository extends JpaRepository<DataSet,Long> {
}
