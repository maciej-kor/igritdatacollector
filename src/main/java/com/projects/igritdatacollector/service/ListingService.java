package com.projects.igritdatacollector.service;

import com.projects.igritdatacollector.exception.ListingNotFoundException;
import com.projects.igritdatacollector.model.Listing;
import com.projects.igritdatacollector.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    private final ListingRepository listingRepository;
    @Autowired
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Transactional(readOnly = true)
    public List<Listing> getAllListings(){
        return listingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Listing> getListing(Long id){
        return listingRepository.findById(id);
    }
    @Transactional
    public Listing createListing(Listing listing){
        return listingRepository.save(listing);
    }
    @Transactional
    public Listing updateListing(Long id, Listing updatedListing){
        return listingRepository.findById(id).map(
                existingListing -> {
            existingListing.setDescription(updatedListing.getDescription());
            existingListing.setPostedDate(updatedListing.getPostedDate());
            existingListing.setPrice(updatedListing.getPrice());
            existingListing.setContactNumber(updatedListing.getContactNumber());
            return listingRepository.save(existingListing);
        })
                .orElseThrow(() -> new ListingNotFoundException(id));
    }
    @Transactional
    public void deleteListing(Long id){
        listingRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Listing> getListingsByDescription(String description){
        return listingRepository.findByDescriptionContainingIgnoreCase(description);
    }
    @Transactional(readOnly = true)
    public List<Listing> getListingsByDateRange(LocalDateTime startDate, LocalDateTime endDate){
        return listingRepository.findByPostedDateBetween(startDate, endDate);
    }
    @Transactional(readOnly = true)
    public List<Listing> getListingsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice){
        return listingRepository.findByPriceBetween(minPrice, maxPrice);
    }
    @Transactional(readOnly = true)
    public List<Listing> getListingsByContactNumber(String contactNumber){
        return listingRepository.findByContactNumber(contactNumber);
    }
    @Transactional(readOnly = true)
    public boolean existsById(Long id){
        return listingRepository.existsById(id);
    }
    @Transactional
    public void updateBulkListings(List<Listing> listings){
        listingRepository.saveAll(listings);
    }
//    @Transactional(readOnly = true)
//    public List<Listing> searchListings(String keyword){
//        return listingRepository.searchByKeywords(keyword);
//    }

}
