package com.data;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;

    @SerializedName("tz_id")
    private String tzId;

    @SerializedName("localtime_epoch")
    private int localtimeEpoch;

    private String localtime;
    
}
