package com.projects.igritdatacollector.controller;

import com.projects.igritdatacollector.exception.ListingNotFoundException;
import com.projects.igritdatacollector.model.Listing;
import com.projects.igritdatacollector.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService listingService;
    @Autowired
    public ListingController(ListingService listingService){
        this.listingService = listingService;
    }
    @GetMapping
    public ResponseEntity<List<Listing>> getAllListings(){
        List<Listing> listings = listingService.getAllListings();
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Listing> getListing(@PathVariable Long id){
        Optional<Listing> optionalListing = listingService.getListing(id);
        return optionalListing.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Listing> createListing(@RequestBody Listing listing){
        Listing createdListing = listingService.createListing(listing);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdListing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable Long id, @RequestBody Listing updatedListing){
        try {
            Listing updated = listingService.updateListing(id, updatedListing);
            return ResponseEntity.ok(updated);
        } catch (ListingNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable Long id){
        try{
            listingService.deleteListing(id);
            return ResponseEntity.noContent().build();
        } catch (ListingNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/keyword-search")
//    public ResponseEntity<List<Listing>> searchListing(@RequestParam String keyword) {
//        List<Listing> listings = listingService.searchListings(keyword);
//        if (listings.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(listings);
//        }
//    }

}
