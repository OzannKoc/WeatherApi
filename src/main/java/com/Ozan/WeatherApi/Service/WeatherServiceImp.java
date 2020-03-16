package com.Ozan.WeatherApi.Service;

import com.Ozan.WeatherApi.DTO.WeatherMapper;
import com.Ozan.WeatherApi.Pojo.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Ozan KOÇ
 * Date   : 15.03.2020
 * Time   : 22:21
 */
@Service
public class WeatherServiceImp implements WeatherService {
    @Autowired
    private WeatherMapper weatherMapper;


    @Override
    public List<Weather> getWeathersList() throws JsonProcessingException {
        return weatherMapper.getWeathersList();
    }
}
