package com.app.weather.dto.openweather;

import lombok.Data;

/**
 *  Данные из Json
 */

@Data
public class OpenWeatherDto {

    private MainDto main;
    private String name;
}
