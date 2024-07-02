package com.data;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Current {
    
    @SerializedName("last_updated_epoch")
    private int lastUpdatedEpoch;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("temp_c")
    private double tempC;

    @SerializedName("temp_f")
    private double tempF;

    @SerializedName("is_day")
    private int isDay;

    private Condition condition;
    
    @SerializedName("wind_kph")
    private double windKph;

    @SerializedName("wind_degree")
    private int windDegree;

    @SerializedName("wind_dir")
    private String windDir;

    @SerializedName("pressure_mb")
    private double pressureMb;

    @SerializedName("pressure_in")
    private double pressureIn;

    @SerializedName("precip_mm")
    private double precipMm;

    @SerializedName("precip_in")
    private double precipIn;

    private int humidity;
    private int cloud;

    @SerializedName("feelslike_c")
    private double feelslikeC;

    @SerializedName("feelslike_f")
    private double feelslikeF;

    @SerializedName("windchill_c")
    private double windchillC;

    @SerializedName("windchill_f")
    private double windchillF;

    @SerializedName("heatindex_c")
    private double heatindexC;

    @SerializedName("heatindex_f")
    private double heatindexF;

    @SerializedName("dewpoint_c")
    private double dewpointC;

    @SerializedName("dewpoint_f")
    private double dewpointF;

    @SerializedName("vis_km")
    private double visKm;

    @SerializedName("vis_miles")
    private double visMiles;

    private double uv;

    @SerializedName("gust_mph")
    private double gustMph;

    @SerializedName("gust_kph")
    private double gustKph;

}
