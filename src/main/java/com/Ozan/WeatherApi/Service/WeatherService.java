package com.Ozan.WeatherApi.Service;

import com.Ozan.WeatherApi.Pojo.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Ozan KOÇ
 * Date   : 15.03.2020
 * Time   : 21:59
 */
public interface WeatherService {

    public List<Weather> getWeathersList() throws JsonProcessingException;

}
