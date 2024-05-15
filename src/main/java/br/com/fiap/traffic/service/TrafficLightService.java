package br.com.fiap.traffic.service;

import br.com.fiap.traffic.dto.TrafficLightDTO;
import br.com.fiap.traffic.exception.TrafficLightException;
import br.com.fiap.traffic.model.TrafficLight;
import br.com.fiap.traffic.repository.TrafficLightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrafficLightService {

    @Autowired
    TrafficLightRepository trafficLightRepository;

    public List<TrafficLightDTO> getAll() {
        return trafficLightRepository
                .findAll()
                .stream()
                .map(TrafficLightDTO::new)
                .toList();
    };

    public TrafficLightDTO saveTraficLight(TrafficLightDTO trafficLightDTO) {
        TrafficLight trafficLight = new TrafficLight();
        BeanUtils.copyProperties(trafficLightDTO, trafficLight);
        TrafficLight trafficLightSaved = trafficLightRepository.save(trafficLight);
        return new TrafficLightDTO(trafficLightSaved);
    };

    public TrafficLightDTO getById(Long id) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(id);

        if (trafficOptional.isPresent()) return new TrafficLightDTO(trafficOptional.get());
        else throw new TrafficLightException("Semáfaro não encontrado!");
    };

    public void deleteTrafficLight(Long id) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(id);

        if (trafficOptional.isPresent()) trafficLightRepository.delete(trafficOptional.get());
        else throw new TrafficLightException("Semáfaro não encontrado!");
    };

    public TrafficLight updateTrafficLight(TrafficLight trafficLight) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(trafficLight.getId());

        if (trafficOptional.isPresent()) return trafficLightRepository.save(trafficLight);
        else throw new TrafficLightException("Semáfaro não encontrado!");
    };
}
