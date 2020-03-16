package com.Ozan.WeatherApi;

import com.Ozan.WeatherApi.Pojo.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class WeatherApiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeatherApiApplication.class, args);

	}


}
