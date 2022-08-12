package by.barry.activityworker.client;

import by.barry.activityworker.dto.CurrentWeatherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openweathermap", url = "${openweathermap.url}")
public interface OpenWeatherMapClient {
    @GetMapping("/data/2.5/weather")
    CurrentWeatherDto getCurrentWeather(@RequestParam(name = "q") String city, @RequestParam String units, @RequestParam String appid);
}

