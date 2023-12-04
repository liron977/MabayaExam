package com.example.mabayaexam.repository;

import com.example.mabayaexam.entities.Campaign;
import com.example.mabayaexam.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT p FROM Campaign c " +
            "JOIN c.products p " +
            "WHERE c.startDate BETWEEN :startDate AND :endDate " +
            "  AND p.category = :category ")
    List<Product> findPromotedProductsInActiveCampaigns(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("category") String category
    );}