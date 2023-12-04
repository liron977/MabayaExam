package com.example.mabayaexam.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CampaignRequestDTO {
    private String name;
    private LocalDate startDate;
    private List<String> productIds;
    private double bid;

    public CampaignRequestDTO() {

    }

    public CampaignRequestDTO(String name, LocalDate startDate, List<String> productIds, double bid) {
        this.name = name;
        this.startDate = startDate;
        this.productIds = productIds;
        this.bid = bid;
    }
}