package com.app.weather.service;

import com.app.weather.client.OpenWeatherClient;
import com.app.weather.dto.openweather.OpenWeatherDto;
import com.app.weather.utils.JsonUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Работа с удаленным сайтом OpenWeather
 */
@Service
public class OpenWeatherService {

    private final OpenWeatherClient openWeatherClient;

    public OpenWeatherService(OpenWeatherClient openWeatherClient) {
        this.openWeatherClient = openWeatherClient;
    }

    public OpenWeatherDto getWeatherFromSite(String city) {
        try {
            String weatherJson = openWeatherClient.getOpenWeatherJson(city);
            OpenWeatherDto openWeatherDto = JsonUtils.jsonToObject(weatherJson);
            return openWeatherDto;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка работы с   сайтом погоды");
        }

    }
}
