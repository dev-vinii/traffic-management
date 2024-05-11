package br.com.fiap.traffic.repository;

import br.com.fiap.traffic.model.TrafficLight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficLightRepository extends JpaRepository<TrafficLight, Long> {
}
