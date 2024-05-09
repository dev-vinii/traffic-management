package br.com.fiap.traffic.controller;

import br.com.fiap.traffic.model.Street;
import br.com.fiap.traffic.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @PostMapping("street")
    @ResponseStatus(HttpStatus.CREATED)
    public Street save(@RequestBody Street street){
        return streetService.save(street);
    }

    @GetMapping("street")
    @ResponseStatus(HttpStatus.OK)
    public List<Street> getAll(){
        return streetService.getAll();
    }

    @GetMapping("street/{streetId}")
    public Street findById(@PathVariable Long streetId){
        return streetService.findById(streetId);
    }

    @DeleteMapping("street/{streetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long streetId){
        streetService.delete(streetId);
    }

    @PutMapping("street")
    @ResponseStatus(HttpStatus.OK)
    public Street update(@RequestBody Street street){
        return streetService.update(street);
    }
}
