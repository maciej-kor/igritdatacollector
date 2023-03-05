package com.projects.igritdatacollector.repository;

import com.projects.igritdatacollector.model.AnnouncementDetailsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDetailsRepository extends CrudRepository<AnnouncementDetailsModel, Long> {
}
