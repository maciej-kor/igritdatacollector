package com.projects.igritdatacollector;

import com.projects.igritdatacollector.model.Listing;
import com.projects.igritdatacollector.repository.ListingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ListingRepositoryTest {
    @Autowired
    private ListingRepository listingRepository;

    @Test
    public void saveListingsAndReturn(){
        Listing listing1 = new Listing(1L, "description1", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
        Listing listing2 = new Listing(2L, "description2", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
        Listing listing3 = new Listing(3L, "description3", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
        Listing listing4 = new Listing(4L, "description4", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());

        Listing savedListing = listingRepository.save(listing1);

        Assertions.assertThat(savedListing).isNotNull();
        Assertions.assertThat(savedListing.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllReturnMoreThanOneListing(){
        Listing listing1 = new Listing(1L, "description1", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
        Listing listing2 = new Listing(2L, "description2", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());

        listingRepository.save(listing1);
        listingRepository.save(listing2);

        List<Listing> listings = listingRepository.findAll();

        Assertions.assertThat(listings.size()).isEqualTo(2);
    }

    @Test
    public void findByDescription(){
        Listing listing1 = new Listing(1L, "description1", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
        Listing listing2 = new Listing(2L, "description2", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());

        listingRepository.save(listing1);
        listingRepository.save(listing2);

        List<Listing> listings = listingRepository.findByDescriptionContainingIgnoreCase(listing1.getDescription());

        Assertions.assertThat(listings).isNotNull();
    }

}
