package com.example.mabayaexam.services;


import com.example.mabayaexam.dto.AdResponseDTO;
import com.example.mabayaexam.entities.Campaign;
import com.example.mabayaexam.entities.Product;
import com.example.mabayaexam.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class AdService {
    @Autowired
    private CampaignRepository campaignRepository;

    public AdResponseDTO serveAd(String category) {

        // Filter campaigns based on the 10-day rule
        List<Campaign> activeCampaigns = campaignRepository.findByStartDateBetween(
                LocalDate.now().minusDays(10),
                LocalDate.now());
        if (activeCampaigns.isEmpty()) {
            return null; // No active campaigns
        }

        // Find all campaigns with the highest bid in the specified category
        List<Campaign> highestBidCampaigns = activeCampaigns.stream()
                .filter(campaign -> campaign.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals(category)))
                .collect(Collectors.groupingBy(Campaign::getBid))
                .entrySet().stream()
                .sorted(Comparator.comparingDouble((Map.Entry<Double, List<Campaign>> entry) -> entry.getKey()).reversed())
                .findFirst()
                .map(entry -> entry.getValue())
                .orElse(Collections.emptyList());

        if (!highestBidCampaigns.isEmpty()) {
            // Find all products with their bids in the specified category from the highest bid campaigns
            List<Product> productsInCategory = highestBidCampaigns.stream()
                    .flatMap(campaign -> campaign.getProducts().stream())
                    .filter(product -> product.getCategory().equals(category))
                    .collect(Collectors.toList());

            if (!productsInCategory.isEmpty()) {
                // Map each product to AdResponseDTO
                return (mapToAdResponse(productsInCategory.get(0), highestBidCampaigns.get(0)));
            }

        }
        else {
            Campaign highestBidCampaign = activeCampaigns.stream()
                    .max(Comparator.comparingDouble(Campaign::getBid))
                    .orElse(null);

            if (highestBidCampaign != null) {
                Product highestBidProduct = highestBidCampaign.getProducts().stream()
                        .max(Comparator.comparingDouble(Product::getPrice))
                        .orElse(null);
                return (mapToAdResponse(highestBidProduct,highestBidCampaign));
            }
        }
        return null; // No active campaigns or promoted products
    }
    private AdResponseDTO mapToAdResponse(Product products, Campaign campaign) {
        AdResponseDTO adResponse = new AdResponseDTO();
        adResponse.setProduct(products);
        adResponse.setBid(campaign.getBid());
        return adResponse;
    }

}