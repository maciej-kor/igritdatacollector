package com.projects.igritdatacollector.service;

import com.projects.igritdatacollector.model.AnnouncementDetailsModel;

import java.util.List;
import java.util.Set;

public interface AnnouncementDetailsService {

    AnnouncementDetailsModel getAnnouncementDetailsModel (Long id);
    List<AnnouncementDetailsModel> getAllAnnouncementDetailsModel();
    void updateDB(Set<String[]> announcementDetails);

}
