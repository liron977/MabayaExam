package com.example.mabayaexam.dto;



import com.example.mabayaexam.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class AdResponseDTO {

    private Product product;

    private double bid;

    public AdResponseDTO() {
    }
}