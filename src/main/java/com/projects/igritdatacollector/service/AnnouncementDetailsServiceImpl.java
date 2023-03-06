package com.projects.igritdatacollector.service;

import com.projects.igritdatacollector.exception.ResourceNotFoundException;
import com.projects.igritdatacollector.model.AnnouncementDetailsModel;
import com.projects.igritdatacollector.repository.AnnouncementDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AnnouncementDetailsServiceImpl implements AnnouncementDetailsService {

    @Autowired
    AnnouncementDetailsRepository announcementDetailsRepository;

    @Override
    public AnnouncementDetailsModel getAnnouncementDetailsModel(Long id) {

        return announcementDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

    }

    @Override
    public List<AnnouncementDetailsModel> getAllAnnouncementDetailsModel() {

        List<AnnouncementDetailsModel> admList = new ArrayList<>();

        admList.addAll(announcementDetailsRepository.findAll());

        return admList;
    }

    @Override
    public void updateDB(String url, String date, String description){

        if (!announcementDetailsRepository.existsByDescription(description)){
            announcementDetailsRepository.save(new AnnouncementDetailsModel(url, date, description));
            System.out.println("saved " + description);
        }

    }

}
