package br.com.fiap.traffic.service;

import br.com.fiap.traffic.dto.TrafficLightDTO;
import br.com.fiap.traffic.exception.TrafficLightException;
import br.com.fiap.traffic.model.Street;
import br.com.fiap.traffic.model.TrafficLight;
import br.com.fiap.traffic.repository.StreetRepository;
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
    @Autowired
    StreetRepository streetRepository;

    public List<TrafficLight> getAll() {
        System.out.println((trafficLightRepository
                .findAll()));
        return trafficLightRepository
                .findAll();

    };

    public TrafficLightDTO saveTraficLight(TrafficLightDTO trafficLightDTO) {
        TrafficLight trafficLight = new TrafficLight();
        if (trafficLightDTO.streetId() == null) {
            throw new IllegalArgumentException("Street ID não pode ser nulo");
        }

        Optional<Street> street = streetRepository.findById(trafficLightDTO.streetId());

        BeanUtils.copyProperties(trafficLightDTO, trafficLight);

        trafficLight.setStreet(street.get());

        TrafficLight trafficLightSaved = trafficLightRepository.save(trafficLight);
        return new TrafficLightDTO(trafficLightSaved);
    };

    public TrafficLight getById(Long id) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(id);

        if (trafficOptional.isPresent()) return trafficOptional.get();
        else throw new TrafficLightException("Semáfaro não encontrado!");
    };

    public void deleteTrafficLight(Long id) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(id);

        if (trafficOptional.isPresent()) trafficLightRepository.delete(trafficOptional.get());
        else throw new TrafficLightException("Semáfaro não encontrado!");
    };

    public TrafficLight updateTrafficLight(TrafficLight trafficLight) {
        Optional<TrafficLight> trafficOptional = trafficLightRepository.findById(trafficLight.getId());

        Optional<Street> street = streetRepository.findById(trafficOptional.get().getStreet().getId());

        street.ifPresent(trafficLight::setStreet);

        return trafficLightRepository.save(trafficLight);
    };
}
