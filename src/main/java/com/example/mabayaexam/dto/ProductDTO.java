package com.example.mabayaexam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private String title;
    private String category;
    private double price;
    private String serialNumber;

}