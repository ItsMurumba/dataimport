package com.ppm.dataimport.controller;

import com.ppm.dataimport.model.OrgUnit;
import com.ppm.dataimport.repository.OrgUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class OrgUnitController {
    @Autowired
    OrgUnitRepository orgUnitRepository;

    //Create a new OrgUnit uid record
    @PostMapping("/orgunits")
    public OrgUnit createOrgUnitUidRecord(@Valid @RequestBody OrgUnit orgUnit){
        return orgUnitRepository.save(orgUnit);
    }

    //Get A Single OrgUnitUid Record
    @GetMapping("/orgunits/{id}")
    public ResponseEntity<OrgUnit> getOrgUnitUidRecordById (@PathVariable(value = "id") Long OrgUnitUidRecordId){
       OrgUnit orgUnit = orgUnitRepository.getOne(OrgUnitUidRecordId);
       if(orgUnit==null){
           return ResponseEntity.ok().build();
       }
       return ResponseEntity.ok().body(orgUnit);
    }

    //Update OrgUnitUid Record
    @PutMapping("/orgunits/{id}")
    public ResponseEntity<OrgUnit> updateOrgUNitUidRecord(@PathVariable(value = "id") Long OrgUnitUidRecordId,
                                                          @Valid @RequestBody OrgUnit orgUnitDetails){
        OrgUnit orgUnit= orgUnitRepository.getOne(OrgUnitUidRecordId);
        if (orgUnit==null){
            return ResponseEntity.ok().build();
        }
        orgUnit.setMflCode(orgUnitDetails.getMflCode());
        orgUnit.setName(orgUnitDetails.getName());
        orgUnit.setUid(orgUnitDetails.getUid());

        OrgUnit updateOrgUnit =orgUnitRepository.save(orgUnit);
        return ResponseEntity.ok(updateOrgUnit);
    }

    //Delete A Single OrgUnitUid Record
    @DeleteMapping("/orgunits/{id}")
    public ResponseEntity<OrgUnit> deleteOrgUnitUidRecord(@PathVariable(value = "id") Long OrgUnitUidRecordId){
        OrgUnit orgUnit = orgUnitRepository.getOne(OrgUnitUidRecordId);
        if(orgUnit==null){
            return ResponseEntity.ok().build();
        }
        orgUnitRepository.delete(orgUnit);
        return ResponseEntity.ok().build();
    }
}

