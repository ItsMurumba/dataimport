package com.ppm.dataimport.controller;

import com.ppm.dataimport.model.DataSets;
import com.ppm.dataimport.repository.DataSetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class DataSetsController {
    @Autowired
    DataSetsRepository dataSetsRepository;

    //Create new DataSet Record
    @PostMapping("/dataset")
    public DataSets createDataSetRecord(@Valid @RequestBody DataSets dataSets){
        return dataSetsRepository.save(dataSets);
    }

    //Get a single Dataset Record
    @GetMapping("/dataset/{id}")
    public ResponseEntity<DataSets> getDataSetRecordById(@PathVariable(value = "id")Long dataSetRecordId){
        DataSets dataSets=dataSetsRepository.getOne(dataSetRecordId);
        if (dataSets==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dataSets);
    }

    //Update Dataset Record
    @PutMapping("/dataset/{id}")
    public ResponseEntity<DataSets> updateDataSet(@PathVariable(value = "id")Long dataSetRecordId,
                                                  @Valid @RequestBody DataSets dataSetsDetails){
        DataSets dataSets=dataSetsRepository.getOne(dataSetRecordId);
        if (dataSets==null){
            return ResponseEntity.notFound().build();
        }
        dataSets.setDataSetName(dataSetsDetails.getDataSetName());

        DataSets updateDataSets=dataSetsRepository.save(dataSets);
        return ResponseEntity.ok(updateDataSets);
    }

    //Delete DataSet record
    @DeleteMapping("/dataset/{id}")
    public ResponseEntity<DataSets> deleteDataSet(@PathVariable(value = "id")Long dataSetRecordId){
        DataSets dataSets=dataSetsRepository.getOne(dataSetRecordId);
        if (dataSets==null){
            return ResponseEntity.notFound().build();
        }
        dataSetsRepository.delete(dataSets);
        return ResponseEntity.ok().build();
    }
}
