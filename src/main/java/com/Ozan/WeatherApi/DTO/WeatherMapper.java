package com.Ozan.WeatherApi.DTO;

import com.Ozan.WeatherApi.Pojo.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Ozan KOÇ
 * Date   : 15.03.2020
 * Time   : 21:36
 */
public interface WeatherMapper {
    public String getWeathersAsString();
    public List<Weather> getWeathersList() throws JsonProcessingException;
    public Weather setWeatherProperties(String temp , String humidity,String pressure ,String date,String description);

}
