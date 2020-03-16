package com.Ozan.WeatherApi.DTO;

import com.Ozan.WeatherApi.Pojo.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Ozan KOÇ
 * Date   : 15.03.2020
 * Time   : 17:24
 */
@Component
public class WeatherMapperImp implements WeatherMapper {


    // get Json from openweahtermap's api
    @Override
    public String getWeathersAsString() {
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=323784&APPID=cc4588835c852a78e26e2bbdc5470af0";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        String weathers =responseEntity.getBody();
        return weathers;
    }
    //get json's data as list.When we use JsonNode , we can reach json's object with key value like "node.get("list")"
    @Override
    public List<Weather> getWeathersList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(getWeathersAsString());
        List<Weather> myWeatherList = new ArrayList<Weather>();
        for (int i=0 ;i<=13 ;i++){
            String tempOfTheTime= node.get("list").get(i).get("main").get("temp").asText();
            String humidityOfTheTime= node.get("list").get(i).get("main").get("humidity").asText();
            String pressureOfTheTime= node.get("list").get(i).get("main").get("pressure").asText();
            String dateOfTheTime= node.get("list").get(i).get("dt_txt").asText();
            String weatherOfTheTime = node.get("list").get(i).get("weather").get(0).get("description").asText();
            myWeatherList.add(setWeatherProperties(tempOfTheTime,humidityOfTheTime,pressureOfTheTime,dateOfTheTime,weatherOfTheTime));
        }

        return myWeatherList;
    }

    @Override
    public Weather setWeatherProperties(String temp, String humidity, String pressure, String date,String description) {
        Weather weather = new Weather();
        weather.setTemp(tempParser(temp));
        weather.setHumidity(humidity);
        weather.setPressure(pressure);
        weather.setDate(date);
        setWeatherDescriptionImage(description,weather);

        return weather;
    }
    public String tempParser(String temp){
        double newTemp=(Double.parseDouble(temp)-272.15);
        String tempAsString = String.valueOf(newTemp);
        int pointIndex =tempAsString.indexOf(".");
        tempAsString = tempAsString.substring(0,pointIndex);
        tempAsString = tempAsString+" "+"\u2103";
        return tempAsString;
    }
    public void setWeatherDescriptionImage(String description,Weather weather){
        if(description.equals("light snow")){
            weather.setWeatherDescription("snow_light.png");
        }
        else if(description.equals("broken clouds")){
            weather.setWeatherDescription("broken_cloud.png");
        }
        else if(description.equals("clear sky")){
            weather.setWeatherDescription("sunny.png");
        }
        else if (description.equals("few clouds")){
            weather.setWeatherDescription("sunny_s_cloudy.png");
        }
        else if (description.equals("scattered clouds")){
            weather.setWeatherDescription("partly_cloudy.png");
        }
        else if(description.equals("snow")){
            weather.setWeatherDescription("snow.png");
        }
        else if(description.equals("overcast clouds")){
            weather.setWeatherDescription("cloudy.png");
        }
        else if(description.equals("light rain")){
            weather.setWeatherDescription("rain_s_cloudy.png");
        }
    }

}
