package br.com.fiap.traffic.controller;

import br.com.fiap.traffic.dto.TrafficLightDTO;
import br.com.fiap.traffic.model.TrafficLight;
import br.com.fiap.traffic.service.TrafficLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trafficlight")
public class TrafficLightController {
    @Autowired
    private TrafficLightService trafficLightService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrafficLightDTO save(@RequestBody TrafficLightDTO trafficLightDTO){
        return trafficLightService.saveTraficLight(trafficLightDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrafficLight> getAll(){
        return trafficLightService.getAll();
    }

    @GetMapping("/{trafficLightId}")
    public TrafficLight findById(@PathVariable Long trafficLightId){
        return trafficLightService.getById(trafficLightId);
    }

    @DeleteMapping("/{trafficLightId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long trafficLightId){
        trafficLightService.deleteTrafficLight(trafficLightId);
    }

    @PutMapping("/{trafficLightId}")
    @ResponseStatus(HttpStatus.OK)
    public TrafficLight update(@PathVariable Long trafficLightId, @RequestBody TrafficLight trafficLight){
        trafficLight.setId(trafficLightId);
        return trafficLightService.updateTrafficLight(trafficLight);
    }
}
