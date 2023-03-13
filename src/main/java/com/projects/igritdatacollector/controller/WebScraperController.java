package com.projects.igritdatacollector.controller;

import com.projects.igritdatacollector.service.AnnouncementDetailsService;
import com.projects.igritdatacollector.webscraper.WebScraper;
import com.projects.igritdatacollector.webscraper.WebScraperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class WebScraperController {

    @Autowired
    AnnouncementDetailsService announcementDetailsService;

    private final WebScraper webScraper;
    private Map<String, String[]> map;

    public WebScraperController(){
        webScraper = new WebScraperImpl();
        map = new LinkedHashMap<>();
    }

    @Scheduled(fixedRate = 60000)
    private void checkPagesAndPushDataToDB(){

        map.putAll(webScraper.getUrlDateDescription(1));
        pushDataToDB();

    }

    private void pushDataToDB(){

        for (String key : map.keySet()) {
            announcementDetailsService.updateDB(key, map.get(key)[0], map.get(key)[1]);
           // System.out.println("URL: " + key + "\n" + "Date: " + map.get(key)[0] + "\n" + "Description: " + map.get(key)[1]);
        }
    }



}
