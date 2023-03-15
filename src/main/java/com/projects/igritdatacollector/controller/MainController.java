package com.projects.igritdatacollector.controller;

import com.projects.igritdatacollector.model.AnnouncementDetailsModel;
import com.projects.igritdatacollector.service.AnnouncementDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class MainController {

    @Autowired
    AnnouncementDetailsService announcementDetailsService;

    @GetMapping("/")
    public List<AnnouncementDetailsModel> getAllAnnouncement() {
        return announcementDetailsService.getAllAnnouncementDetailsModel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDetailsModel> getAllAnnouncement(@PathVariable Long id) {
        AnnouncementDetailsModel announcementDetailsModel = announcementDetailsService.getAnnouncementDetailsModel(id);
        if (announcementDetailsModel == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(announcementDetailsModel);
        }
    }

}
