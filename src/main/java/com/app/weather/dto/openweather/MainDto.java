package com.app.weather.dto.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *  Данные из Json.main
 */

@Data
public class MainDto {

    private String temp;
    @JsonProperty("temp_min")
    private double tempMin;
    private int humidity;
    private String pressure;
    private String feels_like;
    @JsonProperty("temp_max")
    private double tempMax;
}
