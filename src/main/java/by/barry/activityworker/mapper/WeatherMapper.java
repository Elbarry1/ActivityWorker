package by.barry.activityworker.mapper;

import by.barry.activityworker.dto.CurrentWeatherDto;
import by.barry.activityworker.dto.WeatherResponseDto;
import by.barry.activityworker.model.Weather;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = LocalDateTime.class)
public interface WeatherMapper {

    WeatherResponseDto modelToDto(Weather model);

    @Mapping(target = "city", source = "name")
    @Mapping(target = "temp", source = "mainInfo.temp")
    @Mapping(target = "createStamp", expression = "java(LocalDateTime.now())")
    WeatherResponseDto currentWeatherToDto(CurrentWeatherDto dto);
}
