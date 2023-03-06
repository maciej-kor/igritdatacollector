package com.projects.igritdatacollector.webscraper;

import java.util.Map;

public interface WebScraper {

    Map<String, String[]> getUrlDateDescription(int numberOfPAgesToScrap);

}
