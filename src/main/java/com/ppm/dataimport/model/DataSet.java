package com.ppm.dataimport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "data_set")
public class DataSet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String data_set_name;

    @NotNull
    private String data_element_name;

    @NotNull
    @Column(unique = true)
    private String category_option_combo;

    @NotNull
    @Column(unique = true)
    private String attributes_option_combo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_set_name() {
        return data_set_name;
    }

    public void setData_set_name(String data_set_name) {
        this.data_set_name = data_set_name;
    }

    public String getData_element_name() {
        return data_element_name;
    }

    public void setData_element_name(String data_element_name) {
        this.data_element_name = data_element_name;
    }

    public String getCategory_option_combo() {
        return category_option_combo;
    }

    public void setCategory_option_combo(String category_option_combo) {
        this.category_option_combo = category_option_combo;
    }

    public String getAttributes_option_combo() {
        return attributes_option_combo;
    }

    public void setAttributes_option_combo(String attributes_option_combo) {
        this.attributes_option_combo = attributes_option_combo;
    }
}
