package com.app.weather.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *  Класс подключения properties
 */

@ConfigurationProperties(prefix = "weather.provider")
@Data
public class WeatherProviderProperties {

    private String url;
    private String key;
}
