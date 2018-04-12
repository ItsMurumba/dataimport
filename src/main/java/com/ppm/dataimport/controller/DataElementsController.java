package com.ppm.dataimport.controller;

import com.ppm.dataimport.model.DataElement;
import com.ppm.dataimport.repository.DataElementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DataElementsController {

    @Autowired
    DataElementsRepository dataElementsRepository;

    //Create DataElement Record
    @PostMapping("/dataelements")
    public DataElement createDataSetRecord(@Valid @RequestBody DataElement dataElement){
        return dataElementsRepository.save(dataElement);
    }

    //Get a Single Dataset Record
    @GetMapping("/dataelements/{id}")
    public ResponseEntity<DataElement> getDataSetRecordById(@PathVariable(value = "id")Long DataElementRecordId){
        DataElement dataElement = dataElementsRepository.getOne(DataElementRecordId);
        if (dataElement ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dataElement);
    }

    //Update Dataset Record
    @PutMapping("/dataelements/{id}")
    public ResponseEntity<DataElement> updateDataSetRecord(@PathVariable(value = "id")Long DataElementRecordId,
                                                           @Valid @RequestBody DataElement dataElementDetails){
        DataElement dataElement = dataElementsRepository.getOne(DataElementRecordId);
        if (dataElement ==null){
            return ResponseEntity.notFound().build();
        }
        dataElement.setDataElementName(dataElementDetails.getDataElementName());
        dataElement.setCategoryOptionCombo(dataElementDetails.getCategoryOptionCombo());
        dataElement.setAttributesOptionCombo(dataElementDetails.getAttributesOptionCombo());

        DataElement updateDataElement = dataElementsRepository.save(dataElement);
        return ResponseEntity.ok(updateDataElement);
    }

    //Delete Dataset Record
    @DeleteMapping("/dataelements/{id}")
    public ResponseEntity<DataElement> deleteDataSetRecord(@PathVariable(value = "id")Long DataElementRecordId){
        DataElement dataElement = dataElementsRepository.getOne(DataElementRecordId);
        if (dataElement ==null){
            return ResponseEntity.notFound().build();
        }
        dataElementsRepository.delete(dataElement);
        return ResponseEntity.ok().build();
    }

}
