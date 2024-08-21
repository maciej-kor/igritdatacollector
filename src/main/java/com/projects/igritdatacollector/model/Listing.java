package com.projects.igritdatacollector.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "posted_date")
    private LocalDateTime postedDate;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "url", length = 255)
    private String url;

    @Column(name = "source", length = 50)
    private String source;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
