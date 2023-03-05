package com.projects.igritdatacollector;

import com.projects.igritdatacollector.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementDetailsServiceImpl implements AnnouncementDetailsService{

    @Autowired
    private AnnouncementDetailsRepository announcementDetailsRepository;

    @Override
    public AnnouncementDetailsModel getAnnouncementDetailsModel(Long id) {

        return announcementDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

    }

    @Override
    public List<AnnouncementDetailsModel> getAllAnnouncementDetailsModel() {

        List<AnnouncementDetailsModel> admList = new ArrayList<>();

        for (AnnouncementDetailsModel adm : announcementDetailsRepository.findAll()){
            admList.add(adm);
        }

        return admList;
    }
}
