package com.projects.igritdatacollector.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @Getter @Setter
public class AnnouncementDetailsModel {

    public AnnouncementDetailsModel(String url, String date, String description){
        this.setUrl(url);
        this.setDate(date);
        this.setDescription(description);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private String description;

    @Column
    private String url;



}
