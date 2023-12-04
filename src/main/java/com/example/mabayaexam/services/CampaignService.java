package com.example.mabayaexam.services;

import com.example.mabayaexam.dto.CampaignRequestDTO;
import com.example.mabayaexam.dto.CampaignResponseDTO;
import com.example.mabayaexam.entities.Campaign;
import com.example.mabayaexam.entities.Product;
import com.example.mabayaexam.repository.CampaignRepository;
import com.example.mabayaexam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// CampaignService.java
@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ProductRepository productRepository;

    public CampaignResponseDTO createCampaign(CampaignRequestDTO request) {
        List<Product> products = productRepository.findAllById(request.getProductIds());

        Campaign campaign = new Campaign();
        campaign.setName(request.getName());
        campaign.setStartDate(request.getStartDate());
        campaign.setBid(request.getBid());
        campaign.setProducts(products);

        Campaign savedCampaign = campaignRepository.save(campaign);

        return mapToResponse(savedCampaign);
    }

    private CampaignResponseDTO mapToResponse(Campaign campaign) {
        CampaignResponseDTO response = new CampaignResponseDTO();
        response.setId(campaign.getId());
        response.setName(campaign.getName());
        response.setStartDate(campaign.getStartDate());
        response.setBid(campaign.getBid());
        response.setProducts(campaign.getProducts());
        return response;
    }
}