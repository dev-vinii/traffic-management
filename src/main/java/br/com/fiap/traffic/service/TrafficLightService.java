package br.com.fiap.traffic.service;

import br.com.fiap.traffic.model.TrafficLight;
import br.com.fiap.traffic.repository.TrafficLightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrafficLightService {

    @Autowired
    TrafficLightRepository trafficLightRepository;

    public List<TrafficLight> getAll() {
        return trafficLightRepository.findAll();
    };

    public TrafficLight saveTraficLight(TrafficLight trafficLight) {
        return trafficLightRepository.save(trafficLight);
    };

    public TrafficLight getById(Long id) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(id);

        if (trafficOptional.isPresent()) return trafficOptional.get();
        else throw new RuntimeException("Semáfaro não encontrado!");
    };

    public void deleteTrafficLight(Long id) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(id);

        if (trafficOptional.isPresent()) trafficLightRepository.delete(trafficOptional.get());
        else throw new RuntimeException("Semáfaro não encontrado!");
    };

    public TrafficLight updateTrafficLight(TrafficLight trafficLight) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(trafficLight.getId());

        if (trafficOptional.isPresent()) return trafficLightRepository.save(trafficLight);
        else throw new RuntimeException("Semáfaro não encontrado!");
    };
}
