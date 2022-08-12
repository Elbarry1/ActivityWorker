package by.barry.activityworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ActivityWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityWorkerApplication.class, args);
    }

}
