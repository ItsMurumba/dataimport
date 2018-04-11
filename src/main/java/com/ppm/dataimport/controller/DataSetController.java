package com.ppm.dataimport.controller;

import com.ppm.dataimport.model.DataSet;
import com.ppm.dataimport.repository.DataSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DataSetController {

    @Autowired
    DataSetRepository dataSetRepository;

    //Create DataSet Record
    @PostMapping("/datasets")
    public DataSet createDataSetRecord(@Valid @RequestBody DataSet dataSet){
        return dataSetRepository.save(dataSet);
    }

    //Get a Single Dataset Record
    @GetMapping("/datasets/{id}")
    public ResponseEntity<DataSet> getDataSetRecordById(@PathVariable(value = "id")Long DataSetRecordId){
        DataSet dataSet=dataSetRepository.getOne(DataSetRecordId);
        if (dataSet==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dataSet);
    }

    //Update Dataset Record
    @PutMapping("/datasets/{id}")
    public ResponseEntity<DataSet> updateDataSetRecord(@PathVariable(value = "id")Long DataSetRecordId,
                                                       @Valid @RequestBody DataSet dataSetDetails){
        DataSet dataSet=dataSetRepository.getOne(DataSetRecordId);
        if (dataSet==null){
            return ResponseEntity.notFound().build();
        }
        dataSet.setData_set_name(dataSetDetails.getData_set_name());
        dataSet.setData_element_name(dataSetDetails.getData_element_name());
        dataSet.setCategory_option_combo(dataSetDetails.getCategory_option_combo());
        dataSet.setAttributes_option_combo(dataSetDetails.getAttributes_option_combo());

        DataSet updateDataSet=dataSetRepository.save(dataSet);
        return ResponseEntity.ok(updateDataSet);
    }

    //Delete Dataset Record
    @DeleteMapping("/datasets/{id}")
    public ResponseEntity<DataSet> deleteDataSetRecord(@PathVariable(value = "id")Long DataSetRecordId){
        DataSet dataSet=dataSetRepository.getOne(DataSetRecordId);
        if (dataSet==null){
            return ResponseEntity.notFound().build();
        }
        dataSetRepository.delete(dataSet);
        return ResponseEntity.ok().build();
    }

}
