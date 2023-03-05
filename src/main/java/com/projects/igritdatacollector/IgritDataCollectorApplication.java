package com.projects.igritdatacollector;

import com.projects.igritdatacollector.webscraper.WebScraper;
import com.projects.igritdatacollector.webscraper.WebScraperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class IgritDataCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgritDataCollectorApplication.class, args);
        WebScraper webScraper = new WebScraperImpl();
        Map<String, String[]> webScraperMap = webScraper.getDateDescription(3);

        for (String key : webScraperMap.keySet()){
            System.out.println(key);
            System.out.println(Arrays.toString(webScraperMap.get(key)));
        }


    }

}
