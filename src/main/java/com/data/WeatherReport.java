package com.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherReport {
    
    private Location location;
    private Current current;

}
