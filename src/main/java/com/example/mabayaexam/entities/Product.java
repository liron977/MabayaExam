package com.example.mabayaexam.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private String serialNumber;

    private String title;
    private String category;
    private double price;

}