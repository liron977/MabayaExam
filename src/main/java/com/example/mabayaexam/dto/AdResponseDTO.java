package com.example.mabayaexam.dto;



import com.example.mabayaexam.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdResponseDTO {

    private Product product;

    private double bid;

    public AdResponseDTO() {
    }

    public AdResponseDTO(Product product, double bid) {
        this.product = product;
        this.bid = bid;
    }
}