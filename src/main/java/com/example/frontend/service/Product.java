package com.example.frontend.service;

import java.io.Serializable;

public class Product implements Serializable {

    private long id;
    private String name;
    private int kcal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
