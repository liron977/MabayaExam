package com.example.mabayaexam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CampaignRequestDTO {
    private String name;
    private LocalDate startDate;
    private List<String> productIds;
    private double bid;

}