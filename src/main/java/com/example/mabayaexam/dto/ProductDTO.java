package com.example.mabayaexam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String title;
    private String category;
    private double price;
    private String serialNumber;

    public ProductDTO() {
    }

    public ProductDTO(String title, String category, double price, String serialNumber) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.serialNumber = serialNumber;
    }

}