package com.example.mabayaexam.controller;


import com.example.mabayaexam.dto.CampaignRequestDTO;
import com.example.mabayaexam.dto.CampaignResponseDTO;
import com.example.mabayaexam.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping("/create")
    @ResponseBody
    public CampaignResponseDTO createCampaign(@RequestBody CampaignRequestDTO request) {
        return campaignService.createCampaign(request);
    }
}