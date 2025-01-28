package com.yagyik.productservicedec24.models;


import jakarta.persistence.Entity;
import lombok.Getter;


@Entity(name = "category")
public class Category extends BaseModel {
    private String value;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
