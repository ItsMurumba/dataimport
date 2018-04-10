package com.ppm.dataimport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "general_attributes")
public class GeneralAttributes implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String implementing_mechanism_uid;

    @NotNull
    @Column
    private String stored_by;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImplementing_mechanism_uid() {
        return implementing_mechanism_uid;
    }

    public void setImplementing_mechanism_uid(String implementing_mechanism_uid) {
        this.implementing_mechanism_uid = implementing_mechanism_uid;
    }

    public String getStored_by() {
        return stored_by;
    }

    public void setStored_by(String stored_by) {
        this.stored_by = stored_by;
    }
}
