package by.barry.activityworker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentWeatherDto {

    @JsonProperty("main")
    MainInfo mainInfo;

    String name;

    @Data
    public static class MainInfo {
        double temp;
    }

}
