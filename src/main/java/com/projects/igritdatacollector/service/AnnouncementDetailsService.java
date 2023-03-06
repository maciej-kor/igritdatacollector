package com.projects.igritdatacollector.service;

import com.projects.igritdatacollector.model.AnnouncementDetailsModel;

import java.util.List;

public interface AnnouncementDetailsService {

    AnnouncementDetailsModel getAnnouncementDetailsModel (Long id);
    List<AnnouncementDetailsModel> getAllAnnouncementDetailsModel();
    void updateDB(String url, String date, String description);

}
