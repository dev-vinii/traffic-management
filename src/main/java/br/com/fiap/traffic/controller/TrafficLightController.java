package br.com.fiap.traffic.controller;

import br.com.fiap.traffic.model.TrafficLight;
import br.com.fiap.traffic.service.TrafficLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrafficLightController {
    @Autowired
    private TrafficLightService trafficLightService;

    @PostMapping("/trafficlight")
    @ResponseStatus(HttpStatus.CREATED)
    public TrafficLight save(@RequestBody TrafficLight trafficLight){
        return trafficLightService.saveTraficLight(trafficLight);
    }

    @GetMapping("/trafficlight")
    @ResponseStatus(HttpStatus.OK)
    public List<TrafficLight> getAll(){
        return trafficLightService.getAll();
    }

    @GetMapping("/trafficlight/{trafficlightId}")
    public TrafficLight findById(@PathVariable Long trafficLightId){
        return trafficLightService.getById(trafficLightId);
    }

    @DeleteMapping("/trafficlight/{trafficlightId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long trafficLightId){
        trafficLightService.deleteTrafficLight(trafficLightId);
    }

    @PutMapping("/trafficlight")
    @ResponseStatus(HttpStatus.OK)
    public TrafficLight update(@RequestBody TrafficLight trafficLight){
        return trafficLightService.updateTrafficLight(trafficLight);
    }
}
