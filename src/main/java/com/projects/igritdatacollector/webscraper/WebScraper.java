package com.projects.igritdatacollector.webscraper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface WebScraper {

    Map<String, String[]> getDateDescription(int numberOfPAgesToScrap);

}
