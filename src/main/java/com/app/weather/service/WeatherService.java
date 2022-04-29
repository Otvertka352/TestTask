package com.app.weather.service;

import com.app.weather.dto.openweather.OpenWeatherDto;
import com.app.weather.dto.WeatherDto;
import com.app.weather.entity.WeatherEntity;
import com.app.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.function.ToDoubleBiFunction;

/**
 * Сервис обработки данных от сайта погоды
 */
@Service
public class WeatherService {

    private final OpenWeatherService openWeatherService;
    private final WeatherRepository weatherRepository;

    public WeatherService(OpenWeatherService openWeatherService, WeatherRepository weatherRepository) {
        this.openWeatherService = openWeatherService;
        this.weatherRepository = weatherRepository;
    }

    public WeatherDto getWeather(String city) {
        OpenWeatherDto openWeatherDto = openWeatherService.getWeatherFromSite(city);
        WeatherEntity weatherEntity = convertToWeatherEntity(openWeatherDto);
        updateWeatherEntity(weatherEntity);
        weatherRepository.save(weatherEntity);

        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setOpenWeather(openWeatherDto);
        weatherDto.setAverage(weatherEntity.getAverage());
        return weatherDto;
    }

    private void updateWeatherEntity(WeatherEntity weatherEntity) {
        double average = (weatherEntity.getMaxTemp()+weatherEntity.getMinTemp())/2;
        average = (Math.round(average*100.0)/100.0);
        weatherEntity.setAverage(average);
    }

    private WeatherEntity convertToWeatherEntity(OpenWeatherDto openWeather) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCityName(openWeather.getName());
        weatherEntity.setMaxTemp(openWeather.getMain().getTempMax());
        weatherEntity.setMinTemp(openWeather.getMain().getTempMin());
        return weatherEntity;
    }

}
