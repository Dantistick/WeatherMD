package com.example.WeatherMD.controllers;

import com.example.WeatherMD.entity.Weather;
import com.example.WeatherMD.info.WeatherInfo;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @GetMapping("/")
    public String showWeather(Model model) {
        Weather weather = new Weather();
        weather.setDate(WeatherInfo.getDate());
        weather.setTime(WeatherInfo.getTime());
        weather.setTemperature(WeatherInfo.getTemperature());
        weather.setFellTemperature(WeatherInfo.getFellTemperature());
        weather.setCondition(WeatherInfo.getCondition());
        weather.setHumidity(WeatherInfo.getHumidity());
        weather.setTension(WeatherInfo.getTension());
        weather.setWind(WeatherInfo.getWind()
        );

        model.addAttribute("weather", weather);
        return "weather-template";
    }
}
