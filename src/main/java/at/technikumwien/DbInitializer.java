package at.technikumwien;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.List;

@Configuration
public class DbInitializer {
    private final CarRepository carRepository;

    public DbInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent() {
        carRepository.saveAll(
                List.of(
                        new Car("Ford", "Mustang", 1964),
                        new Car("Porsche", "911", 1963)
                )
        );
    }
}