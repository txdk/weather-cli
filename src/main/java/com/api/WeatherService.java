package com.api;

import com.data.WeatherReport;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("current.json")
    @Headers("Accept: Application/json")
    Call<WeatherReport> getWeather(@Query("key") String apiKey, @Query("q") String location);
}
