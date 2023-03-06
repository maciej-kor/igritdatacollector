package com.projects.igritdatacollector.webscraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WebScraperImpl implements WebScraper {

    private static final String url = "https://igrit.pl/kategoria/gielda-owocow-jablko-deserowe-251?rodzaj=1&page=";

    @Override
    public Map<String, String[]> getUrlDateDescription(int numberOfPagesToScrap) {

        return performScraping(url, numberOfPagesToScrap);

    }

    private Map<String, String[]> performScraping(String mainPageUrl, int numberOfPages) {

        Set<String> links = new HashSet<>();
        Map<String, String[]> finalMap = new HashMap<>();

        // Get all sitelinks
        for (int i = 1; i <= numberOfPages; i++) {
            links.addAll(getAllLinksFromSpecificPageNumber(url, i));
        }

        // Open each subpage then save date and description
        for (String set : links) {
            finalMap.putAll(collectAnnouncementDetails(set));
        }

        return finalMap;
    }

    private Set<String> getAllLinksFromSpecificPageNumber(String url, int pageNumber) {

        Set<String> linksSet = new HashSet<>();
        String pageUrl = url.concat(Integer.toString(pageNumber));
        String authority = url.substring(0, 16);

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage(pageUrl);
            List<HtmlAnchor> urls = htmlPage.getByXPath("//*[contains(@class, 'd-flex align-items-start')]/a");

            for (HtmlAnchor htmlAnchor : urls) {
                linksSet.add(authority.concat(htmlAnchor.getAttributeNode("href").getValue()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return linksSet;
    }

    private Map<String, String[]> collectAnnouncementDetails(String linkToTheAnnouncement) {

        Map<String, String[]> urlAndDetailsMap = new HashMap<>();
        String[] dateAndDescription = new String[2];

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage(linkToTheAnnouncement);
            HtmlParagraph descriptionP = htmlPage.getFirstByXPath("//*[contains(@class, 'description text-14-px line-height-1-5')]/p");
            HtmlSpan dateI = htmlPage.getFirstByXPath("//*[contains(@class, 'date')]");

            dateAndDescription[1] = descriptionP.getTextContent();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(dateI.getTextContent().substring(8, 25), formatter);
            dateAndDescription[0] = localDateTime.toString();

            urlAndDetailsMap.put(linkToTheAnnouncement, dateAndDescription);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return urlAndDetailsMap;

    }
}
