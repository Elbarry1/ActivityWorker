package by.barry.activityworker.repository;

import by.barry.activityworker.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather, Integer> {
}
