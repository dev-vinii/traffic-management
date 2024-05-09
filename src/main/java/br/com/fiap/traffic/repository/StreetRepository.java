package br.com.fiap.traffic.repository;

import br.com.fiap.traffic.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
