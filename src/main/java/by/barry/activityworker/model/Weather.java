package by.barry.activityworker.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city", unique = true)
    private String city;

    @Column(name = "temp", nullable = false)
    private Double temp;

    @Column(name = "create_stamp", nullable = false)
    private LocalDateTime createStamp;
}
