package br.com.fiap.traffic.dto;

import br.com.fiap.traffic.model.TrafficLight;
import jakarta.validation.constraints.NotBlank;

public record TrafficLightDTO(
        Long id,
        @NotBlank(message = "O tempo para abrir não pode ser vazio")
        int timeToOpen,
        boolean pedestrianTrafficLight,
        @NotBlank(message = "O marca não pode ser vazia")
        String brand,
        Long streetId
) {
    public TrafficLightDTO(TrafficLight trafficLight) {
        this(
                trafficLight.getId(),
                trafficLight.getTimeToOpen(),
                trafficLight.isPedestrianTrafficLight(),
                trafficLight.getBrand(),
                trafficLight.getStreet().getId()
        );
    }
}