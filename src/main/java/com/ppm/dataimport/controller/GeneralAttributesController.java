package com.ppm.dataimport.controller;

import com.ppm.dataimport.model.GeneralAttributes;
import com.ppm.dataimport.repository.GeneralAttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class GeneralAttributesController {
    @Autowired
    GeneralAttributesRepository generalAttributesRepository;

    //Create new GeneralAttributes Record
    @PostMapping("/generalattributes")
    public GeneralAttributes createGeneralAttributes(@Valid @RequestBody GeneralAttributes generalAttributes){
        return generalAttributesRepository.save(generalAttributes);
    }

    //Get a Single GeneralAttributes Record
    @GetMapping("/generalattributes/{id}")
    public ResponseEntity<GeneralAttributes> getGeneralAttributesById(@PathVariable(value = "id")Long GeneralAttributesId){
        GeneralAttributes generalAttributes=generalAttributesRepository.getOne(GeneralAttributesId);
        if (generalAttributes==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(generalAttributes);
    }

    //Update GeneralAttributes Record
    @PutMapping("generalattributes/{id}")
    public ResponseEntity<GeneralAttributes> updateGeneralAttributes(@PathVariable(value = "id")Long GeneralAttributesId,
                                                                     @Valid @RequestBody GeneralAttributes generalAttributesDetails){
        GeneralAttributes generalAttributes=generalAttributesRepository.getOne(GeneralAttributesId);
        if (generalAttributes==null){
            return ResponseEntity.notFound().build();
        }
        generalAttributes.setImplementing_mechanism_uid(generalAttributesDetails.getImplementing_mechanism_uid());
        generalAttributes.setStored_by(generalAttributesDetails.getStored_by());

        GeneralAttributes updateGeneralAttributes=generalAttributesRepository.save(generalAttributes);
        return ResponseEntity.ok(updateGeneralAttributes);
    }

    //Delete GeneralAttributes Record
    @DeleteMapping("generalattributes/{id}")
    public ResponseEntity<GeneralAttributes> DeleteGeneralAttributes(@PathVariable(value = "id")Long GeneralAttributesId){
        GeneralAttributes generalAttributes=generalAttributesRepository.getOne(GeneralAttributesId);
        if (generalAttributes==null){
            return ResponseEntity.notFound().build();
        }
        generalAttributesRepository.delete(generalAttributes);
        return ResponseEntity.ok().build();
    }
}
