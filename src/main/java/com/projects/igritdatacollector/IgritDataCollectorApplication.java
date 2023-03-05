package com.projects.igritdatacollector;

import com.projects.igritdatacollector.webscraper.WebScraperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class IgritDataCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgritDataCollectorApplication.class, args);
        WebScraperImpl webScraper = new WebScraperImpl();
        Map<String, String[]> scraperMap = webScraper.performScraping("https://igrit.pl/kategoria/gielda-owocow-jablko-deserowe-251?rodzaj=1&page=", 2);
        for (String key : scraperMap.keySet()){
            System.out.println(key);
            System.out.println(Arrays.toString(scraperMap.get(key)));
        }

    }

}
