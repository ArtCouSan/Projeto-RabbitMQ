package br.com.microservice_a.schedule;

import br.com.microservice_a.endpoint.entity.Drone;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@EnableScheduling
@EnableAutoConfiguration
public class Schedule {

    private final RabbitTemplate rabbitTemplate;
    private final JavaMailSender emailSender;

    public Schedule(RabbitTemplate rabbitTemplate, JavaMailSender emailSender) {
        this.rabbitTemplate = rabbitTemplate;
        this.emailSender = emailSender;
    }

//    @Scheduled(cron = "0 1 * * * *")
    @Scheduled(cron = "30 * * * * *")
    public void sendMail() throws JsonProcessingException {

        Optional<String> data = Optional.empty();

        // Pega a mensagem mais atual
        for (int i = 0; i < 6; i++) {

            Optional<Object> tempData = Optional.ofNullable(rabbitTemplate.receiveAndConvert("drone-data"));

            if (tempData.isPresent()) {
                data = Optional.ofNullable(tempData.get().toString());
            }

        }

        if (data.isPresent()) {

            ObjectMapper mapper = new ObjectMapper();
            List<Drone> drones = mapper.readValue(data.get(), new TypeReference<List<Drone>>() {});

            Optional<List<Drone>> dronesFiltrados = filtarDronePelaTemperaturaEUmidade(drones);

            if (dronesFiltrados.isPresent()) {

                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("<SEU_EMAIL>");
                message.setTo("<SEU_EMAIL>");
                message.setSubject("Data");

                String body = createBodyMail(dronesFiltrados.get());

                message.setText(body);

                emailSender.send(message);

            }

        }

    }

    private Optional<List<Drone>> filtarDronePelaTemperaturaEUmidade(List<Drone> drones) {

        List<Drone> dronesFiltrados = new ArrayList<>();

        for (Drone drone : drones) {

            if (verificarTemperatura(drone.getTemperatura())
                    || verificarUmidade(drone.getUmidade())) {
                dronesFiltrados.add(drone);
            }

        }

        return dronesFiltrados.isEmpty() ? Optional.empty() : Optional.of(dronesFiltrados);

    }

    private Boolean verificarTemperatura(Double temperatura) {
        return (temperatura > 35 || temperatura < 0);
    }

    private Boolean verificarUmidade(Integer umidade) {
        return (umidade < 15);
    }

    private String createBodyMail(List<Drone> drones) {

        String body = "Data: ";

        for (Drone drone : drones) {

            body = body.concat(" Drone id: ")
                    .concat(drone.getId_drone())
                    .concat(" (temperatura : ")
                    .concat(drone.getTemperatura().toString())
                    .concat(")")
                    .concat(" (umidade : ")
                    .concat(drone.getUmidade().toString())
                    .concat(") /n");

        }

        return body;

    }

}

