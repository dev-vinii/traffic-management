package br.com.fiap.traffic.service;

import br.com.fiap.traffic.dto.StreetDTO;
import br.com.fiap.traffic.exception.StreetException;
import br.com.fiap.traffic.model.Street;
import br.com.fiap.traffic.repository.StreetRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public StreetDTO save(StreetDTO streetDTO) {
        Street street = new Street();
        BeanUtils.copyProperties(streetDTO, street);
        Street streetSaved = streetRepository.save(street);
        return new StreetDTO(streetSaved);
    }

    public StreetDTO findById(Long id) {
        Optional<Street> streetOptional = streetRepository.findById(id);

        if (streetOptional.isPresent()) return new StreetDTO(streetOptional.get());
        else throw new StreetException("Rua não encontrada!");
    }

    public List<StreetDTO> getAll() {
        return streetRepository
                .findAll()
                .stream()
                .map(StreetDTO::new)
                .toList();
    }

    public void delete(Long id) {
        Optional<Street> streetOptional = streetRepository.findById(id);

        if (streetOptional.isPresent()) streetRepository.delete(streetOptional.get());
        else throw new StreetException("Rua não encontrada!");
    }

    public Street update(Street street) {
        Optional<Street> streetOptional = streetRepository.findById(street.getId());

        if (streetOptional.isPresent()) return streetRepository.save(streetOptional.get());
        else throw new StreetException("Rua não encontrada!");
    }
}