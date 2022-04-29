package com.app.weather.controller;

import com.app.weather.dto.WeatherDto;
import com.app.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 *  Контроллер
 */

@RestController
@RequestMapping("/api")
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/openWeather/{city}")
    public WeatherDto getOpenWeather(@PathVariable final String city) {
        return weatherService.getWeather(city);
    }
}

