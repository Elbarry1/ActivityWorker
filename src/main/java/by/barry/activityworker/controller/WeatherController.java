package by.barry.activityworker.controller;

import by.barry.activityworker.client.OpenWeatherMapClient;
import by.barry.activityworker.dto.WeatherResponseDto;
import by.barry.activityworker.mapper.WeatherMapper;
import by.barry.activityworker.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    private final OpenWeatherMapClient openWeatherMapClient;
    private final WeatherService service;
    private final WeatherMapper mapper;

    private final String units;
    private final String appid;

    public WeatherController(
            OpenWeatherMapClient openWeatherMapClient,
            WeatherService service,
            WeatherMapper mapper,
            @Value("${openweathermap.units}") String units,
            @Value("${openweathermap.appid}") String appid
    ) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.service = service;
        this.mapper = mapper;
        this.units = units;
        this.appid = appid;
    }

    @GetMapping("/weather/current/{city}")
    public WeatherResponseDto getCurrentInfo(@PathVariable String city) {
        return mapper.currentWeatherToDto(openWeatherMapClient.getCurrentWeather(city, units, appid));
    }

    @PostMapping("/weather/{city}")
    public ResponseEntity<WeatherResponseDto> save(@PathVariable String city, @RequestBody Double temp) {
        return new ResponseEntity<>(mapper.modelToDto(service.save(city, temp)), HttpStatus.CREATED);
    }
}
