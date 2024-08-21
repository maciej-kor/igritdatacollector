package com.projects.igritdatacollector.repository;

import com.projects.igritdatacollector.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findByDescriptionContainingIgnoreCase(String description);
    List<Listing> findByPostedDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Listing> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Listing> findByContactNumber(String contactNumber);
    @Query("SELECT l FROM Listing l WHERE l.description LIKE %:keyword%")
    List<Listing> searchByKeyword(@Param("keyword") String keyword);

}
