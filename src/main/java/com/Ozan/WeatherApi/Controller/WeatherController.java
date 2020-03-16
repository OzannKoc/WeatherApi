package com.Ozan.WeatherApi.Controller;

import com.Ozan.WeatherApi.Pojo.Weather;
import com.Ozan.WeatherApi.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Ozan KOÇ
 * Date   : 15.03.2020
 * Time   : 22:33
 */
@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/Ankara")
    public String getWeather(Model model) throws JsonProcessingException {

        model.addAttribute("weatherListAnkara",weatherService.getWeathersList());

        return "weather";
    }
}
