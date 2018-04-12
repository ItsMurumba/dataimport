package com.ppm.dataimport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "dataElements")
public class DataElement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String dataElementName;

    @NotNull
    @Column(unique = true)
    private String categoryOptionCombo;

    @NotNull
    @Column(unique = true)
    private String attributesOptionCombo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataElementName() {
        return dataElementName;
    }

    public void setDataElementName(String dataElementName) {
        this.dataElementName = dataElementName;
    }

    public String getCategoryOptionCombo() {
        return categoryOptionCombo;
    }

    public void setCategoryOptionCombo(String categoryOptionCombo) {
        this.categoryOptionCombo = categoryOptionCombo;
    }

    public String getAttributesOptionCombo() {
        return attributesOptionCombo;
    }

    public void setAttributesOptionCombo(String attributesOptionCombo) {
        this.attributesOptionCombo = attributesOptionCombo;
    }
}
