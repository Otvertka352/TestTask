package com.app.weather.client;

import com.app.weather.property.WeatherProviderProperties;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *  Клиент сайта OpenWether
 */
@Service
@EnableConfigurationProperties(WeatherProviderProperties.class)
public class OpenWeatherClient {

    private final WeatherProviderProperties providerProperties;

    public OpenWeatherClient(WeatherProviderProperties providerProperties) {
        this.providerProperties = providerProperties;
    }

    private String getOpenWeatherBaseUrl(String city) {
        return String.format(providerProperties.getUrl(), city, providerProperties.getKey());
    }


    private String makeResponse(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }

    public String getOpenWeatherJson(String city) throws IOException {
        return makeResponse(getOpenWeatherBaseUrl(city));
    }
}
