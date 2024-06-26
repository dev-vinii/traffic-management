package br.com.fiap.traffic.controller;

import br.com.fiap.traffic.dto.StreetDTO;
import br.com.fiap.traffic.model.Street;
import br.com.fiap.traffic.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @PostMapping("/street")
    @ResponseStatus(HttpStatus.CREATED)
    public StreetDTO save(@RequestBody StreetDTO streetDTO){
        return streetService.save(streetDTO);
    }

    @GetMapping("/street")
    @ResponseStatus(HttpStatus.OK)
    public List<StreetDTO> getAll(){
        return streetService.getAll();
    }

    @GetMapping("/street/{streetId}")
    public StreetDTO findById(@PathVariable Long streetId){
        return streetService.findById(streetId);
    }

    @DeleteMapping("/street/{streetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long streetId){
        streetService.delete(streetId);
    }

    @PutMapping("/street/{streetId}")
    @ResponseStatus(HttpStatus.OK)
    public Street update(@PathVariable Long streetId, @RequestBody Street street){
        return streetService.update(streetId, street);
    }
}
