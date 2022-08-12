package by.barry.activityworker.service;

import by.barry.activityworker.model.Weather;
import by.barry.activityworker.repository.WeatherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepo repo;

    @Transactional
    public Weather save(String city, Double temp) {
        Weather weather = new Weather();
        weather.setCity(city);
        weather.setTemp(temp);
        weather.setCreateStamp(LocalDateTime.now());
        return repo.save(weather);
    }
}
