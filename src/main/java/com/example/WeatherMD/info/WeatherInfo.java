package com.example.WeatherMD.info;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class WeatherInfo {

    private static Document page = getPage();
    private static Elements colThree = getColThree();
    private static Document getPage() {
        String url = "https://pogodnik.com/10707-pogoda-v-kishineve-moldaviya/tomorrow";
        Document page;
        try {
            page = Jsoup.parse(new URL(url), 3000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return page;
    }

    private static Elements getColThree(){
        return page.select("div[class=col col-third]");
    }

    public static String getTime(){
        return Objects.requireNonNull(page.select("div[class=cur-time]").first()).text();
    }
    public static String getDate(){
        String number;
        String month;
        String weekDay;
        Elements elements = page.select("div[class=info clearfix]");

        number = elements.select("div[class=number]").first().text();
        month = elements.select("div[class=month]").first().text();
        weekDay = elements.select("p[class=mob-hide ]").first().text();

        return number + " " + month + " " + weekDay;
    }

    public static String getTemperature(){
        Elements col2 = page.select("div[class=col col-second]");
        return col2.select("div[class=cur-temperature]").text();
    }


    public static String getCondition(){
        Elements col2 = page.select("div[class=col col-second]");
        return col2.select("div[class=cur-air-condition]").text();
    }

    public static String getFellTemperature(){
        return colThree.select("div[class=feel-temperature]").text();
    }

    public static String getTension(){
        return colThree.select("div[class=cur-pressure]").text();
    }

    public static String getHumidity(){
        return colThree.select("div[class=cur-humidity]").text();
    }

    public static String getWind(){
        return colThree.select("div[class=cur-wind]").text();
    }
}
