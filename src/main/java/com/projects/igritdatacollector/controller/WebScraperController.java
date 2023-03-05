package com.projects.igritdatacollector.controller;

import com.projects.igritdatacollector.service.AnnouncementDetailsService;
import com.projects.igritdatacollector.webscraper.WebScraper;
import com.projects.igritdatacollector.webscraper.WebScraperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class WebScraperController {

    @Autowired
    AnnouncementDetailsService announcementDetailsService;

    private WebScraper webScraper;
    private Map<String, String[]> map;
    private int mapSize;

    public WebScraperController(){
        webScraper = new WebScraperImpl();
        map = new LinkedHashMap<>();
    }

    @Scheduled(fixedRate = 1000)
    private void checkLinks(){
        mapSize = map.size();

        map.putAll(webScraper.getDateDescription(1));

        for (String k : map.keySet()){
            map.get(k);
            System.out.println(Arrays.toString(map.get(k)));
        }

        if (mapSize != map.size()){
            pushData();
        }
    }

    public void pushData(){
        Set<String[]> data = new HashSet<>();
        String[] array = new String[3];

        for (String s : map.keySet()){
            array[0] = s;
            array[1] = map.get(s)[0];
            array[2] = map.get(s)[1];
            data.add(array);
        }
        announcementDetailsService.updateDB(data);
    }




}
