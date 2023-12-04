package com.example.mabayaexam.controller;



import com.example.mabayaexam.dto.AdResponseDTO;
import com.example.mabayaexam.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @GetMapping("/serve")
    public ResponseEntity<AdResponseDTO> serveAd(@RequestParam String category) {
        AdResponseDTO adResponse = adService.serveAd(category);
        if (adResponse != null) {
            return ResponseEntity.ok(adResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}