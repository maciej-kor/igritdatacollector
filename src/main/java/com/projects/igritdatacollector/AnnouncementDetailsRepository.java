package com.projects.igritdatacollector;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDetailsRepository extends CrudRepository<AnnouncementDetailsModel, Long> {
}
