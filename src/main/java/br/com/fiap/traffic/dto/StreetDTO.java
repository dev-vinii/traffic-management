package br.com.fiap.traffic.dto;

import br.com.fiap.traffic.model.Street;
import jakarta.validation.constraints.NotBlank;

public record StreetDTO(
        Long id,
        @NotBlank(message = "O cep da rua não pode ser vazio")
        String cep,
        @NotBlank(message = "O nome da rua não pode ser vazio")
        String name
) {
    public StreetDTO(Street street) {
         this(
                 street.getId(),
                 street.getCep(),
                 street.getName()
         );
    }
}