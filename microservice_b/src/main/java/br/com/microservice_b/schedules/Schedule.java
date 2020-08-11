package br.com.microservice_b.schedules;

import br.com.microservice_b.endpoint.config.ConfigRabbitMQ;
import br.com.microservice_b.endpoint.entity.Drone;
import br.com.microservice_b.endpoint.repository.DroneRepository;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
@EnableAutoConfiguration
public class Schedule {

    private final DroneRepository droneRepository;
    private final RabbitTemplate rabbitTemplate;

    public Schedule(DroneRepository droneRepository, RabbitTemplate rabbitTemplate) {
        this.droneRepository = droneRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(cron = "10 * * * * *")
    public void verificarTemperatura_Umidade() {

        List<Drone> drones = droneRepository.findAll();

        Gson json = new Gson();
        String data = json.toJson(drones);

        rabbitTemplate.convertAndSend(ConfigRabbitMQ.EXCHANGE_NAME, "drone.data", data);

    }

}
