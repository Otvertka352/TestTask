package com.app.weather.dto;

import com.app.weather.dto.openweather.OpenWeatherDto;
import lombok.Data;

/**
 *  Данные на выход
 */

@Data
public class WeatherDto {

    private OpenWeatherDto openWeather;
    private Double average;
}
