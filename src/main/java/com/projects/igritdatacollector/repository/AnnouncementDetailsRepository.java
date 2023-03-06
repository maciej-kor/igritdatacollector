package com.projects.igritdatacollector.repository;

import com.projects.igritdatacollector.model.AnnouncementDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDetailsRepository extends JpaRepository<AnnouncementDetailsModel, Long> {
    boolean existsByDescription(String description);
}
