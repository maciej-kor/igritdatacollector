package com.projects.igritdatacollector;

import java.util.List;

public interface AnnouncementDetailsService {

    AnnouncementDetailsModel getAnnouncementDetailsModel (Long id);
    List<AnnouncementDetailsModel> getAllAnnouncementDetailsModel();

}
