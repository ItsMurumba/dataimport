package com.ppm.dataimport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "generalAttributes")
public class GeneralAttributes implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String implementingMechanismUid;

    @NotNull
    @Column
    private String storedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImplementingMechanismUid() {
        return implementingMechanismUid;
    }

    public void setImplementingMechanismUid(String implementingMechanismUid) {
        this.implementingMechanismUid = implementingMechanismUid;
    }

    public String getStoredBy() {
        return storedBy;
    }

    public void setStoredBy(String storedBy) {
        this.storedBy = storedBy;
    }
}
