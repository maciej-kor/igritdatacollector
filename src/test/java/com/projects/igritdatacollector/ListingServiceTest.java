package com.projects.igritdatacollector;

import com.projects.igritdatacollector.model.Listing;
import com.projects.igritdatacollector.repository.ListingRepository;
import com.projects.igritdatacollector.service.ListingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ListingServiceTest {

    Listing listing1 = new Listing(1L, "description1", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
    Listing listing2 = new Listing(2L, "description2", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
    Listing listing3 = new Listing(3L, "description3", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());
    Listing listing4 = new Listing(4L, "description4", LocalDateTime.now(), new BigDecimal(200), "666777888", "URL1", "SOURCE1", LocalDateTime.now(), LocalDateTime.now());

    @Mock
    private ListingRepository listingRepository;

    @InjectMocks
    private ListingService listingService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


}
