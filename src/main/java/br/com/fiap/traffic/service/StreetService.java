package br.com.fiap.traffic.service;

import br.com.fiap.traffic.model.Street;
import br.com.fiap.traffic.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public Street save(Street street) {
        return streetRepository.save(street);
    }

    public Street findById(Long id) {
        Optional<Street> streetOptional = streetRepository.findById(id);

        if (streetOptional.isPresent()) return streetOptional.get();
        else throw new RuntimeException("Rua não encontrada!");
    }

    public List<Street> getAll() {
        return streetRepository.findAll();
    }

    public void delete(Long id) {
        Optional<Street> streetOptional = streetRepository.findById(id);

        if (streetOptional.isPresent()) streetRepository.delete(streetOptional.get());
        else throw new RuntimeException("Rua não encontrada!");
    }

    public Street update(Street street) {
        Optional<Street> streetOptional = streetRepository.findById(street.getId());

        if (streetOptional.isPresent()) return streetRepository.save(streetOptional.get());
        else throw new RuntimeException("Rua não encontrada!");
    }
}