package com.app.weather.utils;

import com.app.weather.dto.openweather.OpenWeatherDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  класс обработки Json
 */

public class JsonUtils {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static OpenWeatherDto jsonToObject(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, OpenWeatherDto.class);
    }
}
